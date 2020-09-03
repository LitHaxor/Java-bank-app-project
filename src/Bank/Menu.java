package Bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    boolean quit;
    Scanner inputKey = new Scanner(System.in);
    Bank bank = new Bank();

    public void runMenu(){
        showHeader();
        while(!quit){
            showMenu();
            int choice = getInput();
            performAction(choice);
        }
    }
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.runMenu();
    }



    void showHeader(){
        System.out.println("=====================================");
        System.out.println("!    Project Bank Application       !");
        System.out.println("!            CLI APP                !");
        System.out.println("=====================================");
    }
    void showMenu(){
        System.out.println("Select your options:");
        System.out.println("1. Create a new account");
        System.out.println("2. Make a deposit");
        System.out.println("3. Make a withdraw");
        System.out.println("4. List account");
        System.out.println("0. Quit");
    }
    private int getInput(){
        int choice =-1;
        System.out.print("Enter your choice:");
        do {
            try {
                choice = Integer.parseInt(inputKey.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Invalid selected");
            }
            if (choice < 0  || choice >4){
                System.out.println("Choice is outside of range");
            }
        } while (choice < 0  || choice >4);
        return choice;
    }

    private void performAction(int choice) {
        switch (choice){
            case 0:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            case 1:
                //account creation
                createAccount();
                break;
            case 2:
                //deposit
                makeDeposit();
                break;
            case 3:
                //withdraw
                makeWithdraw();
                break;
            case 4:
                //list
                showList();
                break;
            default:
                System.out.println("Error selection!");
        }
    }

    private void showList() {
        int account = selectAccount();
        if (account >= 0) {
            System.out.println(bank.getCustomer(account).getAccount());;
        }

    }

    private void makeWithdraw() {
        int account = selectAccount();
        if (account >= 0) {
            System.out.println("How much you want to Withdraw?");
            double amount = 0;
            try {
                amount = Double.parseDouble(inputKey.nextLine());
            } catch (NumberFormatException e) {
                amount = 0;
            }
            bank.getCustomer(account).getAccount().withdraw(amount);
        }
    }

    private void makeDeposit() {
        int account = selectAccount();
        if (account >= 0) {
            System.out.println("How much you want to deposit?");
            double amount = 0;
            try {
                amount = Double.parseDouble(inputKey.nextLine());
            } catch (NumberFormatException e) {
                amount = 0;
            }
            bank.getCustomer(account).getAccount().deposit(amount);
        }
    }
    private int selectAccount() {
        ArrayList<Customer> customers = bank.getCustomers();
        if(customers.size() <= 0) {
            System.out.println("No customer has been created!");
            return -1;
        }
        System.out.println("Select an Account:");
        for(int i = 0; i < customers.size() ; i++){
            System.out.println(i+1 + "." + customers.get(i).info());
        }
        int account = 0;
        System.out.println("Enter your selection:");
        try {
            account = Integer.parseInt(inputKey.nextLine()) -1;
        }
        catch (NumberFormatException e){
            account = -1;
        }
        if(account < 0 || account > customers.size()){
            System.out.println("Invalid account selected!");
            account = -1;
        }
        return account;

    }

    private void createAccount() {
        String firstName= "", lastName ="", nid="", typeOfAccount ="";
        double initDeposit = 0.0;
        boolean valid = false;
        while(!valid) {
                System.out.print("Please enter account type?:");
                typeOfAccount = inputKey.nextLine();
                if (typeOfAccount.equalsIgnoreCase("savings") || typeOfAccount.equalsIgnoreCase("checking")) {
                    valid = true;
                }
                else {
                    System.out.println("Invalid account type!");
                }
            }

            System.out.print("Enter first name:");
            firstName = inputKey.nextLine();
            System.out.print("Enter last name:");
            lastName = inputKey.nextLine();
            System.out.print("Enter NID No:");
            nid = inputKey.nextLine();
            valid = false;
            while (!valid){
                System.out.print("Enter an initial deposit:");
                try{
                    initDeposit = Double.parseDouble(inputKey.nextLine());
                }
                catch (NumberFormatException e){
                    System.out.println("Deposit must be a number!");
                }
                if(typeOfAccount.equalsIgnoreCase("checking")){
                    if (initDeposit < 1000){
                        System.out.println("Checking account require a minimum 1000 BDT to open!");

                    }
                    else {valid = true;}
                }
                else if(typeOfAccount.equalsIgnoreCase("savings")){
                    if(initDeposit <500){
                        System.out.println("Saving account require 500 BDT to open!");
                    }
                    else {valid = true;}
                }
            }




        //creating account
        Account account;
        if(typeOfAccount.equalsIgnoreCase("checking")){
            account= new Checking(initDeposit);
        }
        else account= new Savings(initDeposit);
        Customer customer = new Customer(firstName, lastName, nid, account );
        bank.addCustomer(customer);
    }
}
