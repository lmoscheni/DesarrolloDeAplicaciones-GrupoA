package ar.edu.unq.desapp.grupoa.resources;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoa.model.Accounts.Account;
import ar.edu.unq.desapp.grupoa.model.System.Consolidation;
import ar.edu.unq.desapp.grupoa.services.AccountService;
import ar.edu.unq.desapp.grupoa.services.ConsolidationService;

@Service
public class ConsolidationWS {
    
    @Autowired
    private ConsolidationService consolidationService;
    private AccountService accountService;
    
    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Consolidation> getAllConsolidations() throws Exception, JsonGenerationException, JsonMappingException, IOException{
            List<Consolidation> consolidations = getConsolidationService().retriveAll();
            return consolidations;
    }

    @GET
    @Path("/consolidate")
    @Consumes("application/json")
    public Response consolidateAccounts(@Multipart(value = "voucher", type = "application/json") final String jsonVoucher) throws Exception{
        try{
            getConsolidationService().saveConsolidation(getAccountService());
        }catch(Exception e){
            return Response.status(501).build();
        }
            return Response.status(200).build();
    }
    
    public ConsolidationService getConsolidationService() {
        return consolidationService;
    }

    public void setConsolidationService(ConsolidationService consolidationService) {
        this.consolidationService = consolidationService;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
    
}
