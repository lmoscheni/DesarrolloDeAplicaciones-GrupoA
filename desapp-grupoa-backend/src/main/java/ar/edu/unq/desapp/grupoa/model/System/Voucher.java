package ar.edu.unq.desapp.grupoa.model.System;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import ar.edu.unq.desapp.grupoa.model.Bills.BillType;

/**
 * Class voucher
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

@Entity
public class Voucher implements Serializable{

    private static final long serialVersionUID = -6002265001794686198L;

    public Integer id;
    
    private Date dateOfIssue;

    private String socialReason;

    private String cuit;

    private String concept;

    private double amount;

    private BillType billType;

    public Voucher() {
    }

    public Voucher(Date dateOfIssue, String socialReason, String cuit, double amount, BillType billType,
            String concept) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
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

    public void setAmount(double amount) throws Exception {
        if(amount < 0){
            throw new Exception("Monto amount no negativo");
        }else{
            this.amount = amount;
        }
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
