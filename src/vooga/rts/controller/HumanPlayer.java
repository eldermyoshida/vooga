package vooga.rts.controller;

import java.util.Map;
import vooga.rts.manager.Manager;
import vooga.rts.player.Player;
import vooga.rts.state.State;

/**
 * The Player needs to do make the following decisions:
 * - does the command affect units or managers (eg. select units)?
 *      - if so, does it need to be sent to server/be bounced back. If it affects
 *      a manager, it can be executed immediately, but if it affects units, it
 *      needs to be sent to the server. 
 * - does the command affect the view or other non-gameplay related things?
 * 
 * This versin of Player will eventually be called HumanPlayer, and Player will
 * also be used with AI and the network to control other sets of managers.
 *      
 * @author Challen Herzberg-Brovold
 *
 */
public class HumanPlayer extends Player implements Controller {
    

    private Map<String, Controllable> myInputMap; // Maps the command to the appropriate controllable

    public HumanPlayer (int id) {
        super(id);
        // method which adds all the inputs from controllables to them.
        // Maybe look for design pattern that can implement filtering the inputs
    }
    
    @Override
    public void sendCommand (Command command) {
        
    }
 
    /**
     * 
     * @param command
     */
    public void getInfo (Command command) { 
        //At some point, will pass in list of controllables, and actually have to sort the command
        getManager().receiveCommand(command);
    }
}
