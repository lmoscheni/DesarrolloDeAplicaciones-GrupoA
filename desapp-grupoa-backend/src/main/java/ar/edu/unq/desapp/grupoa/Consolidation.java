package ar.edu.unq.desapp.grupoa;

import java.util.Date;

/**
 * Class consolidation
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class Consolidation {
    
    protected double available;

    protected double accrued;

    protected Date consolidationDate;

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

}
