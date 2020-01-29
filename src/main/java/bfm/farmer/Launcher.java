package main.java.bfm.farmer;

public class Launcher {

    public enum USERS {Farmer, Investor1, Investor2, Client, Cowbreeder;}

    public static void main(String[] args) throws Exception {

        IHM ihm = new IHM();

        int user = ihm.promptInitMenu();

        switch (user){
            case USERS.Farmer:
                cmd = imh.promptInvestorMenu();
                if (cmd == 1){
                    int duration = ihm.promptMaxDuration();
                    int goal = ihm.promtGoalAmount();
                    int milkPrice = ihm.promptMilkPrice();

                    //TODO: command
                }

                break;
            case USERS.Investor1:
                break;
            case USERS.Investor2:
                break;
            case USERS.Client:
                break;
        }

        Deployer deployer = new Deployer();
        Farminginvestment fi = deployer.transferContract();

        Farminginvestment fi2 = deployer.getContract(fi.getContractAddress(), "pete");

    }







}
