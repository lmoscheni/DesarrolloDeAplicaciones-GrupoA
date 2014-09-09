package ar.edu.unq.desapp.grupoa;

import junit.framework.TestCase;

public class BankAccountTest extends TestCase{

    public void testIncreaseBalance(){
        
        BankAccount bankAccount = new BankAccount();
        bankAccount.increaseBalance(100.0);
        
        assertEquals(100.0, bankAccount.getAccrued());
    }
    
    public void testDecreaseBalance(){
        
        BankAccount bankAccount = new BankAccount();
        bankAccount.increaseBalance(100.0);
        
        assertEquals(100.0, bankAccount.getAccrued());
        
        bankAccount.decreaseBalance(50.0);
        
        assertEquals(50.0, bankAccount.getAccrued());
    }
}
