package ar.edu.unq.desapp.grupoa.resources;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoa.services.AccountService;

@Service
public class AccountWS {

    @Autowired
    private AccountService accountService;

    @GET
    @Path("/init")
    @Produces("application/json")
    public Response initAccounts() throws JsonGenerationException, JsonMappingException, IOException{
            getAccountService().saveAccounts();
            return Response.status(200).build();
    }
    
    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
    
    
}
