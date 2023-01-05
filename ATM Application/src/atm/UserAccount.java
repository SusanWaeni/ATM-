package atm;

public class UserAccount {
    private String name;
    private double balance;
    private String accountNumber;
    private String password;
    
    public UserAccount() {
    }

    public UserAccount(String name, double balance, String accountNumber, String password) {
        this.name = name;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return name+","+balance+","+accountNumber+","+password; //To change body of generated methods, choose Tools | Templates.
    }
    
}
