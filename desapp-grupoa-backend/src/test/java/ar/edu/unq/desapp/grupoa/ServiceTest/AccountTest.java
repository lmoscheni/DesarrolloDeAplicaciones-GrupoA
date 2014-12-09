package ar.edu.unq.desapp.grupoa.ServiceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.services.AccountService;

@ContextConfiguration(locations = {"classpath:META-INF/spring-services-context.xml","classpath:META-INF/spring-persistence-context.xml","classpath:META-INF/spring-web.xml"})
public class AccountTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    AccountService accountService;
    
    @Test
    public void testSaveAccounts(){
        int numbersOfAccounts = getAccountService().retriveAll().size();
        getAccountService().saveAccounts();
        
        assertEquals(numbersOfAccounts +3, getAccountService().retriveAll().size());
    }
    
    @Test
    public void testGetAccount(){
        
        Account account = getAccountService().getAccount("CashAccount");
        
        assertEquals("CashAccount",account.getName());
    }


    public AccountService getAccountService() {
        return accountService;
    }
}
