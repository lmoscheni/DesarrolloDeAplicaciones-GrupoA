package ar.edu.unq.desapp.grupoa.OperationTests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Date;

import junit.framework.TestCase;
import ar.edu.unq.desapp.grupoa.helpers.builders.OperationBuilder;
import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.model.Operation.OperationTypeEnum;
import ar.edu.unq.desapp.grupoa.model.System.Shift;

/**
 * Test operation
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class OperationTest extends TestCase {

    // ***********************************************************************************************************
    // Test Getters and setters
    // ***********************************************************************************************************

    public void testGetAndSetAmount() throws Exception {

        Operation operation = new Operation();
        operation.setAmount(100.0);

        assertEquals(100.0, operation.getAmount());
    }
    
    public void testGetAndSetId() {

        Operation operation = new Operation();
        Integer i = new Integer(1);
        operation.setId(i);

        assertEquals(i, operation.getId());
    }

    public void testGetAndSetSubcategories() {

        Operation operation = new Operation();
        operation.setSubcategory("Alfajor");;

        assertEquals("Alfajor", operation.getSubcategory());
    }
    
    public void testGetAndSetCategory() {

        Category mockCategory = mock(Category.class);

        Operation operation = new Operation();
        operation.setCategory(mockCategory);

        assertEquals(mockCategory, operation.getCategory());
    }

    public void testGetAndSetShift() {

        Shift mockShift = Shift.TARDE;

        Operation operation = new Operation();
        operation.setShift(mockShift);

        assertEquals(mockShift, operation.getShift());
    }

    public void testGetAndSetOperationType() {

        OperationTypeEnum operationType = OperationTypeEnum.EGRESS;

        Operation operation = new Operation();
        operation.setOperationType(operationType);

        assertEquals(operationType, operation.getOperationType());
    }

    public void testGetAndSetDateOperation() {

        Date mockDate = mock(Date.class);

        Operation operation = new Operation();
        operation.setDateOperation(mockDate);

        assertEquals(mockDate, operation.getDateOperation());
    }

    // ***********************************************************************************************************
    // Test methods
    // ***********************************************************************************************************

    public void testApplyOperation() throws Exception {

        OperationTypeEnum operationType = OperationTypeEnum.INCOME;
        Account mockAccount = mock(Account.class);

        Operation operation = OperationBuilder.aOperation().withOperationType(operationType).build();

        operation.applyOperation(mockAccount);

        verify(operationType, times(1)).getOperationTypeEnum(operationType).chargeOperation(operation, mockAccount);
    }
}
