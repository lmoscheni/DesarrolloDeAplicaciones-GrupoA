package ar.edu.unq.desapp.grupoa.ServiceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.model.Accounts.AccountEnum;
import ar.edu.unq.desapp.grupoa.model.Accounts.Cash;
import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.services.AccountService;
import ar.edu.unq.desapp.grupoa.services.CategoryService;
import ar.edu.unq.desapp.grupoa.services.OperationService;

@ContextConfiguration(locations = {"classpath:META-INF/spring-services-context.xml","classpath:META-INF/spring-persistence-context.xml","classpath:META-INF/spring-web.xml"})
public class OperationTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    OperationService operationService;
    CategoryService categoryService;
    AccountService accountService;
    
    @Test
    public void testGuardarOperation() throws Exception{
        
        AccountService AS = mock(AccountService.class);
        Account a = mock(Cash.class);
        when(AS.getAccount("CashAccount")).thenReturn(a);
        CategoryService CS = mock(CategoryService.class);
        when(CS.findByName("Ventas")).thenReturn(new Category("Ventas"));
        
        String json = "{'amount':"+"200.0,"+ "'shift':"+"Tarde,"+ "'category':"+"Ventas,"+ "'operationType':"+"false,"+ "'subcategory':"+"beta,"+ "'concept':"+ "nada,"+ "'account':"+"CashAccount"+ "}";
        getOperationService().saveOperation(json, CS, AS);
        Operation operation = getOperationService().retriveAll().get(getOperationService().retriveAll().size()-1);
        
        assertTrue(operation.getId() != null);

        assertTrue(operation.getAmount() == 200.0);
        assertTrue(operation.getCategory().getName().equals("Ventas"));
        assertTrue(operation.getConcept().equals("nada"));
        assertTrue(operation.getAccount().equals(AccountEnum.CashAccount));
        assertTrue(operation.getSubcategory().equals("beta"));
    }

    @Test
    public void testDeleteOperation() throws Exception{
        AccountService AS = mock(AccountService.class);
        Account a = mock(Cash.class);
        when(AS.getAccount("CashAccount")).thenReturn(a);
        CategoryService CS = mock(CategoryService.class);
        when(CS.findByName("Ventas")).thenReturn(new Category("Ventas"));
        
        String json = "{'amount':"+"200.0,"+ "'shift':"+"Tarde,"+ "'category':"+"Ventas,"+ "'operationType':"+"false,"+ "'subcategory':"+"beta,"+ "'concept':"+ "nada,"+ "'account':"+"CashAccount"+ "}";
        int numberOfOperations = getOperationService().retriveAll().size();
        getOperationService().saveOperation(json, CS, AS);
        Operation operation = getOperationService().retriveAll().get(getOperationService().retriveAll().size()-1);
        
        assertEquals(numberOfOperations + 1, getOperationService().retriveAll().size());
        
        getOperationService().deleteOperation(operation.getId(), getOperationService(), AS);
    }
    
    @Test
    public void testUpdateOperation() throws Exception{
        AccountService AS = mock(AccountService.class);
        Account a = mock(Cash.class);
        when(AS.getAccount("CashAccount")).thenReturn(a);
        CategoryService CS = mock(CategoryService.class);
        when(CS.findByName("Ventas")).thenReturn(new Category("Ventas"));
        
        String json = "{'amount':"+"200.0,"+ "'shift':"+"Tarde,"+ "'category':"+"Ventas,"+ "'operationType':"+"false,"+ "'subcategory':"+"beta,"+ "'concept':"+ "nada,"+ "'account':"+"CashAccount"+ "}";
        getOperationService().saveOperation(json, CS, AS);
        
        Operation operation = getOperationService().retriveAll().get(getOperationService().retriveAll().size()-1);
        
        assertTrue(operation.getAmount() == 200.0);
        
        json = "{'amount':"+"210.0,"+ "'shift':"+"Tarde,"+ "'category':"+"Ventas,"+ "'operationType':"+"false,"+ "'subcategory':"+"beta,"+ "'concept':"+ "nada,"+ "'account':"+"CashAccount"+ "}";
        
        getOperationService().updateOperation(operation, json, CS);
        
        assertTrue(operation.getAmount() == 210.0);
    }
    
    public OperationService getOperationService() {
        return operationService;
    }
}
