package ar.edu.unq.desapp.grupoa;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.TestCase;

/**
 * Test bill type
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class BillTypeTest extends TestCase {

    public void testCalculateFinalAmount() {

        Voucher mockVoucher = mock(Voucher.class);
        when(mockVoucher.getAmount()).thenReturn(100.0);

        BillType billType = new BillType();

        assertEquals(100.0, billType.calculateFinalAmount(mockVoucher));
    }

}
