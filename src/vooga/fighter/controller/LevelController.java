package vooga.fighter.controller;


import vooga.fighter.game.Game;
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

/**
 * 
 * @author Jerry Li
 *
 */
@InputClassTarget
public class LevelController extends Controller implements ModelDelegate{
    
    public static final int FRAMES_PER_SECOND = 25;
    // better way to think about timed events (in milliseconds)
    public static final int ONE_SECOND = 1000;
    public static final int DEFAULT_DELAY = ONE_SECOND / FRAMES_PER_SECOND;
    private static final String INPUT_PATHWAY = "PATHWAY";
	private PlayerStatus myPlayerStatus;
	private Timer myTimer;
	private Mode myMode;
	private Canvas myCanvas;
	
    public LevelController(String name, Canvas frame){
    	super(name,frame);
    }
	
    public LevelController(String name, Canvas frame, ManagerDelegate manager, 
    		PlayerStatus PlayerScores) {
    	super(name, frame, manager);
    	myPlayerStatus = PlayerScores;
    }
    
	
	 public void start() {
	        final int stepTime = DEFAULT_DELAY;
	        // create a timer to animate the canvas
	        myCanvas = super.getView();
	         myTimer = new Timer(stepTime, 
	            new ActionListener() {
	                public void actionPerformed (ActionEvent e) {
	                    myMode.update((double) stepTime / ONE_SECOND, myCanvas.getSize());
	                    myCanvas.paint();
	                }
	            });
	        // start animation
	        myTimer.start();
	    }
    
    /**
     * Checks special occurences of game state. 
     */
    public void checkConditions() {
        //Couple of reasons for this method as opposed to just one switchMode()
        //button is selected, switch mode
        //If player is knocked out, flash sign
        //If player health is very low, change display
        //If player controller disconnected, flash splash/message 
        //etc......
        
        //checkLowPlayerHealth()
        //checkDisconnect()
        //checkSpecial()      etc. 
        
        //Essentially check conditions is different than update in that
        //it checks special occurences in games. Update will check for bounds,
        //interactions, and all that, but as far as significant changes to game state goes we should
        //use check conditions
    }
    
    private PlayerStatus getPlayerStatus(){
    	return myPlayerStatus;
    }
    
    /**
     * Exits program. 
     */
    public void exit() {
        System.exit(0);
    }

	@Override
	public void stop() {
		myTimer.stop();
		
	}

	@Override
	public Controller getController(ManagerDelegate manager, PlayerStatus playerstatus) {
		return new LevelController(super.getName(), super.getView(),
				super.getManager(), getPlayerStatus());
}

	@Override
	protected Input makeInput() {
		return new Input(INPUT_PATHWAY, super.getView());
	}

}
