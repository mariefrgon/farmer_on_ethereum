package main.java.bfm.farmer;

import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Launcher {

    public enum USERS {Farmer, Investor1, Investor2, Client, Cowbreeder;}

    public static void main(String[] args) throws Exception {

        IHM ihm = new IHM();

        //CREATE SMART CONTRACT
        ihm.promptInitMenu();
        long duration = ihm.promptMaxDuration();
        double goal = ihm.promptGoalAmount();
        double milkPrice = ihm.promptMilkPrice();

        Deployer deployer = new Deployer();
        Farminginvestment contract = deployer.transferContract(
                BigInteger.valueOf(duration),
                doubleEtherToBigIntegerWei(goal),
                doubleEtherToBigIntegerWei(milkPrice));

        String contractAddress = contract.getContractAddress();
        ihm.confirmContractDeployment(contractAddress);

        int cmd;
        while(true) {
            int user = ihm.promptMenu();
            switch (USERS.values()[user]) {
                case Farmer:
                    cmd = ihm.promptFarmerMenu();

                    //refund investors
                    if(cmd == 0){
                        ihm.printBalance(USERS.Investor1, deployer.getBalance(USERS.Investor1));
                        ihm.printBalance(USERS.Investor2, deployer.getBalance(USERS.Investor2));

                        contract = deployer.getContract(contractAddress, USERS.Farmer);
                        contract.refund();

                        ihm.confirmRefundRequest();

                        ihm.printBalance(USERS.Investor1, deployer.getBalance(USERS.Investor1));
                        ihm.printBalance(USERS.Investor2, deployer.getBalance(USERS.Investor2));
                    }
                    break;

                case Investor1:
                    contract = deployer.getContract(contractAddress, USERS.Investor1);
                    cmd = ihm.promptInvestorMenu();

                    //invest
                    if (cmd == 0) {
                        ihm.printBalance(USERS.Investor1, deployer.getBalance(USERS.Investor1));

                        double investmentAmount = ihm.promptAmountToInvest();
                        contract.invest(doubleEtherToBigIntegerWei((investmentAmount)));

                        ihm.printBalance(USERS.Investor1, deployer.getBalance(USERS.Investor1));
                    }
                    //ask for refund
                    else if(cmd == 1){
                        //TODO: copier coller refund
                    }

                    break;

                case Investor2:
                    //TODO: copier coller investor1
                    break;

                case Client:
                    //TODO: seulement permettre ça quand les vaches sont achetées (?) -> ou alors non parce que solidity s'en occupe
                    cmd = ihm.promptClientMenu();
                    if (cmd == 0) {
                        long milkAmount = ihm.promptMilkAmount();
                        contract = deployer.getContract(contractAddress, USERS.Client);
                        contract.buyMilk(BigInteger.valueOf(milkAmount), doubleEtherToBigIntegerWei(milkPrice*milkAmount));
                        ihm.confimMilkPurchase();

                        ihm.printBalance(USERS.Farmer, deployer.getBalance(USERS.Farmer));
                        ihm.printBalance(USERS.Investor1, deployer.getBalance(USERS.Investor1));
                        ihm.printBalance(USERS.Investor2, deployer.getBalance(USERS.Investor2));
                    }
                    break;
                case Cowbreeder:
                    cmd = ihm.promptCowbreederMenu();
                    if(cmd == 0){
                        ihm.printBalance(USERS.Cowbreeder, deployer.getBalance(USERS.Cowbreeder));
                    }
                    break;
            }
        }


    }


    private static BigInteger doubleEtherToBigIntegerWei(double ether){
        return Convert.toWei(String.valueOf(ether), Convert.Unit.ETHER).toBigIntegerExact();
    }




}
