package ar.edu.unq.desapp.grupoa;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.TestCase;

public class BillDTest extends TestCase{

    public void testCalculateFinalAmount(){
        
        Voucher mockVoucher = mock(Voucher.class);
        when(mockVoucher.getAmount()).thenReturn(100);
        
        BillD billD = new BillD();
        
        assertEquals(100, billD.calculateFinalAmount(mockVoucher));
    }

}
