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

    //*****************************************************************************************************
    // Test getters and setters
    //*****************************************************************************************************
    
    public void testGetAndSetTaxed(){
        
        AInvoive ainvoive = new AInvoive();
        ainvoive.setTaxed(10);
        
        assertEquals(10, ainvoive.getTaxed());
    }
    
    public void testGetAndSetNoTaxed(){
        
        AInvoive ainvoive = new AInvoive();
        ainvoive.setNoTaxed(10);
        
        assertEquals(10, ainvoive.getNoTaxed());
    }

    public void testGetAndSetIIBBPerception(){
    
        AInvoive ainvoive = new AInvoive();
        ainvoive.setIIBBPerception(10);
    
        assertEquals(10, ainvoive.getIIBBPerception());
    }

    public void testGetAndSetIVA(){
        
        AInvoive ainvoive = new AInvoive();
        ainvoive.setIVA(10);
    
        assertEquals(10, ainvoive.getIVA());
    }
    
    //*****************************************************************************************************
    // Test of methods
    //*****************************************************************************************************
    
    public void testCalculatePorsentaje(){
        
    }
    
    public void testGetFinalAmount() {

        AInvoive ainvoive = AInvoiveBuilder.aAInvoive().withAmount(100).withTaxed(10).withNoTaxed(5)
                .withIIBBPerception(3).withIVA(10).build();

        assertEquals(128, ainvoive.getFinalAmount());
    }
}
