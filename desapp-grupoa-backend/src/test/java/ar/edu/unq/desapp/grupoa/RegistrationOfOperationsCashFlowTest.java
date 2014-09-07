package ar.edu.unq.desapp.grupoa;

import static org.mockito.Mockito.mock;
import junit.framework.TestCase;

public class RegistrationOfOperationsCashFlowTest extends TestCase {

    public void testRegistrateOperation(){
        
        RegistrationOfOperationsCashFlow system = new RegistrationOfOperationsCashFlow();
        Operation mockOperation = mock(Operation.class);
        
        system.registrateOperation(mockOperation);
        
        assertEquals(1, system.getOperations().size());
    }
}
