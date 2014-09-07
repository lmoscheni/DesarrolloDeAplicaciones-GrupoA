package ar.edu.unq.desapp.grupoa;

import java.util.Date;

import ar.edu.unq.desapp.grupoa.builders.VoucherBuilder;
import ar.edu.unq.desapp.grupoa.mocks.Operation;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

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
