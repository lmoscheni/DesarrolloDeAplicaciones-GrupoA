package ar.edu.unq.desapp.grupoa.model.System;

public enum Shift {

    Mañana, Tarde, Noche;
    
    public static Shift create(String shift){
        Shift returnValue = null;
        if(shift.equals("TARDE") || shift.equals("tarde") || shift.equals("Tarde")){
            returnValue = Tarde;
        }
        if(shift.equals("MAÑANA") || shift.equals("mañana") || shift.equals("Mañana")){
            returnValue = Mañana;
        }
        if(shift.equals("NOCHE") || shift.equals("noche") || shift.equals("Noche")){
            returnValue = Noche;
        }
        return returnValue;
    }
}
