package ar.edu.unq.desapp.grupoa.Bills;

import ar.edu.unq.desapp.grupoa.System.Voucher;

/**
 * Class bill type
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class BillType {

    public double calculateFinalAmount(Voucher voucher) {
        return voucher.getAmount();
    }

}
