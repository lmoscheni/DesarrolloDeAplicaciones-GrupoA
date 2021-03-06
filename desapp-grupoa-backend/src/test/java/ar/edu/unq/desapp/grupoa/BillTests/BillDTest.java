package ar.edu.unq.desapp.grupoa.BillTests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import ar.edu.unq.desapp.grupoa.model.Bills.BillD;
import ar.edu.unq.desapp.grupoa.model.System.Voucher;
import junit.framework.TestCase;

public class BillDTest extends TestCase {

    public void testCalculateFinalAmount() {

        Voucher mockVoucher = mock(Voucher.class);
        when(mockVoucher.getAmount()).thenReturn(100.0);

        BillD billD = new BillD();

        assertEquals(100.0, billD.calculateFinalAmount(mockVoucher));
    }

}
