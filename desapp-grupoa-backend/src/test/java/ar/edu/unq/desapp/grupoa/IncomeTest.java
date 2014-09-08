package ar.edu.unq.desapp.grupoa;

import junit.framework.TestCase;
import static org.mockito.Mockito.*;

/**
 * Test income
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

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
        
        Shift mockShift = Shift.EVENING;
        
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
