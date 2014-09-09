package ar.edu.unq.desapp.grupoa;

import static org.mockito.Mockito.*;

import java.util.Date;

import junit.framework.TestCase;
import ar.edu.unq.desapp.grupoa.builders.VoucherBuilder;

/**
 * Test voucher
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class VoucherTest extends TestCase {

    // ***********************************************************************************************************
    // Test Getters and setters
    // ***********************************************************************************************************

    public void testGetAndSetDateOfIssue() {

        Date mockDate = mock(Date.class);

        Voucher voucher = new Voucher();
        voucher.setDateOfIssue(mockDate);

        assertEquals(mockDate, voucher.getDateOfIssue());
    }

    public void testGetAndSetSocialReason() {

        Voucher voucher = new Voucher();
        voucher.setSocialReason("A reason");

        assertEquals("A reason", voucher.getSocialReason());
    }

    public void testGetAndSetCuit() {

        Voucher voucher = new Voucher();
        voucher.setCuit("21-569485-2");

        assertEquals("21-569485-2", voucher.getCuit());
    }

    public void testGetAndSetAmount() {

        Voucher voucher = new Voucher();
        voucher.setAmount(100.0);
        ;

        assertEquals(100.0, voucher.getAmount());
    }

    public void testGetAndSetOperation() {

        BillType mockBillType = mock(BillType.class);

        Voucher voucher = new Voucher();
        voucher.setBillType(mockBillType);
        ;

        assertEquals(mockBillType, voucher.getBillType());
    }

    public void testGetAndSetCategory() {

        Category mockConcept = mock(Category.class);

        Voucher voucher = new Voucher();
        voucher.setConcept(mockConcept);

        assertEquals(mockConcept, voucher.getConcept());
    }

    // ***********************************************************************************************************
    // Test methods
    // ***********************************************************************************************************

    public void testGetFinalAmount() {

        BillType mockBillType = mock(BillType.class);
        when(mockBillType.calculateFinalAmount(any(Voucher.class))).thenReturn(100.0);

        Voucher voucher = VoucherBuilder.aVoucher().withAmount(100).withBillType(mockBillType).build();

        assertEquals(100.0, voucher.getFinalAmount());
    }
}
