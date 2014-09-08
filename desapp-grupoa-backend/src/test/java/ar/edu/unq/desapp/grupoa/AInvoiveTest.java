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
    
    public void testGetTaxed(){
        
        AInvoive ainvoive = AInvoiveBuilder.aAInvoive().withTaxed(100).build();
        
        assertEquals(100, ainvoive.getTaxed());
    }
    
    public void testGetNoTaxed(){
        
        AInvoive ainvoive = AInvoiveBuilder.aAInvoive().withNoTaxed(100).build();
        
        assertEquals(100, ainvoive.getNoTaxed());
    }
    
    public void testGetIIBBPerception(){
    
        AInvoive ainvoive = AInvoiveBuilder.aAInvoive().withIIBBPerception(100).build();
    
        assertEquals(100, ainvoive.getIIBBPerception());
    }

    public void testGetIVA(){
    
        AInvoive ainvoive = AInvoiveBuilder.aAInvoive().withIVA(10).build();
    
        assertEquals(100, ainvoive.getIVA());
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
