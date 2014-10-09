package ar.edu.unq.desapp.grupoa.persistence;

import ar.edu.unq.desapp.grupoa.model.Operation.Operation;

public class OperationDAO extends HibernateGenericDAO<Operation> implements GenericDAO<Operation> {

    private static final long serialVersionUID = -3498745205693574615L;

    @Override
    protected Class<Operation> getDomainClass() {
        return Operation.class;
    }
}
