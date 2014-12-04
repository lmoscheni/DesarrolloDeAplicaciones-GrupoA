package ar.edu.unq.desapp.grupoa.persistence;

import ar.edu.unq.desapp.grupoa.model.System.Voucher;

public class VoucherDAO extends HibernateGenericDAO<Voucher> implements GenericDAO<Voucher> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public Voucher findByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveOrUpdate(Voucher entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected Class<Voucher> getDomainClass() {
        return Voucher.class;
    }

}
