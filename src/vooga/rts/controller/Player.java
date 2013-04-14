package vooga.rts.controller;

import vooga.rts.manager.Manager;
import vooga.rts.input.ActionObject;

/**
 * At the moment, the player class is implementing the humanplayer. For network
 * player and ai player, some methods will be refactored into a super class
 * 
 * @author Challen Herzberg-Brovold
 *
 */
public class Player implements Controller {
    
    private Manager myManager;
    
    public Player (Manager manager) {
        myManager = manager;
    }
    
    public void sendCommand () { // this will send the command to the unit manager. Exactly what this is going to be is still being determined
        return;
    }
    
    public void receiveInput (String action, ActionObject o) {
        
    }
}
