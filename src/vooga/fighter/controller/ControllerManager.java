package vooga.fighter.controller;

import vooga.fighter.game.SplashScreen;
import vooga.fighter.input.Input;
import vooga.fighter.input.InputClassTarget;

import java.awt.Dimension;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import vooga.fighter.view.Canvas;


public class ControllerManager implements ControllerDelegate{
	private static final String MAINMENU = "MainMenu";
	private Map<String, Controller> myControllerMap;
	private Controller myCurrentController;
	private Canvas myCanvas;
	private GameInfo myGameInfo;
	
	public ControllerManager(Canvas frame, GameInfo gameinfo) {
		myCanvas = frame;
		myControllerMap = new ControllerFactory(frame).getMap();
		myCurrentController = myControllerMap.get(MAINMENU);
		myGameInfo = gameinfo;
	}
	
	public void run(){
		myCurrentController.start();
	}

	public void switchController(String NextController) {
		myCurrentController.stop();
		myCurrentController = myControllerMap.get(NextController);
		myCurrentController.displaySplash();
		myCurrentController = myCurrentController.getController(this, myGameInfo);
		myCurrentController.start();	
	}

	@Override
	public void notifyEndCondition(String condition) {
		switchController(pickController(condition));
	}
	
	private String pickController(String condition){
		String NextController = ""; //ERROR LOGIC NEEDED!
		return NextController;
	}

}
