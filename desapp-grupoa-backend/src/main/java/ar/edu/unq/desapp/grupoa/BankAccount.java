package ar.edu.unq.desapp.grupoa;

import java.util.Date;

/**
 * Class bank account
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class BankAccount extends Account {
    public double accrued;

    public Date currently;

    public int delayTime;

    public int ID;

    public BankAccount() {
        super();
        this.accrued = 0.0;
        this.currently = new Date();
    }

    public double getAccrued() {
        return this.accrued;
    }

    public Date getCurrently() {
        return this.currently;
    }

    public void increaseBalance(double amount) {
        this.accrued += amount;
    }

    public void decreaseBalance(double amount) {
        accrued -= amount;
    }

    public boolean isBankAccount() {
        return true;
    }
}
