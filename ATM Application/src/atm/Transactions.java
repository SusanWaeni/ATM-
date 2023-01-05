
package atm;

/**
 *
 * @author USER
 */
abstract class Transactions {
    BankDatabase bd;
    AtmScreen as;
    UserAccount ua;

    public Transactions(BankDatabase bd, AtmScreen as, UserAccount ua) {
        this.bd = bd;
        this.as = as;
        this.ua = ua;
    }

    public Transactions() {
    }
    
    public abstract String execute();
}
