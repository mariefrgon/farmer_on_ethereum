package main.java.bfm.farmer;

import java.util.Scanner;
import main.java.bfm.farmer.Launcher.USERS;

public class IHM {

    private Scanner scanner;


    IHM() {
        scanner = new Scanner(System.in);
    }

    //TODO: rajouter des la sécurité pour quand l'input c'est n'importe quoi (?) -> genre des check
    public void promptInitMenu() {
        String instructions = "Welcome to the Milkapp. This is a platform to be able to collect funds from investors. Then, once you have the infrastructure, you can sell milk to customers. To begin, you must deploy the smart contract.";
        printMessage(instructions);
    }

    public int promptMenu() {
        String instructions = "\nWelcome to the Milkapp. Please state your identity by typing the appropriate number";
        String[] options = {String.valueOf(USERS.Farmer), String.valueOf(USERS.Investor1), String.valueOf(USERS.Investor2), String.valueOf(USERS.Client), String.valueOf(USERS.Cowbreeder)};
        printOptionsMenu(instructions, options);
        return readCommand();
    }

    public int promptFarmerMenu() {
        String instructions = "Welcome Farmer. What do you want to do?";
        String[] options = {"Refund investor money", "Go back"};
        printOptionsMenu(instructions, options);
        return readCommand();
    }

    //renvoie le résultat en secondes
    public long promptMaxDuration() {
        String instructions = "Please enter the max duration for the investment period (in minutes)";
        printMessage(instructions);
        return readLong() * 60;
    }

    //TODO: vérifier si c'est en ether ou en wei
    public double promptGoalAmount() {
        String instructions = "Please enter the goal amount for the investment in ether.";
        printMessage(instructions);
        return readDouble();
    }

    //TODO: vérifier si c'est en ether ou en wei
    public double promptMilkPrice() {
        String instructions = "Please enter the price of the milk that will be sold in ether.";
        printMessage(instructions);
        return readDouble();
    }

    public int promptInvestorMenu() {
        String instructions = "Welcome Investor. What do you want to do?";
        String[] options = {"Invest", "Ask for investment refund", "Go back"};
        printOptionsMenu(instructions, options);
        return readCommand();
    }

    //TODO: verifier si c'est en ether ou wei
    public double promptAmountToInvest() {
        String instructions = "Please enter the amount of money to invest in ether.";
        printMessage(instructions);
        return readDouble();
    }

    public int promptClientMenu() {
        String instructions = "Welcome Client. What do you want to do?";
        String[] options = {"Buy Milk", "Go back"};
        printOptionsMenu(instructions, options);
        return readCommand();
    }

    public long promptMilkAmount() {
        String instructions = "How many cartons of milk do you want to buy?";
        printMessage(instructions);
        return readLong();
    }

    public int promptCowbreederMenu() {
        String instructions = "Welcome Cowbreeder. What do you want to do?";
        String[] options = {"Check my balance", "Go back"};
        printOptionsMenu(instructions, options);
        return readCommand();
    }

    public void confirmContractDeployment(String address) {
        printMessage("The contract has been deployed at the address: " + address);
    }

    public void confirmRefundRequest(){
        printMessage("Refund request made");
    }

    //TODO: confirm if its in wei or ether
    public void confirmMilkPurchaseRequest(double price){
        printMessage("Purchase request made for a total of " + price + " ether");
    }

    public void printBalance(USERS user, String balance) {
        printMessage(user + "'s balance in ether is: " + balance);
    }

    public void printBalance(String user, String balance){
        printMessage(user + "'s balance in ether is: " + balance);
    }

    public void printOptionsMenu(String instructions, String[] options) {
        System.out.println(instructions);
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + ". " + options[i]);
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    private int readCommand() {
        return scanner.nextInt();
    }

    private long readLong() {
        return scanner.nextLong();
    }

    private double readDouble(){
        return scanner.nextDouble();
    }

}

