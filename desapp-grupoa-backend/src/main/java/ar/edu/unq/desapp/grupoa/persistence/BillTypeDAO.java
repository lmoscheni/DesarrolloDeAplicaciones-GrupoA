package ar.edu.unq.desapp.grupoa.persistence;

import ar.edu.unq.desapp.grupoa.model.Bills.BillType;

public class BillTypeDAO extends HibernateGenericDAO<BillType> implements GenericDAO<BillType>{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public BillType findByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    public void saveOrUpdate(BillType entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected Class<BillType> getDomainClass() {
        return BillType.class;
    }

}
