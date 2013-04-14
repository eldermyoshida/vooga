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
    public void notifyEndCondition () {
       
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