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
 * @author Jack Matteucci
 * 
 */
@InputClassTarget
public class MainMenuController extends MenuController {
	
    private ResourceBundle myResources;
    
    public MainMenuController (String name, Canvas frame) {
        super(name, frame);
    }
        
    public MainMenuController(String name, Canvas frame, ControllerDelegate manager, 
                GameInfo gameinfo) {
        super(name, frame, manager, gameinfo);

        setInput(manager.getInput());
        getInput().addListenerTo(this);

        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "LevelConfig");
    }
    /**
     * Checks this controller's end conditions
     */
    @Override
    public void notifyEndCondition(String choice) {
    	System.out.println("MainMenuNotify");
        removeListener();
        getManager().notifyEndCondition(NEXT);
    }

    @Override
    public Controller getController (ControllerDelegate delegate, GameInfo gameinfo) {
        return new MainMenuController(super.getName(), super.getView(),
                                   delegate, gameinfo);
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
    	String choice = getMode().getChoice();
    	for(String other: getMode().getMenuNames()){
        	if(other.equals(choice)){
        		notifyEndCondition(choice);
        	}
    	}
    }
}
