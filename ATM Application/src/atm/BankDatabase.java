package atm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankDatabase {
    private double MAX_WITHDRAWAL;
    private ArrayList<UserAccount> accounts = new ArrayList<>();
    private final String filename = "Accounts.txt"; 

    public BankDatabase() {
    }

    public BankDatabase(double MAX_WITHDRAWAL, ArrayList<UserAccount> accounts) {
        this.MAX_WITHDRAWAL = MAX_WITHDRAWAL;
        this.accounts = accounts;
    }

    public double getMAX_WITHDRAWAL() {
        return MAX_WITHDRAWAL;
    }

    public void setMAX_WITHDRAWAL(double MAX_WITHDRAWAL) {
        this.MAX_WITHDRAWAL = MAX_WITHDRAWAL;
    }

    public void AddAccount(UserAccount user){
        try {
            saveToFile(user);
            accounts.add(user);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public UserAccount getAccount(String accountNo, String password){
        for (UserAccount account : accounts) {
            if (account.getPassword().equals(password) && account.getAccountNumber().equalsIgnoreCase(accountNo)) {
                return account;
            }
        }
        return null;
    }
    
    public boolean getAccount(String accountNo){
        return accounts.stream().anyMatch((account) -> (account.getAccountNumber().equalsIgnoreCase(accountNo)));
    }
    
    public void saveToFile(UserAccount acc) throws FileNotFoundException{
        //FileReader fr = new FileReader(filename);
        try {
            FileWriter fw = new FileWriter(filename,true);
            fw.append(acc.toString()+"\n");
            fw.close();
        } catch (IOException ex) {
            System.out.println("Something Happened");
        }
        
        
    }
    
    public void UpdateAccounts() throws IOException{
        FileWriter fw = new FileWriter(filename);
        for (UserAccount account : accounts) {
            fw.write(account.toString() + "\n");
        }
        
        fw.close();
    }
    
    public void ReadAccounts(){
        FileReader fr = null;
        try {
            fr = new FileReader(filename);
            Scanner sc = new Scanner(fr);
            
            while (sc.hasNextLine()) {                
                String s = sc.nextLine();
                if (s != null) {
                    String[] ses = s.split(",");
                    String name = ses[0];
                    double balance = Double.parseDouble(ses[1]);
                    String accNo = ses[2];
                    String pass = ses[3];
                    
                    UserAccount us = new UserAccount(name, balance, accNo, pass);
                    accounts.add(us);
                }               
                
            }
            fr.close();
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(filename);
                fw.close();
                ReadAccounts();
            } catch (IOException ex1) {
                System.err.println(ex1);
            }
            
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
     
    
}
