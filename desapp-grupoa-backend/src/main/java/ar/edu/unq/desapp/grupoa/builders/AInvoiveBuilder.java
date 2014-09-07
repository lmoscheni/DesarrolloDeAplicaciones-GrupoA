package ar.edu.unq.desapp.grupoa.builders;

import java.util.Date;

import ar.edu.unq.desapp.grupoa.AInvoive;
import ar.edu.unq.desapp.grupoa.Voucher;
import ar.edu.unq.desapp.grupoa.mocks.Operation;

public class AInvoiveBuilder {

    public static AInvoiveBuilder aAInvoive() {
        return new AInvoiveBuilder();
    }

    private Date dateOfIssue;

    private String socialReason;

    private String cuit;

    private int amount;

    private Operation operation;

    private int taxed;

    private int noTaxed;

    private int IIBBPerception;

    private int IVA;

    public AInvoive build() {
        return new AInvoive(dateOfIssue, socialReason, cuit, amount, operation, taxed, noTaxed, IIBBPerception, IVA);
    }

    public AInvoiveBuilder withDate(Date date) {
        this.dateOfIssue = date;
        return this;
    }

    public AInvoiveBuilder withSocialReason(String socialReason) {
        this.socialReason = socialReason;
        return this;
    }

    public AInvoiveBuilder withCuit(String cuit) {
        this.cuit = cuit;
        return this;
    }

    public AInvoiveBuilder withAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public AInvoiveBuilder withOperation(Operation operation) {
        this.operation = operation;
        return this;
    }

    public AInvoiveBuilder withTaxed(int taxed) {
        this.taxed = taxed;
        return this;
    }

    public AInvoiveBuilder withNoTaxed(int noTaxed) {
        this.noTaxed = noTaxed;
        return this;
    }

    public AInvoiveBuilder withIIBBPerception(int IIBBPerception) {
        this.IIBBPerception = IIBBPerception;
        return this;
    }

    public AInvoiveBuilder withIVA(int IVA) {
        this.IVA = IVA;
        return this;
    }
}
