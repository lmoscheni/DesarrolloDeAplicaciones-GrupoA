package ar.edu.unq.desapp.grupoa.persistence;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;

public class AccountDAO extends HibernateGenericDAO<Account> implements GenericDAO<Account>{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public Account findByName(String name) {
        Criteria criteria = this.getSession().createCriteria(Account.class);
        criteria.add(Restrictions.eq("name", name));
        return (Account) criteria.uniqueResult();
    }

    @Override
    public void saveOrUpdate(Account entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected Class<Account> getDomainClass() {
        return Account.class;
    }


}
