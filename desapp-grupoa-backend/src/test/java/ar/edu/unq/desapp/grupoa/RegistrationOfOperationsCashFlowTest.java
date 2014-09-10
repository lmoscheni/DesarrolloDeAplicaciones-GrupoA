package ar.edu.unq.desapp.grupoa;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

        system.registrateOperation(mockOperation);

        assertEquals(1, system.getOperations().size());
    }

}
