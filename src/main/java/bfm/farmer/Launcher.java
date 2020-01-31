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
                    if(cmd == 0){
                        contract = deployer.getContract(contractAddress, USERS.Farmer);
                        contract.refund();
                    }
                case Investor1:
                    contract = deployer.getContract(contractAddress, USERS.Investor1);
                    cmd = ihm.promptInvestorMenu();
                    if (cmd == 0) {
                        //System.out.println("your balance in wei: " + deployer.getBalance(USERS.Investor1));
                        long investmentAmount = ihm.promptAmountToInvest();
                        contract.invest(BigInteger.valueOf(investmentAmount));
                        //System.out.println("your balance in wei: " + deployer.getBalance(USERS.Investor1));
                    }
                    else if(cmd == 1){
                        contract = deployer.getContract(contractAddress, USERS.Investor1);
                        contract.refund();
                    }

                    break;
                case Investor2:
                    contract = deployer.getContract(contractAddress, USERS.Investor2);
                    cmd = ihm.promptInvestorMenu();
                    if (cmd == 0) {
                        //TODO: montrer l'argent de la personne
                        long investmentAmount = ihm.promptAmountToInvest();
                        contract.invest(doubleEtherToBigIntegerWei(investmentAmount)).send();
                        //TODO: montrer l'argent de la personne
                    }
                    break;
                case Client:
                    //TODO: seulement permettre ça quand les vaches sont achetées (?) -> ou alors non parce que solidity s'en occupe
                    cmd = ihm.promptClientMenu();
                    if (cmd == 0) {
                        long milkAmount = ihm.promptMilkAmount();
                        contract = deployer.getContract(contractAddress, USERS.Client);
                        contract.buyMilk(BigInteger.valueOf(milkAmount), doubleEtherToBigIntegerWei(milkPrice*milkAmount));
                        //TODO: montrer l'argent du client + investisseur + farmer
                    }
                    break;
                default:
                    break;
            }
        }



        //Deployer deployer = new Deployer();
        //Farminginvestment fi = deployer.transferContract();

        //Farminginvestment fi2 = deployer.getContract(fi.getContractAddress(), "pete");

    }


    private static BigInteger doubleEtherToBigIntegerWei(double ether){
        return Convert.toWei(String.valueOf(ether), Convert.Unit.ETHER).toBigIntegerExact();
    }




}
