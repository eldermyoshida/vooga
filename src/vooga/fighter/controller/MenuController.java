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
import vooga.fighter.controller.LevelController;
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
 * 
 */

@InputClassTarget
public class MenuController extends Controller {

	private static final String INPUT_PATHWAY = "vooga.fighter.config.menudefault";
	private static final String INPUT_SETTING = "vooga.fighter.config.Settings";
	private static final String TEST = "Test";
    private GameInfo myGameInfo;
    private LoopInfo myLoopInfo;

    public MenuController (String name, Canvas frame) {
        super(name, frame);
    }
	
    public MenuController(String name, Canvas frame, ControllerDelegate manager, 
    		GameInfo gameinfo) {
    	super(name, frame, manager, gameinfo);
    	loadMode();
    	//Duplicated code below, see levelcontroller
    	LoopInfo gameLoopInfo =  new LoopInfo(super.getMode());
    	setGameLoopInfo(gameLoopInfo);
    	frame.setViewDataSource(gameLoopInfo);
    	myGameInfo = gameinfo;
    }
    
    public void loadMode() {
        Mode mode = new MenuMode(this, super.getName());
        mode.initializeMode();
        super.setMode(mode);
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
        super.getGameInfo().setGameMode(string);
        super.getManager().notifyEndCondition(string);
    }


    @Override
    public Controller getController (ControllerDelegate delegate, GameInfo gameinfo) {
        return new MenuController(super.getName(), super.getView(),
                                   delegate, gameinfo);
    }

    @InputMethodTarget(name = "continue")
    public void mouseclick(PositionObject pos)  {
        super.getMode().addObject(new MouseClickObject(pos.getPoint2D()));
        System.out.println(myGameInfo.getGameInfo());
        notifyEndCondition("Test");
    }
    
    @Override
    protected Input makeInput () {
        Input temp = new Input(INPUT_PATHWAY, super.getView());
        temp.overrideSettings(INPUT_SETTING);
        temp.addListenerTo(this);
    	return temp;
    }

	@Override
	public void notifyEndCondition(int endCondition) {
		// TODO Auto-generated method stub
		
	}

    

}
