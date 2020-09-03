package Bank;

public class Account {
    private double balance;
    private  double interest;
    private int accountNumber;
    private static int numberOfAccount = 10000000;
    Account() {
        accountNumber = numberOfAccount++;
    }
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
        balance -= amount +5;
        System.out.println(amount+" BDT successfully withdrawn!");
        System.out.println("New Balance:" + balance);
    }
    public void deposit(double amount){
        if(amount <=0){
            System.err.println("Money cannot be negative value!");
            return;
        }
        checkInterest();
        balance += amount+ (amount * interest/100);
        System.out.println("Deposited: " + amount + " with interest of " + interest+"%");
        System.out.println("New balance: " + getBalance());
    }

    private void checkInterest() {
        if(balance >10000){
            interest = 5;
        } else interest =2;
    }
}
