package ar.edu.unq.desapp.grupoa.services;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.model.System.Consolidation;

public class ConsolidationService extends GenericService<Consolidation>{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Transactional
    public void saveConsolidation(AccountService AS){
        
        List<Account> accounts = AS.retriveAll();
        double available = 0.0;
        double accrued = 0.0;
        for(Account a : accounts){
            a.updateTheAccountStatus();
            AS.update(a);
            available += a.getBalance();
            accrued += a.getAccrued();
        }
        this.save(new Consolidation(available,accrued,new Date()));
    }
}
