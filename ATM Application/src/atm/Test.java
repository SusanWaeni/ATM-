package atm;

import java.io.FileNotFoundException;


public class Test {

    public static void main(String[] args) throws FileNotFoundException {
//        AtmScreen atmScreen = new AtmScreen(new CashDispenser(), new KeyPad());
        BankDatabase bd = new BankDatabase();
        bd.ReadAccounts();
        
        System.out.println(bd.getAccount("AVC6156179","1235").toString());

    }
}
