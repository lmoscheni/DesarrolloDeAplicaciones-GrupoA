package ar.edu.unq.desapp.grupoa;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class RegistrationOfOperationsCashFlowTest extends TestCase {

    public void testRegistrateOperation() {
        List<Account> accounts = new ArrayList<Account>();
        RegistrationOfOperationsCashFlow system = new RegistrationOfOperationsCashFlow(accounts);
        Operation mockOperation = mock(Operation.class);

        system.registrateOperation(mockOperation);

        assertEquals(1, system.getOperations().size());
    }
}
