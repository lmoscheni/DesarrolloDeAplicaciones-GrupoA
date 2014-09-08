package ar.edu.unq.desapp.grupoa.builders;

import java.util.Date;

import ar.edu.unq.desapp.grupoa.BillType;
import ar.edu.unq.desapp.grupoa.Category;
import ar.edu.unq.desapp.grupoa.Voucher;

/**
 * Class voucher builder
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

    private Category concept;
    
    private int amount;

    private BillType billType;

    public Voucher build() {
        return new Voucher(dateOfIssue, socialReason, cuit, amount, billType, concept);
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

    public VoucherBuilder withBillType(BillType billType) {
        this.billType = billType;
        return this;
    }
    
    public VoucherBuilder withConcept(Category concept) {
        this.concept = concept;
        return this;
    }
}
