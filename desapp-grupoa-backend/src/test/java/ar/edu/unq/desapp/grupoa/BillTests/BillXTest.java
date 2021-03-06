package ar.edu.unq.desapp.grupoa.BillTests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import ar.edu.unq.desapp.grupoa.model.Bills.BillX;
import ar.edu.unq.desapp.grupoa.model.System.Voucher;
import junit.framework.TestCase;

public class BillXTest extends TestCase {

    public void testCalculateFinalAmount() {

        Voucher mockVoucher = mock(Voucher.class);
        when(mockVoucher.getAmount()).thenReturn(100.0);

        BillX billX = new BillX();

        assertEquals(100.0, billX.calculateFinalAmount(mockVoucher));
    }

}
