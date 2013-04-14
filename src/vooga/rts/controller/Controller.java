package vooga.rts.controller;

import java.util.Observable;
import java.util.Observer;

/**
 * The controller will be responsible for reading the input, and applying it to 
 * all the sprites under its command
 * 
 * @author Challen Herzberg-Brovold
 *
 */
public interface Controller {
    
    public void sendCommand ();
}
