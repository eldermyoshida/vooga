package vooga.fighter.controller;



import java.awt.Dimension;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.input.Input;
import vooga.fighter.view.Canvas;
/**
 * 
 * @author Jack Matteucci, edited by Jerry Li
 *
 */

public class ControllerManager implements ControllerDelegate{
        
       
	private Map<String, Controller> myControllerMap;
	private List<Controller> myControllerList;
	private Controller myCurrentController;
	private Canvas myCanvas;
	private GameInfo myGameInfo;
	private ControlProgressionManager myProgressionManager;
	private static final String INPUT_PATHWAY = "vooga.fighter.config.menudefault";
	private Input myInput;
	
	public ControllerManager(Canvas frame, GameInfo gameinfo, ControllerFactory factory,
			ControlProgressionManager progressionmanager) {
		myCanvas = frame;
		myInput = new Input(INPUT_PATHWAY, myCanvas);
		//myControllerMap = factory.getMap();
		myControllerMap = factory.getMap();
		myGameInfo = gameinfo;
		myProgressionManager = progressionmanager;
		myProgressionManager.setControllerProgression(myControllerMap);
		myCurrentController = myProgressionManager.getController(0);
		myCurrentController.initializeRest(frame, this, gameinfo);
	}
	
	public void run(){
		myCurrentController.start();
	}
	
	public void notifyEndCondition(String string) {
		switchController(string);
	}

	private void switchController(String condition) {
		myCurrentController.stop();
		myCurrentController = myProgressionManager.getNextController(myCurrentController, condition);
		System.out.println("<controllermanager> now the controller is: " + myCurrentController.getName() );
		//myCurrentController.displaySplash();
		myCurrentController = myCurrentController.getController();
		myCurrentController.initializeRest(myCanvas, this, myGameInfo);
		myCurrentController.start();	
	}      

	public void exit(){
		System.exit(0);
	}
	
	public Input getInput() {
	    return myInput;
	}
}
