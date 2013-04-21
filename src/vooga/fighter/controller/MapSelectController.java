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
    
    
    public MapSelectController () {
        super();
    }
        
    public MapSelectController(String name, Canvas frame, ControllerDelegate manager, 
                GameInfo gameinfo) {
        super(name, frame, manager, gameinfo);
    }
    
    public Controller getController(String name, Canvas frame, ControllerDelegate manager, GameInfo gameinfo) {
        Controller controller = new MapSelectController(name, frame, manager, gameinfo);
        return controller;
    }
    
    /**
     * Checks this controller's end conditions
     */
    public void notifyEndCondition(String choice) {
    	removeListener();
    	getMode().resetChoice();
		getGameInfo().setMapName(choice);
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
    		if(condition.checkCondition(getMode())) notifyEndCondition(getMode().peekChoice());
    }

}

