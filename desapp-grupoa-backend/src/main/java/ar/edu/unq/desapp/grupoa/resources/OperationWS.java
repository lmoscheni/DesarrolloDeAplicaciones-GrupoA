package ar.edu.unq.desapp.grupoa.resources;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.Operation.Egress;
import ar.edu.unq.desapp.grupoa.model.Operation.Income;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.model.System.Shift;
import ar.edu.unq.desapp.grupoa.services.CategoryService;
import ar.edu.unq.desapp.grupoa.services.OperationService;

@Service
public class OperationWS {

    private OperationService operationService;
    
    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Operation> getAllOperations() throws JsonGenerationException, JsonMappingException, IOException{
        
        Operation o = new Operation(10.0,new Category("Alfajor"),Shift.EVENING,new Egress());
        this.getOperationService().save(o);
        
        List<Operation> operations = getOperationService().retriveAll();
        return operations;
    }
    
    public OperationService getOperationService() {
        return operationService;
    }
    
    public void setOperationService(OperationService operationService) {
        this.operationService = operationService;
    }
}
