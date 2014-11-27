package ar.edu.unq.desapp.grupoa.OperationTests;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.model.Operation.Egress;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import junit.framework.TestCase;

public class EgressTest extends TestCase {

    // ***********************************************************************************************************
    // Test Getters and setters
    // ***********************************************************************************************************

    public void testGetAndSetId() {

        Egress egress = new Egress();
        Integer i = new Integer(1);
        egress.setId(i);
        
        assertEquals(i, egress.getId());
    }
    
    // ***********************************************************************************************************
    // Test of methods
    // ***********************************************************************************************************

    public void testIsIncome() {

        Egress egress = new Egress();

        assertEquals(false, egress.isIncome());
    }

    public void testChargeOperation() {

        Egress egress = new Egress();

        Account mockAccount = mock(Account.class);
        Operation mockOperation = mock(Operation.class);

        egress.chargeOperation(mockOperation, mockAccount);

        verify(mockAccount, times(1)).decreaseBalance(anyInt());
        verify(mockOperation, times(1)).getAmount();

    }
}
