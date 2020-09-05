package BankGUI;

import java.io.Serializable;

public class Customer implements Serializable {

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }
    
    public String getNid() {
        return nid;
    }
    
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
                "First name: " + getFirstName() + "\n" +
                "Last name: " + getLastName() + "\n" +
                "NID: " + nid +"\n"+
                account;
    }
    public String info(){
        return "First name: " + getFirstName() +
                " Last name: " + getLastName() +
                " NID: " + nid +" "+
                "Account number:" + account.getAccountNumber();
    }
    Account getAccount(){
        return account;
    }

  
}
