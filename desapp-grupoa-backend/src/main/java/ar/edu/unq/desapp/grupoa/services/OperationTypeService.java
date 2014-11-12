package ar.edu.unq.desapp.grupoa.services;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoa.model.Operation.OperationType;

public class OperationTypeService extends GenericService<OperationType>{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Transactional
    public OperationType findByName(final String name){
        return this.getDao().findByName(name);
    }
}
