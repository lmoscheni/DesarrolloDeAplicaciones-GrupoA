package ar.edu.unq.desapp.grupoa.BuilderTests;

import static org.mockito.Mockito.mock;

import java.util.Date;

import junit.framework.TestCase;
import ar.edu.unq.desapp.grupoa.helpers.builders.VoucherBuilder;
import ar.edu.unq.desapp.grupoa.model.Bills.BillType;
import ar.edu.unq.desapp.grupoa.model.System.Voucher;

/**
 * Test voucher builder
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class VoucherBuilderTest extends TestCase {

    public void testBuildVoucherAmount() {

        Voucher voucher = VoucherBuilder.aVoucher().withAmount(100.0).build();

        assertEquals(100.0, voucher.getAmount());
    }

    public void testBuildVoucherCuit() {

        Voucher voucher = VoucherBuilder.aVoucher().withCuit("24-568974-2").build();

        assertEquals("24-568974-2", voucher.getCuit());
    }

    public void testBuildVoucherDate() {

        Date mockDate = mock(Date.class);

        Voucher voucher = VoucherBuilder.aVoucher().withDate(mockDate).build();
        assertEquals(mockDate, voucher.getDateOfIssue());
    }

    public void testBuildVoucherOperation() {

        BillType mockBillType = mock(BillType.class);

        Voucher voucher = VoucherBuilder.aVoucher().withBillType(mockBillType).build();
        assertEquals(mockBillType, voucher.getBillType());
    }

    public void testBuildVoucherSocialReason() {

        Voucher voucher = VoucherBuilder.aVoucher().withSocialReason("A reason").build();
        assertEquals("A reason", voucher.getSocialReason());
    }

    public void testBuildVoucherConcept() {

        Voucher voucher = VoucherBuilder.aVoucher().withConcept("concept").build();
        assertEquals("concept", voucher.getConcept());
    }
}
