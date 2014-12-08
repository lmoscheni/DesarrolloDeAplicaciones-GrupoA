package ar.edu.unq.desapp.grupoa.persistence;

import java.util.ArrayList;
import java.util.List;

public class DAO extends HibernateGenericDAO<Object> implements GenericDAO<Object>{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected Class<Object> getDomainClass() {
        return Object.class;
    }
    
    public List<Object> findAll(Class<? extends Object> class1) {
        List<Object> all = this.findAll();
        List<Object> results = new ArrayList<Object>();
        for( Object o : all){
            if( o.getClass().equals(class1)){
                results.add(o);
            }
        }
        return results;
    }

    public Object findByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    public void saveOrUpdate(Object entity) {
        // TODO Auto-generated method stub
        
    }
}