package atm;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Panel;
import javax.swing.JFrame;

public class AtmScreen extends JFrame{
    CashDispenser cd;
    KeyPad kp;

    public AtmScreen(CashDispenser cd, KeyPad kp) throws HeadlessException {
        this.cd = cd;
        this.kp = kp;
        try {
            Start();
        } catch (Exception ex) {
            System.exit(1);
        }
    }

    public AtmScreen() throws HeadlessException {
        
    }
    
    public void Start() throws Exception{
        if (cd == null || kp == null) {
            throw new Exception("Display and keypad not set");
        }else{
            this.setTitle("ATM WITHDRAWAL");
            Panel p = new Panel(new GridLayout(2, 1));
            p.add(cd);
            p.add(kp);
            System.out.println(kp.cw);
            this.getContentPane().add(p);
            this.setSize(340, 310);
            this.pack();
            this.setVisible(true);
            this.setResizable(false);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
        }
    }
    
    
}
