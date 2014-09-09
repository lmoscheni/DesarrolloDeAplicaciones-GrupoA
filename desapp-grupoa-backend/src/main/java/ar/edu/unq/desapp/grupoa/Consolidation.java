package ar.edu.unq.desapp.grupoa;

import java.util.Date;

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
