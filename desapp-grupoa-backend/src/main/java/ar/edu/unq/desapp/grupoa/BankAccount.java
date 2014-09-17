package ar.edu.unq.desapp.grupoa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    
    public List<Operation> pendingOperations;

    public BankAccount() {
        super();
        this.accrued = 0.0;
        this.currently = new Date();
        this.pendingOperations = new ArrayList<Operation>();
    }
    
    @Override
    public void registrateOperation(Operation operation) {
        this.pendingOperations.add(operation);
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
    
    public void cancelOperation(Operation operation) {
        this.pendingOperations.remove(operation);
    }
    
    private boolean theOperationWasConsolidated(Operation operation) {
        @SuppressWarnings("deprecation")
        int daysTheySpent = this.getCurrently().getDay() - operation.getDateOperation().getDay();
        return daysTheySpent >= this.delayTime;
    }
    
    public void consolidateOperation(Operation operation) {
        if(this.theOperationWasConsolidated(operation)) {
            this.balance += operation.getAmount();
            this.accrued -= operation.getAmount();
            this.pendingOperations.remove(operation);
            this.operations.add(operation);
        }
    }
    
    @Override
    public void updateTheAccountStatus() {
        for(Operation operation : this.pendingOperations) {
            this.consolidateOperation(operation);
        }
    }
}
