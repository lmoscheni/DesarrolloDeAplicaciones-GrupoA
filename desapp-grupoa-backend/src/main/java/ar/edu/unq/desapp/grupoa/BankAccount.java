package ar.edu.unq.desapp.grupoa;

import java.util.Date;

public class BankAccount extends Account {
    public double accrued;
    public Date currently;
    public int delayTime;
    
    public BankAccount() {
        super();
        accrued = 0.0;
    }
    
    public void increaseBalance(double amount) {
        accrued += amount;
    }

    public void decreaseBalance(double amount) {
        accrued -= amount;
    }
}
