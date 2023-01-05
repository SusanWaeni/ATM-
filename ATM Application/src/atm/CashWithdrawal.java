/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class CashWithdrawal extends Transactions {

    KeyPad kp;
    CashDispenser cd;

    public CashWithdrawal(KeyPad kp, CashDispenser cd, BankDatabase bd, AtmScreen as, UserAccount ua) {
        super(bd, as, ua);
        kp = new KeyPad(cd, this);
        this.kp = kp;
        this.cd = cd;
        this.as.kp = kp;
        this.cd.as = this.as;
        start();
    }

    public void start() {
        try {
            as.Start();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public String execute() {
        double amount = Double.parseDouble(cd.screen.getText());
        if (amount > bd.getMAX_WITHDRAWAL()) {
            return "Amount To be Withdrawn not Available in Atm";
        } else {
            if (amount > ua.getBalance()) {
                return "You do not have that enough amount for Withdrwal\n"
                        + "Name: " + ua.getName()+ "\n"
                        + "Account Number: " + ua.getAccountNumber() + "\n"
                        + "Balance: " + ua.getBalance();
            } else {
                ua.setBalance(ua.getBalance() - amount);
                try {
                    bd.UpdateAccounts();
                } catch (IOException ex) {
                    System.err.println(ex);
                }
                return "Withdrawal Successful\n"
                        + "Name: " + ua.getName()+ "\n"
                        + "Account Number: " + ua.getAccountNumber() + "\n"
                        + "Balance: " + ua.getBalance() + "\n"
                        + "Amount Withdrawn: " + amount;
                
            }
        }
    }

}
