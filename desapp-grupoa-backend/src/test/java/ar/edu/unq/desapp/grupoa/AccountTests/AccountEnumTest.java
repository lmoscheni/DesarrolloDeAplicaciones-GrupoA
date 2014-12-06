package ar.edu.unq.desapp.grupoa.AccountTests;

import junit.framework.TestCase;
import ar.edu.unq.desapp.grupoa.model.Accounts.AccountEnum;

public class AccountEnumTest extends TestCase{

    public void testCreateBankAccount(){
        
        AccountEnum accountEnum1 = AccountEnum.create("Cuenta bancaria");
        AccountEnum accountEnum2 = AccountEnum.create("BankAccount");
        
        assertEquals(accountEnum1, AccountEnum.BankAccount);
        assertEquals(accountEnum2, AccountEnum.BankAccount);
    }
    
    public void testCreateCashAccount(){
        
        AccountEnum accountEnum1 = AccountEnum.create("Cuenta en efectivo");
        AccountEnum accountEnum2 = AccountEnum.create("CashAccount");
        
        assertEquals(accountEnum1, AccountEnum.CashAccount);
        assertEquals(accountEnum2, AccountEnum.CashAccount);
    }

    public void testCreateCurrentAccount(){
        
        AccountEnum accountEnum1 = AccountEnum.create("Cuenta corriente");
        AccountEnum accountEnum2 = AccountEnum.create("CurrentAccount");
        
        assertEquals(accountEnum1, AccountEnum.CurrentAccount);
        assertEquals(accountEnum2, AccountEnum.CurrentAccount);
    }
}
