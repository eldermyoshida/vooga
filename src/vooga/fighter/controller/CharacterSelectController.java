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
 * @author Jerry Li
 * @author Jack Matteucci
 */

@InputClassTarget
public class CharacterSelectController extends MenuController {

	private int myCharLimit;
	private int myCharIndex;
	private Input myInput;

    public CharacterSelectController () {
        super();
    }
        
    public CharacterSelectController(String name, Canvas frame, ControllerDelegate manager, 
                GameInfo gameinfo) {
        super(name, frame, manager, gameinfo);
        myCharLimit = getGameInfo().getNumCharacters();
        myCharIndex = 0;
    }
    
    public Controller getController(String name, Canvas frame, ControllerDelegate manager, GameInfo gameinfo) {
        Controller controller = new CharacterSelectController(name, frame, manager, gameinfo);
        return controller;
    }

    /**
     * Checks this controller's end conditions
     */
    public void notifyEndCondition(String choice) {
    	getGameInfo().addCharacters(choice);
    	getMode().resetChoice();
    	myCharIndex ++;
    	System.out.println("character selected");
    	if(myCharIndex >= myCharLimit){
    	removeListener();
        getManager().notifyEndCondition(getMode().getMenusNext(choice));
    	}
    } 
    
    @InputMethodTarget(name = "continue")
    public void mouseclick(PositionObject pos)  {
        super.getMode().addObject(new MouseClickObject(pos.getPoint2D()));
        
    }
    public void removeListener(){
    	super.removeListener();
    	getInput().removeListener(this);
    }
    
    public void checkConditions(){
    	for(ModeCondition condition: getConditions())
    		if(condition.checkCondition(getMode())) notifyEndCondition(getMode().peekChoice());
    }

}

