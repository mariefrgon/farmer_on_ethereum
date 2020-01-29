package main.java.bfm.farmer;

public class Launcher {

    public enum USERS {Farmer, Investor1, Investor2, Client, Cowbreeder;}

    public static void main(String[] args) throws Exception {

        IHM ihm = new IHM();

        int user = ihm.promptInitMenu();

        switch (user){
            case USERS.Farmer:
                //TODO: seulement le permettre une fois
                int cmd = imh.promptFarmerMenu();
                if (cmd == 1){
                    int duration = ihm.promptMaxDuration();
                    int goal = ihm.promtGoalAmount();
                    int milkPrice = ihm.promptMilkPrice();

                    //TODO: command
                }

                break;
            case USERS.Investor1:
                //TODO: seulement permettre ça quand le contract est déployé
                int cmd = ihm.promptInvestorMenu();
                if(cmd = 1){
                    int investmentAmount = ihm.promptAmountToInvest();

                    //TODO: command
                }

                break;
            case USERS.Investor2:
                //TODO: same as for investor2
                break;
            case USERS.Client:
                //TODO: seulement permettre ça quand les vaches sont achetées
                int cmd = ihm.promptClientMenu();
                if(cmf = 1){
                    int milkAmount =promptMilkAmount();

                    //TODO: command
                    System.out.println("lait commandé");
                }
                break;
        }

        //Deployer deployer = new Deployer();
        //Farminginvestment fi = deployer.transferContract();

        //Farminginvestment fi2 = deployer.getContract(fi.getContractAddress(), "pete");

    }







}
