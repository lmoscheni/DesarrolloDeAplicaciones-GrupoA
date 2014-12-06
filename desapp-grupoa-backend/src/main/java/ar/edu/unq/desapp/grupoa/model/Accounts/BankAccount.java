package ar.edu.unq.desapp.grupoa.model.Accounts;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.model.Operation.OperationTypeEnum;

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
        super("BankAccount");
        this.accrued = 0.0;
        this.currently = new Date();
        this.pendingOperations = new ArrayList<Operation>();
        this.delayTime = 15;
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
        operation.applyOperation(this);
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
        List<Operation> newList = new ArrayList<Operation>();
        for(Operation o : this.pendingOperations){
            if(!o.getId().equals(operation.getId())){
                newList.add(o);
            }
        }
        this.pendingOperations = newList;
        if(operation.getOperationTypeEnum().equals(OperationTypeEnum.INCOME)){
            this.decreaseBalance(operation.getAmount());
        }else{
            this.increaseBalance(operation.getAmount());
        }
    }
    
    @Override
    public void deleteOperation(Operation operation){
        boolean isInPendingOperations = false;
        for(Operation o : this.pendingOperations){
            if(o.getId().equals(operation.getId())){
                System.out.println("Entre");
                isInPendingOperations = true;
            }
        }
        if(isInPendingOperations){
            this.cancelOperation(operation);
        }else{
            this.delOperation(operation);
        }
    }
    
    public void delOperation(Operation operation) {
        
        List<Operation> newList = new ArrayList<Operation>();
        for(Operation o : this.operations){
            if(!o.getId().equals(operation.getId())){
                newList.add(o);
            }
        }
        this.operations = newList;
        if(operation.getOperationTypeEnum().equals(OperationTypeEnum.INCOME)){
            balance -= operation.getAmount();
        }else{
            balance += operation.getAmount();
        }
    }
    
    @SuppressWarnings("deprecation")
    public boolean theOperationWasConsolidated(Operation operation) {
        Calendar dateNow = Calendar.getInstance();
        Date operationDate = operation.getDateOperation();
        int daysTheySpent =  operationDate.getDate() - dateNow.get(Calendar.DATE);
        return daysTheySpent >= this.getDelayTime();
    }
    
    public void consolidateOperation(Operation operation, List<Operation> removeOperations) {
        if(this.theOperationWasConsolidated(operation)) {
            removeOperations.add(operation);
            this.balance += operation.getAmount();
            this.accrued -= operation.getAmount();
            this.operations.add(operation);
        }
    }
    
    @Override
    public void updateTheAccountStatus() {
        List<Operation> removeOperations = new ArrayList<Operation>();
        for(Operation operation : this.pendingOperations) {
            this.consolidateOperation(operation, removeOperations);
        }
        for(Operation o : removeOperations){
            
            List<Operation> newList = new ArrayList<Operation>();
            for(Operation op : this.pendingOperations){
                if(!o.getId().equals(op.getId())){
                    newList.add(o);
                }
            }
            this.pendingOperations = newList;
        }
    }
}
