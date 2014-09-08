package ar.edu.unq.desapp.grupoa;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.TestCase;

public class BillBTest extends TestCase{

    public void testCalculateFinalAmount(){
        
        Voucher mockVoucher = mock(Voucher.class);
        when(mockVoucher.getAmount()).thenReturn(100);
        
        BillB billB = new BillB();
        
        assertEquals(100, billB.calculateFinalAmount(mockVoucher));
    }

}
