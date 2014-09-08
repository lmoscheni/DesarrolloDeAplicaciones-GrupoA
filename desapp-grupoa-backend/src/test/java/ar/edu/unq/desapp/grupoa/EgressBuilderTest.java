package ar.edu.unq.desapp.grupoa;

import static org.mockito.Mockito.mock;
import junit.framework.TestCase;
import ar.edu.unq.desapp.grupoa.builders.EgressBuilder;

/**
 * Test egress builder
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class EgressBuilderTest extends TestCase{

    public void testBuildIncomeAmount() {

        Egress egress = EgressBuilder.aEgress().withAmount(100).build();
        
        assertEquals(100, egress.getAmount());
    }
    
    public void testBuildIncomeCategory() {

        Category mockCategory = mock(Category.class);
        
        Egress egress = EgressBuilder.aEgress().withCategory(mockCategory).build();
        
        assertEquals(mockCategory, egress.getCategory());
    }
    
    public void testBuildIncomeShift() {

        Shift mockShift = Shift.EVENING;
        
        Egress egress = EgressBuilder.aEgress().withShift(mockShift).build();
        
        assertEquals(mockShift, egress.getShift());
    }
}
