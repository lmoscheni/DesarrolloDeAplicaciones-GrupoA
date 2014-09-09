package ar.edu.unq.desapp.grupoa;

import junit.framework.TestCase;


import ar.edu.unq.desapp.grupoa.builders.OperationBuilder;
import static org.mockito.Mockito.*;

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

    public void testGetAndSetAmount() {

        Operation operation = new Operation();
        operation.setAmount(100.0);

        assertEquals(100.0, operation.getAmount());
    }

    public void testGetAndSetCategory() {

        Category mockCategory = mock(Category.class);

        Operation operation = new Operation();
        operation.setCategory(mockCategory);

        assertEquals(mockCategory, operation.getCategory());
    }

    public void testGetAndSetShift() {

        Shift mockShift = Shift.EVENING;

        Operation operation = new Operation();
        operation.setShift(mockShift);

        assertEquals(mockShift, operation.getShift());
    }

    public void testGetAndSetOperationType() {

        OperationType mockOperationType = mock(OperationType.class);

        Operation operation = new Operation();
        operation.setOperationType(mockOperationType);

        assertEquals(mockOperationType, operation.getOperationType());
    }

    // ***********************************************************************************************************
    // Test methods
    // ***********************************************************************************************************

    public void testApplyOperation() {

        OperationType mockOperationType = mock(OperationType.class);
        Account mockAccount = mock(Account.class);

        Operation operation = OperationBuilder.aOperation().withOperationType(mockOperationType).build();

        operation.applyOperation(mockAccount);

        verify(mockOperationType, times(1)).chargeOperation(operation, mockAccount);
    }
}
