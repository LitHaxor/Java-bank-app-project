package BankGUI;


import java.io.Serializable;
import java.util.ArrayList;

public class Bank implements Serializable, Banking{

    ArrayList<Customer> customers = new ArrayList<Customer>();
    
    public void addCustomer(Customer customer) {
     
        int accountNumber = customer.getAccount().getAccountNumber();
        String accountType = customer.getAccount().getAccountType();
        customer.getAccount().setAccountNumber(findValidAccountNumber(accountNumber, accountType));
        customers.add(customer);
    }
    
    private int findValidAccountNumber(int accountNumber, String accountType) {
       System.out.println("AccountType:" + accountType);
       while(accountExist(accountNumber)){
           accountNumber++;
         }
       if(accountType == "Savings"){
           return accountNumber + 11000000;
       } 
       else if(accountType == "checking"){
           return accountNumber + 31000000;
       }
       else return accountNumber;
    }
    
    private Boolean accountExist (int accountnumber){
        for(Customer c: customers){
            if(c.getAccount().getAccountNumber() -31000000 == accountnumber || c.getAccount().getAccountNumber()-11000000 == accountnumber){
                return true;
            }  
        }
        return false;
    }
    

    public Customer getCustomer(int account) {
        return customers.get(account);
    }
    
    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    Customer getCustomerByAccountNumber(int accountNumber) {
        Customer customer= null;
        for(Customer c : customers){
            if(c.getAccount().getAccountNumber() == accountNumber){
                customer = c;
                break;
            }
        }
        return customer;
    }

    void removeCustomer(Customer customer) {
       customers.remove(customer);
    }
}
