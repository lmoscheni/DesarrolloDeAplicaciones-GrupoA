package ar.edu.unq.desapp.grupoa.model.Bills;

import ar.edu.unq.desapp.grupoa.model.System.Voucher;

/**
 * Class billA
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class BillA extends BillType {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private double taxed;

    private double noTaxed;

    private double IIBBPerception;

    private double IVA;

    public BillA() {
        super("BillA");
    }

    public BillA(double taxed, double noTaxed, double IIBBPerception, double IVA) {
        super("BillA");
        this.taxed = taxed;
        this.noTaxed = noTaxed;
        this.IIBBPerception = IIBBPerception;
        this.IVA = IVA;
    }

    // ******************************************************************************************************
    // Getters and setters
    // ******************************************************************************************************

    public double getTaxed() {
        return taxed;
    }

    public void setTaxed(double taxed) {
        this.taxed = taxed;
    }

    public double getNoTaxed() {
        return noTaxed;
    }

    public void setNoTaxed(double noTaxed) {
        this.noTaxed = noTaxed;
    }

    public double getIIBBPerception() {
        return IIBBPerception;
    }

    public void setIIBBPerception(double iIBBPerception) {
        IIBBPerception = iIBBPerception;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double iVA) {
        IVA = iVA;
    }

    // ******************************************************************************************************
    // Methods of class a invoive
    // ******************************************************************************************************
    
    private double calculateTaxes(double amount) {
        return this.taxed + this.noTaxed + this.IIBBPerception + this.IVA;
    }

    public double calculateFinalAmount(Voucher voucher) {
        double amount = voucher.getAmount();
        double finalAmount = amount + this.calculateTaxes(amount);
        return finalAmount;
    }

}
