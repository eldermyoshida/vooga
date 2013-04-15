package vooga.rts.controller;

public abstract class Command {
    
    private String myMethodCall;
    
    public Command (String inputName) {
        myMethodCall = inputName;
    }
    
    public String getMethodName () {
        return myMethodCall;
    }
}
