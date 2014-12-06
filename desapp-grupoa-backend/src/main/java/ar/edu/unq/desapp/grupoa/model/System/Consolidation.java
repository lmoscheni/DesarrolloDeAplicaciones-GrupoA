package ar.edu.unq.desapp.grupoa.model.System;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

/**
 * Class consolidation
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

@Entity
public class Consolidation implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Integer id;
    
    protected double available;

    protected double accrued;

    protected Date consolidationDate;

    public Consolidation(){}
    
    public Consolidation(double available, double accrued, Date consolidationDate) {
        this.available = available;
        this.accrued = accrued;
        this.consolidationDate = consolidationDate;
    }

    public double getAvailable() {
        return available;
    }

    public double getAccrued() {
        return accrued;
    }

    public Date getConsolidationDate() {
        return consolidationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
}
