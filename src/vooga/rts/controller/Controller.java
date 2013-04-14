package vooga.rts.controller;

import vooga.rts.input.ActionObject;

/**
 * The controller will be responsible for reading the input, and applying it to 
 * all the sprites under its command
 * 
 * @author Challen Herzberg-Brovold
 *
 */
public interface Controller {
    
    /**
     * receiveInput gets the input from the Input class.
     * The controller is responsible for doing any necessary operations on it.
     * Originally, the Input called methods using the input, but having any
     * changes take place in the controller allows us to alter it and modify it
     * however we want without extra interaction with the Input. Furthermore, 
     * we can now modify the list of commands, and store them within the controller 
     * rather than within the Input.
     * Note: Input class was changed so that it sends the input when it is notified as
     * opposed to calling methods via reflection.
     * 
     * @param inputType
     * @param action
     */
    public void receiveInput (String inputType, ActionObject action);
    
    
}
