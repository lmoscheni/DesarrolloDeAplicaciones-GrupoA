package ar.edu.unq.desapp.grupoa.persistence;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;

public class AccountDAO extends HibernateGenericDAO<Account> implements GenericDAO<Account>{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public Account findByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveOrUpdate(Account entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected Class<Account> getDomainClass() {
        // TODO Auto-generated method stub
        return null;
    }


}
