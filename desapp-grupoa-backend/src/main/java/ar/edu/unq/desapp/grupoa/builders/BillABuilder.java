package ar.edu.unq.desapp.grupoa.builders;

import ar.edu.unq.desapp.grupoa.BillA;


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

    private int taxed;

    private int noTaxed;

    private int IIBBPerception;

    private int IVA;

    public BillA build() {
        return new BillA(taxed, noTaxed, IIBBPerception, IVA);
    }

    public BillABuilder withTaxed(int taxed) {
        this.taxed = taxed;
        return this;
    }

    public BillABuilder withNoTaxed(int noTaxed) {
        this.noTaxed = noTaxed;
        return this;
    }

    public BillABuilder withIIBBPerception(int IIBBPerception) {
        this.IIBBPerception = IIBBPerception;
        return this;
    }

    public BillABuilder withIVA(int IVA) {
        this.IVA = IVA;
        return this;
    }
}
