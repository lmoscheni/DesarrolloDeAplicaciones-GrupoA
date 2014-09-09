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
    // Test of methods
    // ***********************************************************************************************************
    
    public void testIsIncome(){
        
        Income income = new Income();
        
        assertEquals(true, income.isIncome());
    }
    
    
    public void testChargeOperation(){
        
        Income income = new Income();
        
        Account mockAccount = mock(Account.class);
        Operation mockOperation = mock(Operation.class);
        
        income.chargeOperation(mockOperation, mockAccount);
        
        verify(mockAccount, times(1)).increaseBalance(anyInt());
        verify(mockOperation, times(1)).getAmount();
        
    }
    
}
