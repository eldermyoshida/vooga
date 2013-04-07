package vooga.fighter.controller;

import vooga.fighter.game.SplashScreen;

import java.util.HashMap;
import java.util.Map;

import vooga.fighter.view.Canvas;


public class ModeFactory {
	private Map<String, Mode> myModeMap;
	private Canvas myCanvas;
	
	public ModeFactory(Canvas frame) {
		myCanvas = frame;
		myModeMap = new HashMap<String, Mode>();
		Mode mode = new SplashScreen(frame, "SPLASHSCREEN");
		myModeMap.put(mode.getModeName(), mode);
	}
	
	public ModeFactory(Canvas frame, PaintManager paintmanager) {
		myCanvas = frame;
		myModeMap = new HashMap<String, Mode>();
		Mode mode = new SplashScreen(frame, "SPLASHSCREEN");
		mode.setupPainting(paintmanager);
		myModeMap.put(mode.getModeName(), mode);
	}
	
	public Map getMap(){
		return myModeMap;
	}


}
