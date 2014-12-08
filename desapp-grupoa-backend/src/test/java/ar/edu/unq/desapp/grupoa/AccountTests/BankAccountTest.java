package ar.edu.unq.desapp.grupoa.AccountTests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.edu.unq.desapp.grupoa.model.Accounts.BankAccount;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.model.Operation.OperationTypeEnum;
import static org.mockito.Mockito.*;
import junit.framework.TestCase;

public class BankAccountTest extends TestCase {

    
 // ***********************************************************************************************************
    // Test Getters and setters
    // ***********************************************************************************************************

    public void testGetAnsSetCurrently() {

        Date mockDate = mock(Date.class);
        
        BankAccount account = new BankAccount();
        account.setCurrently(mockDate);


        assertEquals(mockDate, account.getCurrently());
    }

    @SuppressWarnings("unchecked")
    public void testGetAndSetPendinOperations() {

        List<Operation> mockListOperations = mock(ArrayList.class);

        BankAccount account = new BankAccount();
        account.setPendingOperations(mockListOperations);

        assertEquals(mockListOperations, account.getPendingOperations());
    }

    public void testGetAccrued() {

        BankAccount account = new BankAccount();

        assertEquals(0.0, account.getAccrued());
    }
    
    public void testGetAndSetDelayTime() {

        BankAccount account = new BankAccount();
        account.setDelayTime(10);
        
        assertEquals(10, account.getDelayTime());
    }
    
    // ***********************************************************************************************************
    // Test methods
    // ***********************************************************************************************************
    
    public void testIsBankAccount() {

        BankAccount bankAccount = new BankAccount();

        assertTrue(bankAccount.isBankAccount());
    }

    public void testIncreaseBalance() {

        BankAccount bankAccount = new BankAccount();
        bankAccount.increaseBalance(100.0);

        assertEquals(100.0, bankAccount.getAccrued());
    }

    public void testDecreaseBalance() {

        BankAccount bankAccount = new BankAccount();
        bankAccount.increaseBalance(100.0);

        assertEquals(100.0, bankAccount.getAccrued());

        bankAccount.decreaseBalance(50.0);

        assertEquals(50.0, bankAccount.getAccrued());
    }
    
    public void testRegistrateOperation() {

        Operation mockOperation = mock(Operation.class);

        BankAccount account = new BankAccount();

        assertEquals(0, account.getOperations().size());

        account.registrateOperation(mockOperation);

        assertEquals(1, account.getPendingOperations().size());
    }
    
    public void testCancelOperation(){
        
        Operation mockOperation = mock(Operation.class);
        when(mockOperation.getId()).thenReturn(new Integer(1));
        when(mockOperation.getOperationTypeEnum()).thenReturn(OperationTypeEnum.INCOME);
        
        BankAccount account = new BankAccount();

        assertEquals(0, account.getPendingOperations().size());

        account.registrateOperation(mockOperation);

        assertEquals(1, account.getPendingOperations().size());
        
        account.cancelOperation(mockOperation);
        
        assertEquals(0, account.getPendingOperations().size());
    }
    
//    @SuppressWarnings("deprecation")
//    public void testTheOperationWasConsolidated(){
//        
//        Date mockDateOperation = mock(Date.class);
//        Operation mockOperation = mock(Operation.class);
//        
//        when(mockOperation.getDateOperation()).thenReturn(mockDateOperation);
//        when(mockDateOperation.getDate()).thenReturn(2);
//        
//        BankAccount account = new BankAccount();
//        account.setDelayTime(15);
//        boolean returnValue = account.theOperationWasConsolidated(mockOperation);
//        
//        assertTrue(returnValue);
//    }
}
