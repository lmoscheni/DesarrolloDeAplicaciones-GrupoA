package ar.edu.unq.desapp.grupoa;

import static org.mockito.Mockito.mock;
import junit.framework.TestCase;

public class EgressTest extends TestCase {

 // ***********************************************************************************************************
    // Test Getters and setters
    // ***********************************************************************************************************
    
    public void testGetAndSetAmount(){
        
        Egress egress = new Egress();
        egress.setAmount(100);
        
        assertEquals(100, egress.getAmount());
    }
    
    public void testGetAndSetCategory(){
        
        Category mockCategory = mock(Category.class);
        
        Egress egress= new Egress();
        egress.setCategory(mockCategory);
        
        assertEquals(mockCategory, egress.getCategory());
    }
    
    public void testGetAndSetShift(){
        
        Shift mockShift = mock(Shift.class);
        
        Egress egress = new Egress();
        egress.setShift(mockShift);
        
        assertEquals(mockShift, egress.getShift());
    }
    
    // ***********************************************************************************************************
    // Test of methods
    // ***********************************************************************************************************
    
    public void testIsIncome(){
        
        Egress egress = new Egress();
        
        assertEquals(false, egress.isIncome());
    }
    
    public void testIsEgress(){
        
        Egress egress = new Egress();
        
        assertEquals(true, egress.isEgress());
    }
    
    public void testPerformOperation(){
        
        assertTrue(true);
    }
}
