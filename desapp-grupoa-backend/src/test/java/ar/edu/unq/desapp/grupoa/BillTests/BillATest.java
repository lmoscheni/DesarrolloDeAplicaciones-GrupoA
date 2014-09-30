package ar.edu.unq.desapp.grupoa.BillTests;

import ar.edu.unq.desapp.grupoa.helpers.builders.BillABuilder;
import ar.edu.unq.desapp.grupoa.model.Bills.BillA;
import ar.edu.unq.desapp.grupoa.model.System.Voucher;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

/**
 * Test a invoive
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class BillATest extends TestCase {

    // *****************************************************************************************************
    // Test getters and setters
    // *****************************************************************************************************

    public void testGetAndSetTaxed() {

        BillA billA = new BillA();
        billA.setTaxed(10.0);

        assertEquals(10.0, billA.getTaxed());
    }

    public void testGetAndSetNoTaxed() {

        BillA billA = new BillA();
        billA.setNoTaxed(10.0);

        assertEquals(10.0, billA.getNoTaxed());
    }

    public void testGetAndSetIIBBPerception() {

        BillA billA = new BillA();
        billA.setIIBBPerception(10.0);

        assertEquals(10.0, billA.getIIBBPerception());
    }

    public void testGetAndSetIVA() {

        BillA billA = new BillA();
        billA.setIVA(10.0);

        assertEquals(10.0, billA.getIVA());
    }

    // *****************************************************************************************************
    // Test of methods
    // *****************************************************************************************************

    public void testCalculatePorsentaje() {

    }

    public void testCalculateFinalAmount() {

        Voucher mockVoucher = mock(Voucher.class);
        when(mockVoucher.getAmount()).thenReturn(100.0);

        BillA billA = BillABuilder.aBillA().withTaxed(10).withNoTaxed(5).withIIBBPerception(3).withIVA(10).build();

        assertEquals(128.0, billA.calculateFinalAmount(mockVoucher));
    }
}
