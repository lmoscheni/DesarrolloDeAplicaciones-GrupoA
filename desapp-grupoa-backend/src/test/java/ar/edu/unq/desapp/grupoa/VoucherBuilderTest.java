package ar.edu.unq.desapp.grupoa;

import static org.mockito.Mockito.mock;

import java.util.Date;

import junit.framework.TestCase;
import ar.edu.unq.desapp.grupoa.Voucher;
import ar.edu.unq.desapp.grupoa.builders.VoucherBuilder;

/**
 * Test voucher builder
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class VoucherBuilderTest extends TestCase {

    public void testBuildVoucherAmount() {

        Voucher voucher = VoucherBuilder.aVoucher().withAmount(100).build();

        assertEquals(100, voucher.getAmount());
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

        Operation mockOperation = mock(Operation.class);

        Voucher voucher = VoucherBuilder.aVoucher().withOperation(mockOperation).build();
        assertEquals(mockOperation, voucher.getOperation());
    }

    public void testBuildVoucherSocialReason() {

        Voucher voucher = VoucherBuilder.aVoucher().withSocialReason("A reason").build();
        assertEquals("A reason", voucher.getSocialReason());
    }
    
    public void testBuildVoucherConcept() {

        Category mockConcept = mock(Category.class);
        
        Voucher voucher = VoucherBuilder.aVoucher().withConcept(mockConcept).build();
        assertEquals(mockConcept, voucher.getConcept());
    }
}
