package ar.edu.unq.desapp.grupoa.BillTests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import ar.edu.unq.desapp.grupoa.model.Bills.BillB;
import ar.edu.unq.desapp.grupoa.model.System.Voucher;
import junit.framework.TestCase;

public class BillBTest extends TestCase {

    public void testCalculateFinalAmount() {

        Voucher mockVoucher = mock(Voucher.class);
        when(mockVoucher.getAmount()).thenReturn(100.0);

        BillB billB = new BillB();

        assertEquals(100.0, billB.calculateFinalAmount(mockVoucher));
    }

}
