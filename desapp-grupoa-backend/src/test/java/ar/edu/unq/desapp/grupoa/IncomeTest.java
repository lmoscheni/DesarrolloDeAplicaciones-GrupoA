package ar.edu.unq.desapp.grupoa;

import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class IncomeTest extends TestCase {

    // ***********************************************************************************************************
    // Test Getters and setters
    // ***********************************************************************************************************
    
    public void testGetAndSetAmount(){
        
        Income income = new Income();
        income.setAmount(100);
        
        assertEquals(100, income.getAmount());
    }
    
    public void testGetAndSetCategory(){
        
        Category mockCategory = mock(Category.class);
        
        Income income = new Income();
        income.setCategory(mockCategory);
        
        assertEquals(mockCategory, income.getCategory());
    }
    
    public void testGetAndSetShift(){
        
        Shift mockShift = mock(Shift.class);
        
        Income income = new Income();
        income.setShift(mockShift);
        
        assertEquals(mockShift, income.getShift());
    }
    
    // ***********************************************************************************************************
    // Test of methods
    // ***********************************************************************************************************
    
    public void testIsIncome(){
        
        Income income = new Income();
        
        assertEquals(true, income.isIncome());
    }
    
    public void testIsEgress(){
        
        Income income = new Income();
        
        assertEquals(false, income.isEgress());
    }
    
    public void testPerformOperation(){
        
        assertTrue(true);
    }
    
}
