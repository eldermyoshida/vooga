package vooga.fighter.controller;

import vooga.fighter.game.SplashScreen;
import vooga.fighter.input.Input;
import vooga.fighter.input.InputClassTarget;

import java.awt.Dimension;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import vooga.fighter.view.Canvas;


public class ControllerManager implements ManagerDelegate{
	private static final String MAINMENU = "MainMenu";
	private Map<String, Controller> myControllerMap;
	private Controller myCurrentController;
	private Canvas myCanvas;
	private String myControllerFilePath;
	
	@InputClassTarget
	public ControllerManager(Canvas frame, MediaManager mediamanager, String ControllerFilePath) {
		myCanvas = frame;
		myControllerMap = new ControllerFactory(frame).getMap();
		myCurrentController = myControllerMap.get(MAINMENU);
	}
	
	public void run(){
		myCurrentController.start();
	}

	public void switchController(String NextController) {
		myCurrentController.stop();
		myCurrentController = myControllerMap.get(NextController);
		myCurrentController.displaySplash();
		myCurrentController = myCurrentController.getController();
		myCurrentController.start();
		
		
		
	}

}
