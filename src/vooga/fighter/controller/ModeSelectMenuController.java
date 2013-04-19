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
	
    private ResourceBundle myResources;
    private GameInfo myGameInfo;
    
    public ModeSelectMenuController (String name, Canvas frame) {
        super(name, frame);
    }
        
    public ModeSelectMenuController(String name, Canvas frame, ControllerDelegate manager, 
                GameInfo gameinfo) {
        super(name, frame, manager, gameinfo);
        myGameInfo = gameinfo;
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "LevelConfig");
    }
    /**
     * Checks this controller's end conditions
     */
    
    public void notifyModeSelection(String modeName) {
        myGameInfo.setGameMode(modeName);
    }
    
    public void notifyEndCondition(String choice) {
    	choice = "test";
    	if(EXIT.equals(choice)){
    		getInput().removeListener(this);
    		getManager().exit();
    	}
    	if(BACK.equals(choice)){
    		getInput().removeListener(this);
    		getManager().notifyEndCondition(BACK);
    	}
    	else if (getMode().getMenuNames().contains(choice)){
    		getGameInfo().setGameMode(choice);
    		getGameInfo().setNumCharacters(Integer.parseInt(myResources.getString(choice)));
    		getInput().removeListener(this);
    		getManager().notifyEndCondition(NEXT);
    		}
    	}
    
    @Override
    public Controller getController (ControllerDelegate delegate, GameInfo gameinfo) {
        return new MainMenuController(super.getName(), super.getView(),
                                   delegate, gameinfo);
    }
}
