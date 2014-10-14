package ar.edu.unq.desapp.grupoa.resources;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private OperationService operationService;
    
    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Operation> getAllOperations() throws JsonGenerationException, JsonMappingException, IOException{
    //getOperationService().save(new Operation(10.0,new Category("Entrada"),Shift.MORNING, new Income()));
        
        List<Operation> operations = getOperationService().retriveAll();
        return operations;
    }
    
    
    @GET
    @Path("/deleteOperation/{id}")
    public List<Operation> deleteOperation(@PathParam("id") final String id) {
        Operation o = getOperationService().findById(new Integer(id));
        getOperationService().delete(o);
        
        return getOperationService().retriveAll();
    }
    
    public OperationService getOperationService() {
        return operationService;
    }
    
    public void setOperationService(OperationService operationService) {
        this.operationService = operationService;
    }
}
