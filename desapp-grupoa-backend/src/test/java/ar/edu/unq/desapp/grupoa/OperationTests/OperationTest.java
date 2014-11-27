package ar.edu.unq.desapp.grupoa.OperationTests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import junit.framework.TestCase;
import ar.edu.unq.desapp.grupoa.helpers.builders.OperationBuilder;
import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.model.Accounts.AccountEnum;
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
    
    public void testInvalidAmount(){
        
        Operation operation = new Operation();
        try{
            operation.setAmount(-100);
            assertTrue(false);
        }catch(Exception e){
            assertEquals(e.getMessage(), "Monto invalido");
            assertTrue(true);
        }
    }
    
    public void testGetAndSetConcept(){
        
        Operation operation  =new Operation();
        String concept = "Hola";
        operation.setConcept(concept);
        
        assertEquals(concept, operation.getConcept());
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

    public void testGetAndSetOperationTypeEnum() {

        OperationTypeEnum operationType = OperationTypeEnum.EGRESS;

        Operation operation = new Operation();
        operation.setOperationTypeEnum(operationType);

        assertEquals(operationType, operation.getOperationTypeEnum());
    }

    public void testGetAndSetDateOperation() {

        Date mockDate = mock(Date.class);

        Operation operation = new Operation();
        operation.setDateOperation(mockDate);

        assertEquals(mockDate, operation.getDateOperation());
    }

    public void testGetAndSetAccount(){
        
        AccountEnum mockAccount = AccountEnum.CashAccount;
        Operation operation = new Operation();
        
        operation.setAccount(mockAccount);
        
        assertEquals(mockAccount, operation.getAccount());
    }
    
    // ***********************************************************************************************************
    // Test methods
    // ***********************************************************************************************************

    public void testApplyOperation() throws Exception {

        OperationTypeEnum operationType = OperationTypeEnum.INCOME;
        Account mockAccount = mock(Account.class);

        Operation operation = mock(Operation.class);//OperationBuilder.aOperation().withOperationType(operationType).build();
        
        operation.applyOperation(mockAccount);

//        verify(operation, times(1)).getOperationType();
    }
}

