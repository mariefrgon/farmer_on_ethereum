package main.java.bfm.farmer;

import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Launcher {

    public enum USERS {Farmer, Investor1, Investor2, Client, Cowbreeder;}

    public static void main(String[] args) throws Exception {

        //TODO: delete this test
        Deployer deployerr = new Deployer();
        System.out.println("Retrieving balance from investor");
        System.out.println("your balance in wei: " + deployerr.getBalance(USERS.Investor1));



        IHM ihm = new IHM();

        ihm.promptInitMenu();
        int duration = ihm.promptMaxDuration();
        int goal = ihm.promptGoalAmount();
        int milkPrice = ihm.promptMilkPrice();
        //TODO: command

        Deployer deployer = new Deployer();
        Farminginvestment contract = deployer.transferContract(duration, goal, milkPrice);

        String contractAddress = contract.getContractAddress();

        int cmd;
        while(true) {
            int user = ihm.promptMenu();
            switch (USERS.values()[user]) {
                case Investor1:
                    contract = deployer.getContract(contractAddress, USERS.Investor1);
                    cmd = ihm.promptInvestorMenu();
                    if (cmd == 0) {
                        System.out.println("your balance in wei: " + deployer.getBalance(USERS.Investor1));
                        int investmentAmount = ihm.promptAmountToInvest();
                        contract.invest(BigInteger.valueOf(investmentAmount));
                        System.out.println("your balance in wei: " + deployer.getBalance(USERS.Investor1));
                    }

                    break;
                case Investor2:
                    contract = deployer.getContract(contractAddress, USERS.Investor2);
                    cmd = ihm.promptInvestorMenu();
                    if (cmd == 0) {
                        //TODO: montrer l'argent de la personne
                        int investmentAmount = ihm.promptAmountToInvest();
                        contract.invest(BigInteger.valueOf(investmentAmount));
                        //TODO: montrer l'argent de la personne
                    }
                    break;
                case Client:
                    //TODO: seulement permettre ça quand les vaches sont achetées (?) -> ou alors non parce que solidity s'en occupe
                    contract = deployer.getContract(contractAddress, USERS.Client);
                    cmd = ihm.promptClientMenu();
                    if (cmd == 0) {
                        int milkAmount = ihm.promptMilkAmount();
                        contract = deployer.getContract(contractAddress, USERS.Client);
                        contract.buyMilk(BigInteger.valueOf(milkAmount), BigInteger.valueOf(milkPrice*milkAmount));
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







}
