package vooga.rts.controller;

/**
 * This class is a packet of information that can be sent to the appropriate
 * class which will carry out the action linked with the button press.
 * 
 * @author Challen Herzberg-Brovold
 * 
 */
public class Command {

    private String myInputType;

    /**
     * 
     * @param inputName the name of the input
     */
    public Command (String inputName) {
        myInputType = inputName;
    }

    /**
     * 
     * @return the name of the input
     */
    public String getMethodName () {
        return myInputType;
    }
}
