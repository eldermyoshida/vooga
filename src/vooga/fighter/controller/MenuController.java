package vooga.fighter.controller;

import vooga.fighter.controller.Controller;
import vooga.fighter.controller.ControllerDelegate;
import vooga.fighter.controller.GameInfo;
import vooga.fighter.controller.LevelController;
import vooga.fighter.game.*;
import vooga.fighter.input.Input;
import vooga.fighter.view.Canvas;

import java.util.ResourceBundle;


/**
 * 
 * @author Jerry Li and Jack Matteucci
 * 
 */
public class MenuController extends Controller {

    private static final String INPUT_PATHWAY = "PATHWAY";

    public MenuController (String name, Canvas frame) {
        super(name, frame);
    }
	
    public MenuController(String name, Canvas frame, ControllerDelegate manager, 
    		GameInfo gameinfo) {
    	super(name, frame, manager, gameinfo);
    }

    /**
     * Checks special occurences of game state.
     */
    public void checkConditions () {
        // Couple of reasons for this method as opposed to just one switchMode()
        // button is selected, switch mode
        // If player is knocked out, flash sign
        // If player health is very low, change display
        // If player controller disconnected, flash splash/message
        // etc......

        // checkLowPlayerHealth()
        // checkDisconnect()
        // checkSpecial() etc.

        // Essentially check conditions is different than update in that
        // it checks special occurences in games. Update will check for bounds,
        // interactions, and all that, but as far as significant changes to game state goes we
        // should
        // use check conditions
    }
    /**
     * Checks special occurences of game state.
     */
    public void notifyEndCondition(String string) {
        
    }


    @Override
    public Controller getController (ControllerDelegate delegate, GameInfo gameinfo) {
        return new MenuController(super.getName(), super.getView(),
                                   delegate, gameinfo);
    }

    @Override
    protected Input makeInput () {
        return new Input(INPUT_PATHWAY, super.getView());
    }

}
