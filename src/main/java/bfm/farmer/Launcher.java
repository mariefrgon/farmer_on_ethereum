package main.java.bfm.farmer;

public class Launcher {

    public enum USERS {Farmer, Investor1, Investor2, Client, Cowbreeder;}

    public static void main(String[] args) throws Exception {

        IHM ihm = new IHM();

        int user = ihm.promptInitMenu();


        Deployer deployer = new Deployer();
        Farminginvestment fi = deployer.transferContract();

        Farminginvestment fi2 = deployer.getContract(fi.getContractAddress(), "pete");

    }







}
