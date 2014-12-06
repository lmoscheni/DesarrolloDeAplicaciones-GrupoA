package ar.edu.unq.desapp.grupoa.services;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoa.model.System.Voucher;
import ar.edu.unq.desapp.grupoa.parser.Parser;

public class VoucherService extends GenericService<Voucher>{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Transactional
    public void saveVoucher(String json) throws Exception{
        Voucher v = this.parseNewVoucher(new Voucher(),json);
        save(v);
    }
    
    @Transactional
    public void deleteVoucher(Integer id){
        Voucher voucher = this.findById(id);
        this.delete(voucher);
    }
    
    @Transactional
    public void updateVoucher(Integer id, String json) throws Exception{
        Voucher v = this.findById(id);
        update(this.parseUpdateVoucher(v, json));
    }
    
    public Voucher parseNewVoucher(Voucher v,String json) throws Exception{
        return Parser.parseVoucher(v,json);
    }
    
    public Voucher parseUpdateVoucher(Voucher v,String json) throws Exception{
        return Parser.parseVoucher(v,json);
    }
}
