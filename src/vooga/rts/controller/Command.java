package vooga.rts.controller;

public class Command {
    
    private String myMethodCall;
    
    public Command (String inputName) {
        myMethodCall = inputName;
    }
    
    public String getMethodName () {
        return myMethodCall;
    }
}
