package ar.edu.unq.desapp.grupoa.model.System;

public enum Shift {

    MAÑANA, TARDE, NOCHE;
    
    public static Shift create(String shift){
        Shift returnValue = null;
        if(shift.equals("TARDE") || shift.equals("tarde") || shift.equals("Tarde")){
            returnValue = TARDE;
        }
        if(shift.equals("MAÑANA") || shift.equals("mañana") || shift.equals("Mañana")){
            returnValue = MAÑANA;
        }
        if(shift.equals("NOCHE") || shift.equals("noche") || shift.equals("Noche")){
            returnValue = NOCHE;
        }
        return returnValue;
    }
}
