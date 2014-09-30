package ar.edu.unq.desapp.grupoa.model.Operation;

import java.util.Date;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.System.Shift;

/**
 * Class operation
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class Operation {

    private double amount;

    private Category category;

    private Shift shift;

    private OperationType operationType;

    private Date dateOperation;

    public Operation() {
    }

    public Operation(double amount, Category category, Shift shift, OperationType operationType) {
        this.amount = amount;
        this.category = category;
        this.shift = shift;
        this.operationType = operationType;
        this.dateOperation = new Date();
    }

    // ******************************************************************************************************
    // Getters and setters
    // ******************************************************************************************************

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    // ******************************************************************************************************
    // Methods
    // ******************************************************************************************************

    public void applyOperation(Account account) {

        this.operationType.chargeOperation(this, account);
    }

}
