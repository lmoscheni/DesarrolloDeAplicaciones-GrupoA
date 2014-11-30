package ar.edu.unq.desapp.grupoa.resources;

import java.io.IOException;
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

import ar.edu.unq.desapp.grupoa.model.System.Voucher;
import ar.edu.unq.desapp.grupoa.services.CategoryService;
import ar.edu.unq.desapp.grupoa.services.VoucherService;

@Service
public class VoucherWS {

    @Autowired
    private VoucherService voucherService;
    private CategoryService categoryService;
    
    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Voucher> getAllVouchers() throws JsonGenerationException, JsonMappingException, IOException{
            List<Voucher> vouchers = getVoucherService().retriveAll();
            return vouchers;
    }
    
    @POST
    @Path("/save/")
    @Consumes("application/json")
    public Response createVoucher(@Multipart(value = "voucher", type = "application/json") final String jsonVoucher) throws Exception{
        try{
            getVoucherService().saveVoucher(jsonVoucher, getCategoryService());
        }catch(Exception e){
            return Response.status(501).build();
        }
            return Response.status(200).build();
    }

    public VoucherService getVoucherService() {
        return voucherService;
    }

    public void setVoucherService(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
}
