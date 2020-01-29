package main.java.bfm.farmer;

import java.math.BigInteger;

public class Launcher {

    public enum USERS {Farmer, Investor1, Investor2, Client, Cowbreeder;}

    public static void main(String[] args) throws Exception {

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
                    if (cmd == 1) {
                        //TODO: montrer l'argent de la personne
                        int investmentAmount = ihm.promptAmountToInvest();
                        contract.invest(BigInteger.valueOf(investmentAmount));
                        //TODO: montrer l'argent de la personne
                    }

                    break;
                case Investor2:
                    contract = deployer.getContract(contractAddress, USERS.Investor2);
                    cmd = ihm.promptInvestorMenu();
                    if (cmd == 1) {
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
                    if (cmd == 1) {
                        int milkAmount = ihm.promptMilkAmount();
                        contract = deployer.getContract(contractAddress, USERS.Client);
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
