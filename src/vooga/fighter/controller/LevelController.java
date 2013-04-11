package vooga.fighter.controller;

import vooga.fighter.game.SplashScreen;
import vooga.fighter.input.Input;
import vooga.fighter.input.InputClassTarget;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Timer;

import vooga.fighter.view.Canvas;


public class LevelController {
	private static final String SPLASHSCREEEN = "SplashScreen";
	private Map<String, Mode> myModeMap;
	private Mode myCurrentMode;
	private Canvas myCanvas;
	private PlayerStatus myPlayerStatus;
	public static final Dimension SIZE = new Dimension(800, 600);
    public static final String TITLE = "Fighter!";

    public static final int FRAMES_PER_SECOND = 25;
    // better way to think about timed events (in milliseconds)
    public static final int ONE_SECOND = 1000;
    public static final int DEFAULT_DELAY = ONE_SECOND / FRAMES_PER_SECOND;
    private ModeController myModeManager;
    private MediaManager myMediaManager;
    private Input myInput;
	
	@InputClassTarget
	public LevelController(Canvas frame, PlayerStatus playerstatus, MediaManager mediamanager, Input input) {
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
	
	 public void run () {
	        final int stepTime = DEFAULT_DELAY;
	        // create a timer to animate the canvas
	        Timer timer = new Timer(stepTime, 
	            new ActionListener() {
	                public void actionPerformed (ActionEvent e) {
	                    myLevel.update((double) stepTime / ONE_SECOND, myCanvas.getSize());
	                    myCanvas.paint()
	                }
	            });
	        // start animation
	        timer.start();
	    }


}
