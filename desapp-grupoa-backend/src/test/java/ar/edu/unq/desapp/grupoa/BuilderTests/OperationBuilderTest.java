package ar.edu.unq.desapp.grupoa.BuilderTests;

import junit.framework.TestCase;
import ar.edu.unq.desapp.grupoa.helpers.builders.OperationBuilder;
import ar.edu.unq.desapp.grupoa.model.Accounts.AccountEnum;
import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.model.Operation.OperationTypeEnum;
import ar.edu.unq.desapp.grupoa.model.System.Shift;
import static org.mockito.Mockito.*;

/**
 * Test operation builder
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class OperationBuilderTest extends TestCase {

    public void testBuildVoucherWithAmount() throws Exception {

        Operation operation = OperationBuilder.aOperation().withAmount(100.0).build();

        assertEquals(100.0, operation.getAmount());
    }

    public void testBuildVoucherWithCategory() throws Exception {

        Category mockCategory = mock(Category.class);

        Operation operation = OperationBuilder.aOperation().withCategory(mockCategory).build();

        assertEquals(mockCategory, operation.getCategory());
    }
    
    public void testBuildVoucherWithSubcategory() throws Exception {

        String subcategory = "Otros";

        Operation operation = OperationBuilder.aOperation().withSubcategory(subcategory).build();

        assertEquals(subcategory, operation.getSubcategory());
    }

    public void testBuildVoucherWithShift() throws Exception {

        Shift mockShift = Shift.Tarde;

        Operation operation = OperationBuilder.aOperation().withShift(mockShift).build();

        assertEquals(mockShift, operation.getShift());
    }

    public void testBuildVoucherOperationType() throws Exception {

        OperationTypeEnum operationType = OperationTypeEnum.EGRESS;

        Operation operation = OperationBuilder.aOperation().withOperationType(operationType).build();

        assertEquals(operationType, operation.getOperationTypeEnum());
    }
    
    public void testBuildVoucherWithConcept() throws Exception {

        String concept = "Un concepto";

        Operation operation = OperationBuilder.aOperation().withConcept(concept).build();

        assertEquals(concept, operation.getConcept());
    }
    
    public void testBuildVoucherWithAccount() throws Exception {

        AccountEnum ac = AccountEnum.BankAccount;
        
        Operation operation = OperationBuilder.aOperation().withAccount(ac).build();

        assertEquals(ac, operation.getAccount());
    }
}
