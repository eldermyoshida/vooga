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
 * This is a great class to reference when trying to understand how to extend the
 * menu controller hierarchy
 * 
 */
@InputClassTarget
public class MainMenuController extends MenuController {
	
    private ResourceBundle myResources;
    
    public MainMenuController () {
        super();
    }
    
    @Override
    public void initializeRest(Canvas frame, ControllerDelegate manager, 
                           GameInfo gameinfo) {
        super.initializeRest(frame, manager, gameinfo);
        getGameInfo().reset();
        setInput(manager.getInput());
        getInput().addListenerTo(this);

    }
    /**
     * Checks this controller's end conditions
     */
    @Override
    public void notifyEndCondition(String choice) {
        removeListener();
        getMode().resetChoice();
        getManager().notifyEndCondition(getMode().getMenusNext(choice));
    }

  
    @InputMethodTarget(name = "continue")
    public void mouseclick(PositionObject pos)  {
        super.getMode().addObject(new MouseClickObject(pos.getPoint2D()));
    }
    
    @InputMethodTarget(name = "left")
    public void left(AlertObject alObj)  {
        super.getMode().left();
    }
    
    @InputMethodTarget(name = "right")
    public void right(AlertObject alObj)  {
        super.getMode().right();
    }
    
    @InputMethodTarget(name = "up")
    public void up(AlertObject alObj)  {
        super.getMode().up();
    }
    
    @InputMethodTarget(name = "down")
    public void down(AlertObject alObj)  {
        super.getMode().down();
    }
    
    @InputMethodTarget(name = "enter")
    public void enter(AlertObject alObj)  {
        super.getMode().setChoice(getMode().getCurrentMode().getValue());
    }
    
    public void removeListener(){
    	super.removeListener();
    	getInput().removeListener(this);
    }
    
    public void checkConditions(){
    	for(ModeCondition condition: getConditions()){
    		if(condition.checkCondition(getMode())) notifyEndCondition(getMode().peekChoice());
    }
    }

}
