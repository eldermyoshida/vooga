package vooga.fighter.controller;

import vooga.fighter.game.SplashScreen;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import vooga.fighter.view.Canvas;


public class ModeManager {
	private static final String SPLASHSCREEEN = "SplashScreen";
	private Map<String, Mode> myModeMap;
	private Mode myCurrentMode;
	private Canvas myCanvas;
	private PlayerStatus myPlayerStatus;
	
	
	public ModeManager(Canvas frame, PlayerStatus playerstatus) {
		myCanvas = frame;
		myPlayerStatus = playerstatus;
		myModeMap = new ModeFactory(frame).getMap();
		setup();
	}
	
	public ModeManager(Canvas frame, PlayerStatus playerstatus, PaintManager paintmanager) {
		this(frame, playerstatus);
		myModeMap = new ModeFactory(frame, paintmanager).getMap();
		setup();
	}
	
	public void update(double time){
		myCurrentMode.update(time);
		switchModes(myCurrentMode.needNextMode());
	}
	
	
	private void switchModes(boolean shouldChange){
		if(shouldChange){
		myPlayerStatus.addScore(myCurrentMode.getStatus());
		myCurrentMode = myModeMap.get(myCurrentMode.getNextModeName());
		myCurrentMode.reset();
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
