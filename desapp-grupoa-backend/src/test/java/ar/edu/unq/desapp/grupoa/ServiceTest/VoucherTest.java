package ar.edu.unq.desapp.grupoa.ServiceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.System.Voucher;
import ar.edu.unq.desapp.grupoa.services.VoucherService;

@ContextConfiguration(locations = {"classpath:META-INF/spring-services-context.xml","classpath:META-INF/spring-persistence-context.xml","classpath:META-INF/spring-web.xml"})
public class VoucherTest extends AbstractTransactionalJUnit4SpringContextTests{
    
    @Autowired
    VoucherService voucherService;
    
    @Test
    public void testGuardarVoucherBillB() throws Exception{
        
        String json = "{'date': 06-12-2014, 'socialReason':" + "nada,"+"'cuit':"+"nada,"+"'concept':"+"nada,"+"'amount':"+"200,"+"'billType' :"+ "Tipo B,"+ "'taxed':'', 'noTaxed':'', 'IIBB':'', 'IVA':''}";
        getVoucherService().saveVoucher(json);
        Voucher voucher = getVoucherService().retriveAll().get(getVoucherService().retriveAll().size()-1);
        
        assertTrue(voucher.getId() != null);

        assertTrue(voucher.getSocialReason().equals("nada"));
        assertTrue(voucher.getCuit().equals("nada"));
        assertTrue(voucher.getConcept().equals("nada"));
        assertTrue(voucher.getBillType().getName().equals("BillB"));
        assertTrue(voucher.getAmount() == 200);
    }
    
    @Test
    public void testGuardarVoucherBillC() throws Exception{
        
        String json = "{'date': 06-12-2014, 'socialReason':" + "nada,"+"'cuit':"+"nada,"+"'concept':"+"nada,"+"'amount':"+"200,"+"'billType' :"+ "Tipo C,"+ "'taxed':'', 'noTaxed':'', 'IIBB':'', 'IVA':''}";
        getVoucherService().saveVoucher(json);
        Voucher voucher = getVoucherService().retriveAll().get(getVoucherService().retriveAll().size()-1);
        
        assertTrue(voucher.getId() != null);

        assertTrue(voucher.getSocialReason().equals("nada"));
        assertTrue(voucher.getCuit().equals("nada"));
        assertTrue(voucher.getConcept().equals("nada"));
        assertTrue(voucher.getBillType().getName().equals("BillC"));
        assertTrue(voucher.getAmount() == 200);
    }
    
    @Test
    public void testGuardarVoucherBillD() throws Exception{
        
        String json = "{'date': 06-12-2014, 'socialReason':" + "nada,"+"'cuit':"+"nada,"+"'concept':"+"nada,"+"'amount':"+"200,"+"'billType' :"+ "Tipo D,"+ "'taxed':'', 'noTaxed':'', 'IIBB':'', 'IVA':''}";
        getVoucherService().saveVoucher(json);
        Voucher voucher = getVoucherService().retriveAll().get(getVoucherService().retriveAll().size()-1);
        
        assertTrue(voucher.getId() != null);

        assertTrue(voucher.getSocialReason().equals("nada"));
        assertTrue(voucher.getCuit().equals("nada"));
        assertTrue(voucher.getConcept().equals("nada"));
        assertTrue(voucher.getBillType().getName().equals("BillD"));
        assertTrue(voucher.getAmount() == 200);
    }
    
    @Test
    public void testGuardarVoucherBillX() throws Exception{
        
        String json = "{'date': 06-12-2014, 'socialReason':" + "nada,"+"'cuit':"+"nada,"+"'concept':"+"nada,"+"'amount':"+"200,"+"'billType' :"+ "Tipo X,"+ "'taxed':'', 'noTaxed':'', 'IIBB':'', 'IVA':''}";
        getVoucherService().saveVoucher(json);
        Voucher voucher = getVoucherService().retriveAll().get(getVoucherService().retriveAll().size()-1);
        
        assertTrue(voucher.getId() != null);

        assertTrue(voucher.getSocialReason().equals("nada"));
        assertTrue(voucher.getCuit().equals("nada"));
        assertTrue(voucher.getConcept().equals("nada"));
        assertTrue(voucher.getBillType().getName().equals("BillX"));
        assertTrue(voucher.getAmount() == 200);
    }

    public VoucherService getVoucherService() {
        return voucherService;
    }
}
