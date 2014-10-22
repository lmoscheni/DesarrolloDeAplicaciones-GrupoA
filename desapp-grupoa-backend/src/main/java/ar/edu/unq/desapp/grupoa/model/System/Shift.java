package ar.edu.unq.desapp.grupoa.model.System;

public enum Shift {

    MORNING, EVENING, NIGHT;
    
    public static Shift create(String shift){
        Shift returnValue = null;
        if(shift.equals("EVENING") || shift.equals("evening") || shift.equals("Evening")){
            returnValue = EVENING;
        }
        if(shift.equals("MORNING") || shift.equals("morning") || shift.equals("Morning")){
            returnValue = MORNING;
        }
        if(shift.equals("NIGHT") || shift.equals("night") || shift.equals("Night")){
            returnValue = NIGHT;
        }
        return returnValue;
    }
}
