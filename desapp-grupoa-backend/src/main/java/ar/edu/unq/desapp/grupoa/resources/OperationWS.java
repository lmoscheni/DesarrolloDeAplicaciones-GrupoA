package ar.edu.unq.desapp.grupoa.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.model.Operation.OperationTypeEnum;
import ar.edu.unq.desapp.grupoa.parser.Parser;
import ar.edu.unq.desapp.grupoa.services.AccountService;
import ar.edu.unq.desapp.grupoa.services.CategoryService;
import ar.edu.unq.desapp.grupoa.services.OperationService;

@Service
public class OperationWS {

    @Autowired
    private OperationService operationService;
    private CategoryService categoryService;
    private AccountService accountService;
    
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
        getOperationService().deleteOperation(new Integer(id), getOperationService(), getAccountService());
        return getOperationService().retriveAll();
    }
    
    @POST
    @Path("/save/")
    @Consumes("application/json")
    public Response createOperation(@Multipart(value = "operation", type = "application/json") final String jsonOperation) throws Exception{
        
            getOperationService().saveOperation(jsonOperation, getCategoryService(), getAccountService());
            return Response.status(200).build();
    }
    
    @GET
    @Path("/modify/{id}/{operation}")
    @Produces("application/json")
    public Response saveCategory(@PathParam("id") final int id,
    @PathParam("operation") final String operation) throws Exception {
            
        Operation o = getOperationService().findById(id);
        Account a = getAccountService().getAccount(o.getAccount().toString());
        System.out.println(a.getName());
        a.deleteOperation(o);
        getAccountService().update(a);
        
        getOperationService().updateOperation(o, operation, getCategoryService());

        a = getAccountService().getAccount(o.getAccount().toString());
        a.registrateOperation(o);
        getAccountService().update(a);
        
        return Response.ok().build();
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

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
    
    
}
