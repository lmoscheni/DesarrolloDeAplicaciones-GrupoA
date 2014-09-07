package ar.edu.unq.desapp.grupoa;

import static org.mockito.Mockito.mock;

import java.util.Date;

import ar.edu.unq.desapp.grupoa.builders.AInvoiveBuilder;
import ar.edu.unq.desapp.grupoa.mocks.Operation;
import junit.framework.TestCase;


/**
 * Test a invoive builder
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class AInvoiveBuilderTest extends TestCase {

    public void testBuildVoucherWithAmount() {

        AInvoive ainvoive = AInvoiveBuilder.aAInvoive().withAmount(100).build();

        assertEquals(100, ainvoive.getAmount());
    }

    public void testBuildVoucherWithCuit() {

        AInvoive ainvoive = AInvoiveBuilder.aAInvoive().withCuit("24-568974-2").build();

        assertEquals("24-568974-2", ainvoive.getCuit());
    }

    public void testBuildVoucherWithDate() {

        Date mockDate = mock(Date.class);

        AInvoive ainvoive = AInvoiveBuilder.aAInvoive().withDate(mockDate).build();

        assertEquals(mockDate, ainvoive.getDateOfIssue());
    }

    public void testBuildVoucherWithOperation() {

        Operation mockOperation = mock(Operation.class);

        AInvoive ainvoive = AInvoiveBuilder.aAInvoive().withOperation(mockOperation).build();

        assertEquals(mockOperation, ainvoive.getOperation());
    }

    public void testBuildVoucherConcept() {

        AInvoive ainvoive = AInvoiveBuilder.aAInvoive().withConcept("ventas 28/04").build();
        assertEquals("ventas 28/04", ainvoive.getConcept());
    }
    
    public void testBuildVoucherWithSocialReason() {

        AInvoive ainvoive = AInvoiveBuilder.aAInvoive().withSocialReason("A reason").build();

        assertEquals("A reason", ainvoive.getSocialReason());
    }

    public void testBuildVoucherWithTaxed() {

        AInvoive ainvoive = AInvoiveBuilder.aAInvoive().withTaxed(10).build();

        assertEquals(10, ainvoive.getTaxed());
    }

    public void testBuildVoucherWithNoTaxed() {

        AInvoive ainvoive = AInvoiveBuilder.aAInvoive().withNoTaxed(3).build();

        assertEquals(3, ainvoive.getNoTaxed());
    }

    public void testBuildVoucherWithIIBBPerception() {

        AInvoive ainvoive = AInvoiveBuilder.aAInvoive().withIIBBPerception(5).build();

        assertEquals(5, ainvoive.getIIBBPerception());
    }

    public void testBuildVoucherWithIVA() {

        AInvoive ainvoive = AInvoiveBuilder.aAInvoive().withIVA(10).build();

        assertEquals(10, ainvoive.getIVA());
    }
}
