package main.java.bfm.farmer;

public class Launcher {

    public enum USERS {Farmer, Investor1, Investor2, Client, Cowbreeder;}

    public static void main(String[] args) throws Exception {

        IHM ihm = new IHM();

        ihm.promptInitMenu();
        int duration = ihm.promptMaxDuration();
        int goal = ihm.promptGoalAmount();
        int milkPrice = ihm.promptMilkPrice();
        //TODO: command

        //Deployer deployer = new Deployer();
        Farminginvestment farmerContract;
        //farmerContract = deployer.transferContract(duration, goal, milkPrice);

        int cmd;
        while(true) {
            int user = ihm.promptMenu();
            switch (USERS.values()[user]) {
                case Investor1:
                    cmd = ihm.promptInvestorMenu();
                    if (cmd == 1) {
                        //TODO: montrer l'argent de la personne
                        int investmentAmount = ihm.promptAmountToInvest();
                        System.out.println("investissement");
                        //TODO: command
                        //TODO: montrer l'argent de la personne
                    }

                    break;
                case Investor2:
                    //TODO: same as for investor2
                    break;
                case Client:
                    //TODO: seulement permettre ça quand les vaches sont achetées (?) -> ou alors non parce que solidity s'en occupe
                    cmd = ihm.promptClientMenu();
                    if (cmd == 1) {
                        int milkAmount = ihm.promptMilkAmount();

                        //TODO: command
                        //TODO: montrer l'argent du client + investisseur + farmer
                        System.out.println("lait commandé");
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
