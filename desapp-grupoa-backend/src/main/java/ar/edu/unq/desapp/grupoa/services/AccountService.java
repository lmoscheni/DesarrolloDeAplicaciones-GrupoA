package ar.edu.unq.desapp.grupoa.services;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.model.Accounts.BankAccount;
import ar.edu.unq.desapp.grupoa.model.Accounts.Cash;
import ar.edu.unq.desapp.grupoa.model.Accounts.CurrentAccount;

public class AccountService  extends GenericService<Account>{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Transactional
    public void saveAccounts(){
        BankAccount BA = new BankAccount();
        CurrentAccount CUA = new CurrentAccount();
        Cash CA = new Cash();
        save(BA);
        save(CUA);
        save(CA);
    }
}
