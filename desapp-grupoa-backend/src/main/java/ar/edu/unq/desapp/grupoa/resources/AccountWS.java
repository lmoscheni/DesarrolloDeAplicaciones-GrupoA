package ar.edu.unq.desapp.grupoa.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.services.AccountService;
import ar.edu.unq.desapp.grupoa.services.OperationService;

@Service
public class AccountWS {

    @Autowired
    private AccountService accountService;
    private OperationService operationService;

    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Account> getAllAccounts(){
        Account a1 = getAccountService().getAccount("CashAccount");
        Account a2 = getAccountService().getAccount("CurrentAccount");
        Account a3 = getAccountService().getAccount("BankAccount");
        List<Account> accs = new ArrayList<Account>();
        accs.add(a1);
        accs.add(a2);
        accs.add(a3);
        return accs;
    }
    
    @GET
    @Path("/init")
    @Produces("application/json")
    public Response initAccounts() throws JsonGenerationException, JsonMappingException, IOException{
            getAccountService().saveAccounts();
            return Response.status(200).build();
    }
    
    @GET
    @Path("/getAccount/{name}")
    @Produces("application/json")
    public Account getAccount(@PathParam("name") final String name) throws JsonGenerationException, JsonMappingException, IOException{
            return getAccountService().getAccount(name);
    }
   
    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public OperationService getOperationService() {
        return operationService;
    }

    public void setOperationService(OperationService operationService) {
        this.operationService = operationService;
    }
    
    
}
