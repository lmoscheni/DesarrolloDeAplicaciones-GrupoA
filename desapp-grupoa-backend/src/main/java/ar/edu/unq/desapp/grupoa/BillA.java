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

    private int taxed;

    private int noTaxed;

    private int IIBBPerception;

    private int IVA;

    public BillA(){}
    
    public BillA(int taxed, int noTaxed, int IIBBPerception, int IVA) {
        
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

    private int calculatePorsentaje(int amount,int porsentaje) {
        return ((porsentaje * amount) / 100);
    }

    public int calculateFinalAmount(Voucher voucher) {

        int finalAmount = 0;
        int amount = voucher.getAmount();
        finalAmount = amount + this.taxed + this.noTaxed + this.IIBBPerception + calculatePorsentaje(amount,this.IVA);
        return finalAmount;
    }

}
