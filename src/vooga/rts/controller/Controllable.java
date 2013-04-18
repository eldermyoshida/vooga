package vooga.rts.controller;

/**
 * The Controllable interface is designed for classes that need to take in a 
 * command from a Controller.
 * @author Challen Herzberg-Brovold
 *
 */
public interface Controllable {
    
    /**
     * Receives the desired command
     * 
     * @param command
     */
    public abstract void receiveCommand (Command command);
}
