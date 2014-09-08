package ar.edu.unq.desapp.grupoa;

import java.util.Date;

/**
 * Class a invoive
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class AInvoive extends Voucher {

    private int taxed;

    private int noTaxed;

    private int IIBBPerception;

    private int IVA;

    public AInvoive(){}
    
    public AInvoive(Date dateOfIssue, String socialReason, String cuit, int amount, Operation operation, String concept, int taxed,
            int noTaxed, int IIBBPerception, int IVA) {

        super(dateOfIssue, socialReason, cuit, amount, operation, concept);
        this.taxed = taxed;
        this.noTaxed = noTaxed;
        this.IIBBPerception = IIBBPerception;
        this.IVA = IVA;
    }

    // ******************************************************************************************************
    // Getters and setters
    // ******************************************************************************************************

    public int getTaxed() {
        return taxed;
    }

    public void setTaxed(int taxed) {
        this.taxed = taxed;
    }

    public int getNoTaxed() {
        return noTaxed;
    }

    public void setNoTaxed(int noTaxed) {
        this.noTaxed = noTaxed;
    }

    public int getIIBBPerception() {
        return IIBBPerception;
    }

    public void setIIBBPerception(int iIBBPerception) {
        IIBBPerception = iIBBPerception;
    }

    public int getIVA() {
        return IVA;
    }

    public void setIVA(int iVA) {
        IVA = iVA;
    }

    // ******************************************************************************************************
    // Methods of class a invoive
    // ******************************************************************************************************

    private int calculatePorsentaje(int porsentaje) {
        return ((porsentaje * this.getAmount()) / 100);
    }

    public int getFinalAmount() {

        int finalAmount = 0;
        int amount = this.getAmount();
        finalAmount = amount + this.taxed + this.noTaxed + this.IIBBPerception + calculatePorsentaje(this.IVA);
        return finalAmount;
    }

}
