package ar.edu.unq.desapp.grupoa.builders;

import java.util.Date;

import ar.edu.unq.desapp.grupoa.Voucher;
import ar.edu.unq.desapp.grupoa.mocks.Operation;

/**
 * Class builder
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class VoucherBuilder {

    public static VoucherBuilder aVoucher() {
        return new VoucherBuilder();
    }

    private Date dateOfIssue;

    private String socialReason;

    private String cuit;

    // private Category concept;
    private int amount;

    private Operation operation;

    public Voucher build() {
        return new Voucher(dateOfIssue, socialReason, cuit, amount, operation);
    }

    public VoucherBuilder withDate(Date date) {
        this.dateOfIssue = date;
        return this;
    }

    public VoucherBuilder withSocialReason(String socialReason) {
        this.socialReason = socialReason;
        return this;
    }

    public VoucherBuilder withCuit(String cuit) {
        this.cuit = cuit;
        return this;
    }

    public VoucherBuilder withAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public VoucherBuilder withOperation(Operation operation) {
        this.operation = operation;
        return this;
    }
}
