package ar.edu.unq.desapp.grupoa;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import junit.framework.TestCase;

public class EgressTest extends TestCase {

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

        verify(mockAccount, times(1)).increaseBalance(anyInt());
        verify(mockOperation, times(1)).getAmount();

    }
}
