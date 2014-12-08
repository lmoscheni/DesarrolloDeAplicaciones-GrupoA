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
import ar.edu.unq.desapp.grupoa.model.System.Voucher;
import ar.edu.unq.desapp.grupoa.services.CategoryService;
import ar.edu.unq.desapp.grupoa.services.VoucherService;

@Service
public class VoucherWS {

    @Autowired
    private VoucherService voucherService;
    
    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Voucher> getAllVouchers() throws Exception, JsonGenerationException, JsonMappingException, IOException{
            List<Voucher> vouchers = getVoucherService().retriveAll();
            return vouchers;
    }
    
    @POST
    @Path("/save/")
    @Consumes("application/json")
    public Response createVoucher(@Multipart(value = "voucher", type = "application/json") final String jsonVoucher){
        try{    
            getVoucherService().saveVoucher(jsonVoucher);
        }catch(Exception e){
            return Response.status(501).build();
        }
        return Response.status(200).build();
    }

    @GET
    @Path("/delete/{id}")
    public List<Voucher> deleteVoucher(@PathParam("id") final String id) {
        getVoucherService().deleteVoucher(new Integer(id));
        return getVoucherService().retriveAll();
    }
    
    @GET
    @Path("/modify/{id}/{voucher}")
    @Produces("application/json")
    public Response modifyOperation(@PathParam("id") final int id,
    @PathParam("voucher") final String voucher) throws Exception {
        
        getVoucherService().updateVoucher(id, voucher);
        return Response.ok().build();
    }
    
    public VoucherService getVoucherService() {
        return voucherService;
    }

    public void setVoucherService(VoucherService voucherService) {
        this.voucherService = voucherService;
    }
    
}
