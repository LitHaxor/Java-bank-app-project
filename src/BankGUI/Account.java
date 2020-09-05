package BankGUI;

import java.io.Serializable;
import java.util.ArrayList;




public abstract class  Account implements Serializable  {
    private double balance;
    private  double interest;
    private int accountNumber;
    private static int numberOfAccount = 10000000;
    Account() {
        accountNumber = numberOfAccount++;
    }
    public abstract String getAccountType();
    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void withdraw(double amount){
        if(amount + 15 > balance){
            System.err.println("Insufficient funds");
            return;
        }
        checkInterest(0);
        balance -= amount +15;
        System.out.println(amount+" BDT successfully withdrawn!");
        System.out.println("New Balance:" + balance);
    }
    public void deposit(double amount){
        if(amount <=0){
            System.err.println("Money cannot be negative value!");
            return;
        }
        checkInterest(amount);
        amount = amount+ (amount * interest/100);
        balance += amount;
        System.out.println("Deposited: " + amount + " with interest of " + interest+"%");
        System.out.println("New balance: " + getBalance());
    }

    public void checkInterest(double amount) {
        if(amount + balance >10000){
            interest = 5;
        } else
        {
            interest =2;
        }
    }
    

   
}
