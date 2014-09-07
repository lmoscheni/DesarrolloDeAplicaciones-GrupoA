package ar.edu.unq.desapp.grupoa;

import ar.edu.unq.desapp.grupoa.builders.AInvoiveBuilder;
import junit.framework.TestCase;

/**
 * Test a invoive
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class AInvoiveTest extends TestCase {

    public void testGetFinalAmount() {

        AInvoive ainvoive = AInvoiveBuilder.aAInvoive().withAmount(100).withTaxed(10).withNoTaxed(5)
                .withIIBBPerception(3).withIVA(10).build();

        assertEquals(128, ainvoive.getFinalAmount());
    }
}
