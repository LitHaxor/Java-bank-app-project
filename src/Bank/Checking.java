package Bank;

public class Checking extends  Account{
    private static String accountType = "checking";
        Checking(double initDeposit){
            super();
            this.setBalance(initDeposit);
            if(initDeposit >10000){
                this.setInterest(3);
            }
            else this.setInterest(2);
        }


        public String toString(){
            return "Account Type:" + accountType + " Account\n"+
                    "Account Number: "+ this.getAccountNumber() + "\n"+
                    "Balance:" + this.getBalance()+"\n" + "Interest Rate:" + this.getInterest() + "\n";

        }
}
