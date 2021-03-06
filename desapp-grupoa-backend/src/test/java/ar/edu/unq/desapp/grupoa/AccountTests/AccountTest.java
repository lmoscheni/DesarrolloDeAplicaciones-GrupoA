package ar.edu.unq.desapp.grupoa.AccountTests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.model.Operation.OperationTypeEnum;
import junit.framework.TestCase;

/**
 * Test account
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class AccountTest extends TestCase{

    // ***********************************************************************************************************
    // Test Getters and setters
    // ***********************************************************************************************************

    public void testGetAnsSetBalance() {

        Account account = new Account();
        account.setBalance(100.0);

        assertTrue(100.0 == account.getBalance());
    }

    @SuppressWarnings("unchecked")
    public void testGetAndSetOperations() {

        List<Operation> mockListOperations = mock(ArrayList.class);

        Account account = new Account();
        account.setOperations(mockListOperations);

        assertEquals(mockListOperations, account.getOperations());
    }

    public void testGetAndSetName() {

        Account account = new Account();
        account.setName("Cuenta1");

        assertEquals("Cuenta1", account.getName());
    }

    public void testGetAccrued() {

        Account account = new Account();

        assertEquals(0.0, account.getAccrued());
    }

    public void testGetAndSetID() {

        Account account = new Account();
        Integer integer = new Integer(1);
        
        account.setId(integer);
        
        assertEquals(integer, account.getId());
    }
    // ***********************************************************************************************************
    // Test methods
    // ***********************************************************************************************************

    public void testIsBankAccount() {

        Account account = new Account();

        assertFalse(account.isBankAccount());
    }

    public void testIncreaseBalance() {

        Account account = new Account();

        assertEquals(0.0, account.getBalance());

        account.increaseBalance(100.0);

        assertEquals(100.0, account.getBalance());
    }

    public void testDecreaseBalance() {

        Account account = new Account();

        assertEquals(0.0, account.getBalance());

        account.increaseBalance(100.0);
        account.decreaseBalance(50.0);

        assertEquals(50.0, account.getBalance());
    }

    public void testRegistrateOperation() {

        Operation mockOperation = mock(Operation.class);

        Account account = new Account();

        assertEquals(0, account.getOperations().size());

        account.registrateOperation(mockOperation);

        assertEquals(1, account.getOperations().size());
    }

    public void testDeleteOperation() {

        Operation mockOperation = mock(Operation.class);
        when(mockOperation.getId()).thenReturn(new Integer(1));
        when(mockOperation.getOperationTypeEnum()).thenReturn(OperationTypeEnum.INCOME);
        
        Account account = new Account();

        assertEquals(0, account.getOperations().size());

        account.registrateOperation(mockOperation);

        assertEquals(1, account.getOperations().size());

        account.deleteOperation(mockOperation);

        assertEquals(0, account.getOperations().size());
    }
}
