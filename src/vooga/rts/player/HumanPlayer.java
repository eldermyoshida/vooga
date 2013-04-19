package vooga.rts.player;

import java.util.Map;
import vooga.rts.controller.Command;
import vooga.rts.controller.Controllable;
import vooga.rts.controller.Controller;


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
        getManager().receiveCommand(command);
    }
}
