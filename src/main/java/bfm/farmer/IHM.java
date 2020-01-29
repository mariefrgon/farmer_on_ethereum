package main.java.bfm.farmer;

import java.math.BigInteger;
import java.util.Scanner;
import main.java.bfm.farmer.Launcher.USERS;

public class IHM {

    private Scanner scanner;


    IHM(){
        scanner = new Scanner(System.in);
    }

    //TODO: rajouter des la sécurité pour quand l'input c'est n'importe quoi (?) -> genre des check
    public int promptInitMenu(){
        String instructions = "Welcome to the Milkapp. Please state your identity by typing the appropriate number";
        String[] options = {String.valueOf(USERS.Farmer), String.valueOf(USERS.Investor1), String.valueOf(USERS.Investor1), String.valueOf(USERS.Client)} ;
        printOptionsMenu(instructions, options);
        return readCommand();
    }

    public int promptFarmerMenu(){
        String instructions = "Welcome Farmer. What do you want to do?";
        String[] options = {"Deploy the smart contract", "Exit"} ;
        printOptionsMenu(instructions, options);
        return readCommand();
    }

    //renvoie le résultat en secondes
    public int promptMaxDuration(){
        String instructions = "Please enter the max duration of the contract (in minutes) amount for the investment period";
        printMenu(instructions);
        return readCommand()*60;
    }

    //TODO: vérifier si c'est en ether ou en wei
    public int promptGoalAmount(){
        String instructions = "Please enter the goal amount for the investment in wei.";
        printMenu(instructions);
        return readCommand();
    }

    //TODO: vérifier si c'est en ether ou en wei
    public int promptMilkPrice(){
        String instructions = "Please enter the price of the milk that will be sold in wei.";
        printMenu(instructions);
        return readCommand();
    }

    public int promptInvestorMenu(){
        String instructions = "Welcome Investor. What do you want to do?";
        String[] options = {"Deploy the smart contract", "Exit"} ;
        printOptionsMenu(instructions, options);
        return readCommand();
    }

    public int promptAmountToInvest(){
        String instructions = "Please enter the amount of money to invest in wei.";
        printMenu(instructions);
        return readCommand();
    }

    public  int promptClientMenu(){
        String instructions = "Welcome Client. What do you want to do?";
        String[] options = {"Buy Milk", "Exit"} ;
        printOptionsMenu(instructions, options);
        return readCommand();
    }

    public void printOptionsMenu(String instructions, String[] options){
        System.out.println(instructions);
        for (int i = 0; i<options.length; i++){
            System.out.println(i+". "+ options[i]);
        }
    }

    public void printMenu(String instructions){
        System.out.println(instructions);
    }

    private int readCommand() {
        return scanner.nextInt();
    }
}

