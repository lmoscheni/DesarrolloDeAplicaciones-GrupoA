package ar.edu.unq.desapp.grupoa.model.Accounts;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ar.edu.unq.desapp.grupoa.model.Operation.Operation;

/**
 * Class bank account
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class BankAccount extends Account {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public double accrued;

    public Date currently;

    public int delayTime;
    
    public List<Operation> pendingOperations;

    public BankAccount() {
        super("BanckAccount");
        this.accrued = 0.0;
        this.currently = new Date();
        this.pendingOperations = new ArrayList<Operation>();
    }

    // ***********************************************************************************************************
    // Getters and setters
    // ***********************************************************************************************************
    
    public double getAccrued() {
        return this.accrued;
    }

    public Date getCurrently() {
        return this.currently;
    }
    
    public int getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
    }

    public List<Operation> getPendingOperations() {
        return pendingOperations;
    }

    public void setPendingOperations(List<Operation> pendingOperations) {
        this.pendingOperations = pendingOperations;
    }

    public void setAccrued(double accrued) {
        this.accrued = accrued;
    }

    public void setCurrently(Date currently) {
        this.currently = currently;
    }

    // ***********************************************************************************************************
    // Methods of bank account
    // ***********************************************************************************************************
    
    
    @Override
    public void registrateOperation(Operation operation) {
        this.pendingOperations.add(operation);
    }

    @Override
    public void increaseBalance(double amount) {
        this.accrued += amount;
    }
    
    @Override
    public void decreaseBalance(double amount) {
        accrued -= amount;
    }

    @Override
    public boolean isBankAccount() {
        return true;
    }
    
    public void cancelOperation(Operation operation) {
        this.pendingOperations.remove(operation);
    }
    
    @SuppressWarnings("deprecation")
    public boolean theOperationWasConsolidated(Operation operation) {
        Calendar dateNow = Calendar.getInstance();
        Date operationDate = operation.getDateOperation();
        int daysTheySpent = dateNow.get(Calendar.DATE) - operationDate.getDay();
        return daysTheySpent >= this.getDelayTime();
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
