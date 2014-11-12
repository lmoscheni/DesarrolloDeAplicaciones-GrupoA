package ar.edu.unq.desapp.grupoa.services;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.parser.Parser;

public class OperationService extends GenericService<Operation>{

    /**
     * 
     */
    private static final long serialVersionUID = -4047486437268145200L;

    @Transactional
    public void saveOperation(String json, CategoryService categoryService, OperationTypeService operationTypeService) throws Exception{
        save(this.parseNewOperation(json,categoryService, operationTypeService));
    }
    
    private Operation parseNewOperation(final String jsonOperation,CategoryService categoryService, OperationTypeService operationTypeService) throws Exception {
        return Parser.parseOperation(new Operation(),jsonOperation, categoryService, operationTypeService);
    }
}
