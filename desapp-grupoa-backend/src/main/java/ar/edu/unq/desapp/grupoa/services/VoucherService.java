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
        Voucher v = this.parseNewVoucher(json);
        save(v);
    }
    
    public Voucher parseNewVoucher(String json) throws Exception{
        return Parser.parseVoucher(new Voucher(),json);
    }
}
