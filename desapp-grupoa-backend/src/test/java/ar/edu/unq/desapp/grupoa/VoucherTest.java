package ar.edu.unq.desapp.grupoa;

import ar.edu.unq.desapp.grupoa.builders.VoucherBuilder;
import junit.framework.TestCase;

/**
 * Test
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class VoucherTest extends TestCase {

    public void testGetFinalAmount() {

        Voucher voucher = VoucherBuilder.aVoucher().withAmount(100).build();

        assertEquals(100, voucher.getFinalAmount());
    }
}
