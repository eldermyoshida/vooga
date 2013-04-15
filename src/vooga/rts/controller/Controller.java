package vooga.rts.controller;


/**
 * The controller will be responsible for reading the input, and applying it to 
 * its manager, which then changes its state accordingly. 
 * 
 * @author Challen Herzberg-Brovold
 *
 */
public interface Controller {
    
    public void sendCommand(Command command);
    
}
