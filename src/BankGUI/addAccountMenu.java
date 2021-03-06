/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankGUI;

import javax.swing.JOptionPane;

/**
 *
 * @author offic
 */
public class addAccountMenu extends javax.swing.JDialog {
     private Bank bank;
     private Customer customer;
    /**
     * Creates new form addAccountMenu
     */
    public addAccountMenu(java.awt.Frame parent, boolean modal, Bank bank) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.bank = bank;
        customer = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        nidLabel = new javax.swing.JLabel();
        nidField = new javax.swing.JTextField();
        initDepositLabel = new javax.swing.JLabel();
        initDepositField = new javax.swing.JTextField();
        accountTypeLabel = new javax.swing.JLabel();
        accountTypeCombo = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Account");
        getContentPane().setLayout(new java.awt.GridLayout(6, 2, 5, 5));

        firstNameLabel.setText(" First Name");
        getContentPane().add(firstNameLabel);

        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(firstNameField);

        lastNameLabel.setText(" Last Name");
        getContentPane().add(lastNameLabel);
        getContentPane().add(lastNameField);

        nidLabel.setText(" National Identification Number (NID)");
        getContentPane().add(nidLabel);
        getContentPane().add(nidField);

        initDepositLabel.setText(" Initial Deposit");
        getContentPane().add(initDepositLabel);
        getContentPane().add(initDepositField);

        accountTypeLabel.setText(" Account Type");
        getContentPane().add(accountTypeLabel);

        accountTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "checking", "savings" }));
        accountTypeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountTypeComboActionPerformed(evt);
            }
        });
        getContentPane().add(accountTypeCombo);

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accountTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountTypeComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountTypeComboActionPerformed

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameFieldActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // verify firstName
        String firstName = "", lastName = "", nid ="", initalDeposit= "";
        double amount = 0;
        StringBuilder warnings = new StringBuilder();
        if(firstNameField.getText().isEmpty()){
           warnings.append("First name cannot be empty!\n");
        }
        else{
            firstName =  firstNameField.getText();
        }
        //verify lastName
        if(lastNameField.getText().isEmpty()){
            warnings.append("Last name cannot be empty!\n");
        } else lastName = lastNameField.getText();
        // verify nid
        if(nidField.getText().isEmpty()){
           warnings.append("Nid cannot be empty!\n");
        } else nid = nidField.getText();
        
        // verfy inital
        if(initDepositField.getText().isEmpty()){
            warnings.append("Inital deposit must be number");
        } else {
            try{
                amount = Double.parseDouble(initDepositField.getText());
            }
            catch(NumberFormatException ex){
                warnings.append("inital deposit must be a number!");
            }
            
                
        }
        
        if(warnings.length() > 0 ){
            JOptionPane.showMessageDialog(this,warnings.toString(), "Please Provide all details!" , JOptionPane.WARNING_MESSAGE);
        }
        else {
            Account account = null;
            if(accountTypeCombo.getSelectedItem().toString() == "checking"){
               if(amount >= 1000 ){
                    account = new Checking(amount);
               }
               else {
                   warnings.append("Initial deposit must be 1000 BDT for Checking");
               }
            }
            else if(accountTypeCombo.getSelectedItem().toString() == "savings"){
               
                 if(amount >= 500 ){
                     account = new Savings(amount);
               }
               else {
                   warnings.append("Initial deposit must be 500 BDT for Savings");
               }
            }
            if(warnings.length() > 0 ){
            JOptionPane.showMessageDialog(this,warnings.toString(), "Please Provide all details!" , JOptionPane.WARNING_MESSAGE);
        } else {
            customer = new Customer(firstName, lastName, nid, account);
            bank.addCustomer(customer);
            this.dispose();}
        }
       
        // verfy
        
    }//GEN-LAST:event_addButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> accountTypeCombo;
    private javax.swing.JLabel accountTypeLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField initDepositField;
    private javax.swing.JLabel initDepositLabel;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField nidField;
    private javax.swing.JLabel nidLabel;
    // End of variables declaration//GEN-END:variables

    Customer getCustomer() {
        return customer;
    }
}
