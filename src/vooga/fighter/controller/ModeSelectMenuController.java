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
 * @author Jerry Li & Jack Matteucci
 * 
 */

@InputClassTarget
public class ModeSelectMenuController extends MenuController {
	
    private static final String FILE_NAME = "vooga.fighter.config.ModeCharacterNumbers";
    private ResourceBundle myResources;
    
    public ModeSelectMenuController () {
        super();
        myResources = ResourceBundle.getBundle(FILE_NAME);

    }
        
    public void initializeRest(Canvas frame, ControllerDelegate manager, 
                GameInfo gameinfo) {
        super.initializeRest(frame, manager, gameinfo);
    }
    /**
     * Checks this controller's end conditions
     */
    
    public void notifyEndCondition(String choice) {
    	removeListener();
    		getGameInfo().setGameMode(choice);
    		getGameInfo().setNumCharacters(Integer.parseInt(myResources.getString(choice)));    		
    		getManager().notifyEndCondition(getMode().getMenusNext(choice));
    		
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
    		if(condition.checkCondition(getMode())) notifyEndCondition(getMode().getChoice());
    }

    

}