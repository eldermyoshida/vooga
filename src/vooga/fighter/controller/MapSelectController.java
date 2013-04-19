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
 * @author Jack Matteucci edited by Jerry Li
 */

@InputClassTarget
public class MapSelectController extends MenuController {
    
    private GameInfo myGameInfo;
    
    public MapSelectController (String name, Canvas frame) {
        super(name, frame);
    }
        
    public MapSelectController(String name, Canvas frame, ControllerDelegate manager, 
                GameInfo gameinfo) {
        super(name, frame, manager, gameinfo);
        myGameInfo = gameinfo;
    }
    
    public void notifyModeSelection(String mapName) {
        myGameInfo.setMapName(mapName);
    }
    
    /**
     * Checks this controller's end conditions
     */
    public void notifyEndCondition(String choice) {
    	removeListener();
    	if(BACK.equals(choice)) getManager().notifyEndCondition(BACK);
    	else if (getMode().getMenuNames().contains(choice)){
    		getGameInfo().setMapName(choice);
    		getInput().removeListener(this);
    		getManager().notifyEndCondition(NEXT);
    		}
    	}



    @Override
    public Controller getController (ControllerDelegate delegate, GameInfo gameinfo) {
        return new MapSelectController(super.getName(), super.getView(),
                                   delegate, gameinfo);
    }
    
    public void removeListener(){
    	super.removeListener();
    	getInput().removeListener(this);
    }

}

