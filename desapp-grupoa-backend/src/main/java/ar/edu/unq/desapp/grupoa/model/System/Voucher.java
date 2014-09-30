package ar.edu.unq.desapp.grupoa.model.System;

import java.util.Date;

import ar.edu.unq.desapp.grupoa.model.Bills.BillType;
import ar.edu.unq.desapp.grupoa.model.Category.Category;

/**
 * Class voucher
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class Voucher {

    private Date dateOfIssue;

    private String socialReason;

    private String cuit;

    private Category concept;

    private double amount;

    private BillType billType;

    public Voucher() {
    }

    public Voucher(Date dateOfIssue, String socialReason, String cuit, double amount, BillType billType,
            Category concept) {
        this.amount = amount;
        this.dateOfIssue = dateOfIssue;
        this.socialReason = socialReason;
        this.cuit = cuit;
        this.billType = billType;
        this.concept = concept;
    }

    // ***********************************************************************************************************
    // Getters and setters
    // ***********************************************************************************************************

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public Category getConcept() {
        return concept;
    }

    public void setConcept(Category concept) {
        this.concept = concept;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BillType getBillType() {
        return billType;
    }

    public void setBillType(BillType billType) {
        this.billType = billType;
    }

    // ***********************************************************************************************************
    // Methods of class Voucher
    // ***********************************************************************************************************

    public double getFinalAmount() {
        return this.billType.calculateFinalAmount(this);
    }
}
