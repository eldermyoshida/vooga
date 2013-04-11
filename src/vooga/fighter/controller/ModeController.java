package vooga.fighter.controller;

import vooga.fighter.game.SplashScreen;
import vooga.fighter.input.Input;
import vooga.fighter.input.InputClassTarget;

import java.awt.Dimension;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import vooga.fighter.view.Canvas;


public class ModeController {
	private static final String SPLASHSCREEEN = "SplashScreen";
	private Map<String, Mode> myModeMap;
	private Mode myCurrentMode;
	private Canvas myCanvas;
	private PlayerStatus myPlayerStatus;
	
	@InputClassTarget
	public ModeController(Canvas frame, PlayerStatus playerstatus, MediaManager mediamanager, Input input) {
		myCanvas = frame;
		myPlayerStatus = playerstatus;
		myModeMap = new ModeFactory(frame, mediamanager , input).getMap();
		setup();
	}
	
	public void update(double time, Dimension bounds){
		myCurrentMode.update(time, bounds);
		switchModes(myCurrentMode.needNextMode());
	}
	
	
	private void switchModes(boolean shouldChange){
		if(shouldChange){
		myCurrentMode.reset();
		myCurrentMode.switchNeed();
//		myPlayerStatus.addScore(myCurrentMode.getStatus());
		myCurrentMode = myModeMap.get(myCurrentMode.getNextModeName());
		myCanvas.setMode(myCurrentMode);
		}
	}
	
	private void setup(){
		myCurrentMode = myModeMap.get(SPLASHSCREEEN);
		myCanvas.setMode(myCurrentMode);
	}
	
//	public Mode getCurrentMode(){
//		return myCurrentMode;
//	}

}
