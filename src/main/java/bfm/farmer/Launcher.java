package main.java.bfm.farmer;


public class Launcher {

    public static void main(String[] args) throws Exception {
        Deployer deployer = new Deployer();
        Farminginvestment fi = deployer.transferContract();



        Farminginvestment fi2 = deployer.getContract(fi.getContractAddress());

    }
}