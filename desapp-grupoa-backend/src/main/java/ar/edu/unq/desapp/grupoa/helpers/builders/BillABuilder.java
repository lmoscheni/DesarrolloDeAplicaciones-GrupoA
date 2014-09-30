package ar.edu.unq.desapp.grupoa.helpers.builders;

import ar.edu.unq.desapp.grupoa.model.Bills.BillA;

/**
 * Class a invoive builder
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class BillABuilder {

    public static BillABuilder aBillA() {
        return new BillABuilder();
    }

    private double taxed;

    private double noTaxed;

    private double IIBBPerception;

    private double IVA;

    public BillA build() {
        return new BillA(taxed, noTaxed, IIBBPerception, IVA);
    }

    public BillABuilder withTaxed(double taxed) {
        this.taxed = taxed;
        return this;
    }

    public BillABuilder withNoTaxed(double noTaxed) {
        this.noTaxed = noTaxed;
        return this;
    }

    public BillABuilder withIIBBPerception(double IIBBPerception) {
        this.IIBBPerception = IIBBPerception;
        return this;
    }

    public BillABuilder withIVA(double IVA) {
        this.IVA = IVA;
        return this;
    }
}
