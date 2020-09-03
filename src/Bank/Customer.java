package Bank;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final  String nid;
    private final Account account;
    Customer(String firstName, String lastName, String nid, Account account){
        this.firstName = firstName;
        this.lastName = lastName;
        this.nid = nid;
        this.account = account;
    }
    public String toString(){
        return "\nCustomer information\n"+
                "First name: " + firstName + "\n" +
                "Last name: " + lastName + "\n" +
                "NID: " + nid +"\n"+
                account;
    }
    public String info(){
        return "First name: " + firstName +
                " Last name: " + lastName +
                " NID: " + nid +" "+
                "Account number:" + account.getAccountNumber();
    }
    Account getAccount(){
        return account;
    }
}
