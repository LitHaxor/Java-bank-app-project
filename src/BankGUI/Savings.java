package BankGUI;

public class Savings extends  Account{
    private static String accountType = "Savings";
    Savings(double initDeposit){

        super();
        this.setBalance(initDeposit);
        this.checkInterest(0);
    }

    public String toString(){
        return "Account Type:" + accountType + " Account\n"+
                "Account Number: "+ this.getAccountNumber() + "\n"+
                "Balance:" + this.getBalance()+"\n" + "Interest Rate:" + this.getInterest() + "\n";

    }
    public String getAccountType() {
        return accountType;
    }
}
