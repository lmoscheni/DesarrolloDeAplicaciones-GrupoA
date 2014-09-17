package ar.edu.unq.desapp.grupoa;

import ar.edu.unq.desapp.grupoa.Voucher;

/**
 * Class billA
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class BillA extends BillType {

    private double taxed;

    private double noTaxed;

    private double IIBBPerception;

    private double IVA;

    public BillA() {
    
    }

    public BillA(double taxed, double noTaxed, double IIBBPerception, double IVA) {
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

    private double calculatePorsentaje(double amount, double porsentaje) {
        return ((porsentaje * amount) / 100.0);
    }
    
    private double calculateTaxes(double amount) {
        return this.taxed + this.noTaxed + this.IIBBPerception + calculatePorsentaje(amount, this.IVA);
    }

    public double calculateFinalAmount(Voucher voucher) {
        double amount = voucher.getAmount();
        double finalAmount = amount + this.calculateTaxes(amount);
        return finalAmount;
    }

}
