package vooga.fighter.controller;

import util.Location;
import util.input.AlertObject;
import util.input.Input;
import util.input.InputClassTarget;
import util.input.InputMethodTarget;
import util.input.PositionObject;
import vooga.fighter.controller.Controller;
import vooga.fighter.controller.ControllerDelegate;
import vooga.fighter.controller.GameInfo;
import vooga.fighter.controller.OneVOneController;
import vooga.fighter.model.*;
import vooga.fighter.model.objects.MouseClickObject;
import vooga.fighter.util.Paintable;
import vooga.fighter.view.Canvas;

import java.awt.Dimension;
import java.util.List;
import java.util.ResourceBundle;


/**
 * 
 * @author Jerry Li and Jack Matteucci
 */

@InputClassTarget
public class CharacterSelectController extends MenuController {

	private int myCharLimit;
	private int myCharIndex;

    public CharacterSelectController (String name, Canvas frame) {
        super(name, frame);
    }
        
    public CharacterSelectController(String name, Canvas frame, ControllerDelegate manager, 
                GameInfo gameinfo) {
        super(name, frame, manager, gameinfo);
        myCharLimit = getGameInfo().getNumCharacters();
        myCharIndex = 0;
    }

    @Override
    public Controller getController (ControllerDelegate delegate, GameInfo gameinfo) {
        return new CharacterSelectController(super.getName(), super.getView(),
                                   delegate, gameinfo);
    }

    /**
     * Checks this controller's end conditions
     */
    public void notifyEndCondition(String choice) {
    	if(BACK.equals(choice)) getManager().notifyEndCondition(BACK);	
    	else if (getMode().getMenuNames().contains(choice)){
    		getGameInfo().setCharacter(myCharIndex, choice);
    		myCharIndex++;
    		if(myCharIndex >= myCharLimit)
    		getManager().notifyEndCondition(NEXT);
    		}
    	}

}

