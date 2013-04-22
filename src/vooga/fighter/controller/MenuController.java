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
import vooga.fighter.model.objects.CharacterObject;
import vooga.fighter.model.objects.MouseClickObject;
import vooga.fighter.util.Paintable;
import vooga.fighter.view.Canvas;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


/**
 * 
 * @author Jerry Li 
 * @author Jack Matteucci
 * 
 */
@InputClassTarget
public abstract class MenuController extends Controller {

    private static final String INPUT_PATHWAY = "vooga.fighter.config.menudefault";
    private List<ModeCondition> myEndConditions;

    public MenuController () {
        super();
    }
    
    
    public MenuController(String name, Canvas frame, ControllerDelegate manager, 
    		GameInfo gameinfo) {
    	super(name, frame, manager, gameinfo);
        setInput(manager.getInput());
        getInput().replaceMappingResourcePath(INPUT_PATHWAY);
        getInput().addListenerTo(this);
       
    	DisplayLoopInfo LoopInfo =  new DisplayLoopInfo(super.getMode());
    	setLoopInfo(LoopInfo);
    	myEndConditions = new ArrayList<ModeCondition>();
    	setupConditions();
    }
    
    
    @InputMethodTarget(name = "continue")
    public void mouseclick(PositionObject pos)  {
        getMode().addObject(new MouseClickObject(pos.getPoint2D()));
    }
    
    @InputMethodTarget(name = "left")
    public void left(AlertObject alObj)  {
    	if(getMode().inputReady()) getMode().left();
    }
    
    @InputMethodTarget(name = "right")
    public void right(AlertObject alObj)  {
    	if(getMode().inputReady()) getMode().right();
    }
    
    @InputMethodTarget(name = "up")
    public void up(AlertObject alObj)  {
    	if(getMode().inputReady())  getMode().up();
    }
    
    @InputMethodTarget(name = "down")
    public void down(AlertObject alObj)  {
    	if(getMode().inputReady()) getMode().down();
    }
    
    @InputMethodTarget(name = "enter")
    public void enter(AlertObject alObj)  {
    	if(getMode().inputReady())  getMode().setChoice(getMode().getCurrentMode().getValue());
    }
    
    public void loadMode() {
        Mode mode = new MenuMode(super.getName());
        super.setMode(mode);
    }
    
    public MenuMode getMode(){
    	return (MenuMode) super.getMode();
    }
    
    public Controller getController() {
        return this;
    }
    
    public void removeListener(){
    	super.removeListener();
    	getInput().removeListener(this);
    }
    
    protected void addEndCondition(ModeCondition condition){
    	myEndConditions.add(condition);
    }
    
    protected List<ModeCondition> getConditions(){
    	return myEndConditions;
    }
    
    
    public void setupConditions(){
    	addEndCondition(endcondition);
    }
    
    ModeCondition endcondition = new ModeCondition() {
    	public boolean checkCondition(Mode mode) {
			return !("".equals(getMode().peekChoice()));
    	}
    };


}
