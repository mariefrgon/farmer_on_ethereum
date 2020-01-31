package main.java.bfm.farmer;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import rx.functions.Action1;

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
                        refundInvestors(ihm, deployer, contractAddress);
                    }
                    break;

                case Investor1:
                    cmd = ihm.promptInvestorMenu();

                    //invest
                    if (cmd == 0) {
                        contract = deployer.getContract(contractAddress, USERS.Investor1);
                        ihm.printBalance(USERS.Investor1, deployer.getBalance(USERS.Investor1));

                        double investmentAmount = ihm.promptAmountToInvest();
                        contract.invest(doubleEtherToBigIntegerWei((investmentAmount))).send();

                        ihm.printBalance(USERS.Investor1, deployer.getBalance(USERS.Investor1));

                        printContractBalance(deployer, contractAddress);
                    }
                    else if(cmd == 1){
                        refundInvestors(ihm, deployer, contractAddress);
                    }

                    break;

                case Investor2:
                    cmd = ihm.promptInvestorMenu();
                    //invest
                    if (cmd == 0) {
                        contract = deployer.getContract(contractAddress, USERS.Investor2);
                        ihm.printBalance(USERS.Investor2, deployer.getBalance(USERS.Investor2));

                        double investmentAmount = ihm.promptAmountToInvest();
                        contract.invest(doubleEtherToBigIntegerWei((investmentAmount))).send();

                        ihm.printBalance(USERS.Investor2, deployer.getBalance(USERS.Investor2));

                        printContractBalance(deployer, contractAddress);
                    }
                    else if(cmd == 1){
                        refundInvestors(ihm, deployer, contractAddress);
                    }
                    break;

                case Client:
                    //Acheter du lait
                    cmd = ihm.promptClientMenu();
                    if (cmd == 0) {
                        ihm.printBalance(USERS.Client, deployer.getBalance(USERS.Client));
                        System.out.println();
                        ihm.printBalance(USERS.Farmer, deployer.getBalance(USERS.Farmer));
                        ihm.printBalance(USERS.Investor1, deployer.getBalance(USERS.Investor1));
                        ihm.printBalance(USERS.Investor2, deployer.getBalance(USERS.Investor2));

                        long milkAmount = ihm.promptMilkAmount();
                        contract = deployer.getContract(contractAddress, USERS.Client);
                        contract.buyMilk(BigInteger.valueOf(milkAmount), doubleEtherToBigIntegerWei(milkPrice*milkAmount)).send();
                        ihm.confirmMilkPurchaseRequest(milkPrice*milkAmount);

                        ihm.printBalance(USERS.Client, deployer.getBalance(USERS.Client));
                        System.out.println();
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

    private static void refundInvestors(IHM ihm, Deployer deployer, String contractAddress) throws Exception {
        Farminginvestment contract;
        ihm.printBalance(USERS.Investor1, deployer.getBalance(USERS.Investor1));
        ihm.printBalance(USERS.Investor2, deployer.getBalance(USERS.Investor2));

        contract = deployer.getContract(contractAddress, USERS.Farmer);
        contract.refundLimitDate();

        ihm.confirmRefundRequest();

        ihm.printBalance(USERS.Investor1, deployer.getBalance(USERS.Investor1));
        ihm.printBalance(USERS.Investor2, deployer.getBalance(USERS.Investor2));
    }

    private static void printContractBalance(Deployer deployer, String contractId){
        BigInteger balance = deployer.getBalance(contractId);
        String balanceEth = Convert.fromWei(balance.toString(), Convert.Unit.ETHER).toString();
        System.out.println("Contract balance in ether is :"+ balanceEth);
    }


    private static BigInteger doubleEtherToBigIntegerWei(double ether){
        return Convert.toWei(String.valueOf(ether), Convert.Unit.ETHER).toBigIntegerExact();
    }




}
