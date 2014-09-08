package ar.edu.unq.desapp.grupoa;

import ar.edu.unq.desapp.grupoa.builders.IncomeBuilder;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

/**
 * Test income builder
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class IncomeBuilderTest extends TestCase {

    public void testBuildIncomeAmount() {

        Income income = IncomeBuilder.aIncome().withAmount(100).build();
        
        assertEquals(100, income.getAmount());
    }
    
    public void testBuildIncomeCategory() {

        Category mockCategory = mock(Category.class);
        
        Income income = IncomeBuilder.aIncome().withCategory(mockCategory).build();
        
        assertEquals(mockCategory, income.getCategory());
    }
    
    public void testBuildIncomeShift() {

        Shift mockShift = mock(Shift.class);
        
        Income income = IncomeBuilder.aIncome().withShift(mockShift).build();
        
        assertEquals(mockShift, income.getShift());
    }
}
