package vooga.rts.controller;

import java.util.Observable;
import java.util.Observer;
import vooga.rts.manager.Manager;

/**
 * At the moment, the player class is implementing the humanplayer. For network
 * player and ai player, some methods will be refactored into a super class
 * 
 * @author Challen Herzberg-Brovold
 *
 */
public class Player implements Controller, Observer {
    
    private Manager myManager;
    
    public Player (Manager manager) {
        myManager = manager;
    }
    
    public void sendCommand () {
        return;
    }
    
    public void update (Observable o, Object arg) {
        
    }
}
