package ar.edu.unq.desapp.grupoa.SystemTests;

import ar.edu.unq.desapp.grupoa.model.System.Shift;
import junit.framework.TestCase;

public class ShiftTest extends TestCase{

    public void testCreateShiftNight(){
        
        Shift shift = Shift.create("Noche");
        assertEquals(shift, Shift.Noche);
    }
    
    public void testCreateShiftMorning(){
        
        Shift shift = Shift.create("Mañana");
        assertEquals(shift, Shift.Mañana);
    }

    public void testCreateShiftAfternon(){
    
        Shift shift = Shift.create("Tarde");
        assertEquals(shift, Shift.Tarde);
    }
}
