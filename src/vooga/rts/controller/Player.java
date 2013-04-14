package vooga.rts.controller;

import javax.swing.JComponent;
import vooga.rts.manager.Manager;
import vooga.rts.input.ActionObject;
import vooga.rts.input.AlertObject;
import vooga.rts.input.Input;
import vooga.rts.input.PositionObject;
/**
 * At the moment, the player class is implementing the humanplayer. For network
 * player and ai player, some methods will be refactored into a super class
 * 
 * @author Challen Herzberg-Brovold
 *
 */
public class Player implements Controller {

    private final static String DEFAULT_INPUT_LOCATION = "vooga.rts.resources.properties.Input";
    
    private Manager myManager;
    
    public Player (Manager manager, JComponent component) {
        myManager = manager;
        Input input = new Input(DEFAULT_INPUT_LOCATION, component);
        input.addListenerTo(this);
    }
    
    public void sendCommand () { // this will send the command to the unit manager. Exactly what this is going to be is still being determined
        return;
    }
    
    //TODO: figure out how to have the same method called for all 
}
