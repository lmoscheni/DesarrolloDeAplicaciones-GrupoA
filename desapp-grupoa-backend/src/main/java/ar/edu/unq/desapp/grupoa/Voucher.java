package ar.edu.unq.desapp.grupoa;

import java.util.Date;

import ar.edu.unq.desapp.grupoa.mocks.Operation;

/**
 * Class
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class Voucher {

    private Date dateOfIssue;

    private String socialReason;

    private String cuit;

    // private Category concept;
    private int amount;

    private Operation operation;

    // Constructor
    public Voucher(Date dateOfIssue, String socialReason, String cuit, int amount, Operation operation) {
        this.amount = amount;
        this.dateOfIssue = dateOfIssue;
        this.socialReason = socialReason;
        this.cuit = cuit;
        this.operation = operation;
    }

    // ***********************************************************************************************************
    // Getters and setters
    // ***********************************************************************************************************

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(String socialReason) {
        this.socialReason = socialReason;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    // ***********************************************************************************************************
    // Methods of class Voucher
    // ***********************************************************************************************************

    public int getFinalAmount() {
        return this.amount;
    }
}