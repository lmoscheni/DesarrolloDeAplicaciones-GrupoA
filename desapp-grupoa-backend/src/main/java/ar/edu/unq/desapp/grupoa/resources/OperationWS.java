package ar.edu.unq.desapp.grupoa.resources;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.parser.Parser;
import ar.edu.unq.desapp.grupoa.services.CategoryService;
import ar.edu.unq.desapp.grupoa.services.OperationService;

@Service
public class OperationWS {

    @Autowired
    private OperationService operationService;
    private CategoryService categoryService;
    
    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Operation> getAllOperations() throws JsonGenerationException, JsonMappingException, IOException{
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
    
    @POST
    @Path("/save/")
    @Consumes("application/json")
    public Response createOperation(@Multipart(value = "operation", type = "application/json") final String jsonOperation) {
        try {
            getOperationService().save(parseNewOperation(jsonOperation));
        } catch (Exception e) {
            System.out.println(e);
            return Response.serverError().build();
        }
        return Response.status(200).build();
    }
    
    @GET
    @Path("/modify/{id}/{operation}")
    @Produces("application/json")
    public Response saveCategory(@PathParam("id") final int id,
    @PathParam("operation") final String operation) {
        try {
            Operation o = getOperationService().findById(id);
            getOperationService().update(parseUpdateOperation(o,operation));
        } catch (Exception e) {
            System.out.println(e);
            return Response.serverError().build();
        }
        return Response.ok().build();
    }
    
    private Operation parseNewOperation(final String jsonOperation) throws Exception {
        return Parser.parseOperation(new Operation(),jsonOperation, getCategoryService());
    }
    
    private Operation parseUpdateOperation(Operation o,final String jsonOperation) throws Exception {
        return Parser.parseOperation(o,jsonOperation, getCategoryService());
    }
    
    public OperationService getOperationService() {
        return operationService;
    }
    
    public void setOperationService(OperationService operationService) {
        this.operationService = operationService;
    }
    
    public CategoryService getCategoryService() {
        return categoryService;
    }
    
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
