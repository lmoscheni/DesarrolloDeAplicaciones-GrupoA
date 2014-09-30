package ar.edu.unq.desapp.grupoa;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoa.Accounts.Account;
import ar.edu.unq.desapp.grupoa.Operation.Operation;
import ar.edu.unq.desapp.grupoa.System.RegistrationOfOperationsCashFlow;
import junit.framework.TestCase;

/**
 * Test registration of operation cash flow
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class RegistrationOfOperationsCashFlowTest extends TestCase {

    public void testRegistrateOperation() {
        
        List<Account> accounts = new ArrayList<Account>();
        RegistrationOfOperationsCashFlow system = new RegistrationOfOperationsCashFlow(accounts);
        
        Operation mockOperation = mock(Operation.class);
        Account mockAccount = mock(Account.class);
        
        system.registrateOperation(mockOperation, mockAccount);

        assertEquals(1, system.getOperations().size());
        verify(mockOperation, times(1)).applyOperation(mockAccount);
    }

}
