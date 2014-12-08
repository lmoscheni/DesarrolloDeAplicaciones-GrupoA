package ar.edu.unq.desapp.grupoa.persistence;

import ar.edu.unq.desapp.grupoa.model.System.Consolidation;

public class ConsolidationDAO extends HibernateGenericDAO<Consolidation> implements GenericDAO<Consolidation>{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Consolidation findByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    public void saveOrUpdate(Consolidation entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected Class<Consolidation> getDomainClass() {
        return Consolidation.class;
    }

}
