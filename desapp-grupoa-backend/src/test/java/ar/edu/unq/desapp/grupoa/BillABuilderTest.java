package ar.edu.unq.desapp.grupoa;

import ar.edu.unq.desapp.grupoa.Bills.BillA;
import ar.edu.unq.desapp.grupoa.builders.BillABuilder;
import junit.framework.TestCase;

/**
 * Test a invoive builder
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class BillABuilderTest extends TestCase {

    public void testBuildVoucherWithTaxed() {

        BillA billA = BillABuilder.aBillA().withTaxed(10.0).build();

        assertEquals(10.0, billA.getTaxed());
    }

    public void testBuildVoucherWithNoTaxed() {

        BillA billA = BillABuilder.aBillA().withNoTaxed(3.0).build();

        assertEquals(3.0, billA.getNoTaxed());
    }

    public void testBuildVoucherWithIIBBPerception() {

        BillA billA = BillABuilder.aBillA().withIIBBPerception(5.0).build();

        assertEquals(5.0, billA.getIIBBPerception());
    }

    public void testBuildVoucherWithIVA() {

        BillA billA = BillABuilder.aBillA().withIVA(10.0).build();

        assertEquals(10.0, billA.getIVA());
    }
}
