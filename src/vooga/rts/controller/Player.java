package vooga.rts.controller;

import java.util.Map;
import vooga.rts.manager.Manager;
import vooga.rts.state.State;

/**
 * The GController (GameController) needs to do make the following decisions:
 * - does the command affect units or managers (eg. select units)?
 *      - if so, does it need to be sent to server/be bounced back. If it affects
 *      a manager, it can be executed immediately, but if it affects units, it
 *      needs to be sent to the server. 
 * - does the command affect the view or other non-gameplay related things?
 *      
 * @author Challen Herzberg-Brovold
 *
 */
public class Player implements Controller {
    
    private State myGame;
    private Map<String, Controllable> myControlTargets; //Figure out what this is going to do 
    
    public Player (State game) {
        myGame = game;
    }
    
    @Override
    public void sendCommand (Command command) {
        
    }
 
    public void getInfo (Controllable manager, Command command) { 
        //At some point, will pass in list of controllables, and actually have to sort the command
        manager.receiveCommand(command);
    }
}
