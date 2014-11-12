package ar.edu.unq.desapp.grupoa.persistence;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ar.edu.unq.desapp.grupoa.model.Operation.OperationType;

public class OperationTypeDAO extends HibernateGenericDAO<OperationType> implements GenericDAO<OperationType> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public OperationType findByName(String name) {
        Criteria criteria = this.getSession().createCriteria(OperationType.class);
        criteria.add(Restrictions.eq("clase", name));
        return (OperationType) criteria.uniqueResult();
    }

    @Override
    public void saveOrUpdate(OperationType entity) {
        
    }

    @Override
    protected Class<OperationType> getDomainClass() {
        return null;
    }

}
