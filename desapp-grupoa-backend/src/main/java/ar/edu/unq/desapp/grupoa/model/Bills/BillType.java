package ar.edu.unq.desapp.grupoa.model.Bills;

import java.io.Serializable;

import javax.persistence.Entity;

import ar.edu.unq.desapp.grupoa.model.System.Voucher;

/**
 * Class bill type
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

@Entity
public class BillType implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public double calculateFinalAmount(Voucher voucher) {
        return voucher.getAmount();
    }

}
