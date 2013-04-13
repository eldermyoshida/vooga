package vooga.fighter.controller;

import vooga.fighter.input.Input;
import vooga.fighter.input.InputClassTarget;
import vooga.fighter.view.Canvas;
import vooga.fighter.game.*;

import java.awt.Dimension;




/**
 * 
 * @author Jerry Li
 * 
 * @Modified by Jack Matteucci
 *
 */

public abstract class Controller implements ModelDelegate {

    
    protected Mode myGame;
    private Input myInput;
    protected final Dimension DEFAULT_BOUNDS = new Dimension(800, 800);
    private ControllerDelegate myManager;
    private String myName;
    private String myPath;
    private Canvas myCanvas;
    private GameInfo myGameInfo;
    
    public Controller(String name, Canvas frame){
    	myName = name;
    	myCanvas = frame;
    	myInput = makeInput();
    }
    
    public Controller(String name, Canvas frame, ControllerDelegate manager, GameInfo gameinfo) {
    	this(name, frame);
    	myManager = manager;
    	myGameInfo = gameinfo;
    }
    
    public String getName(){
    	return myName;
    }
    
    protected Canvas getView(){
    	return myCanvas;
    }
    
    protected String getPath(){
    	return myPath;
    }
    
    protected ControllerDelegate getManager(){
    	return myManager;
    }
    
    protected GameInfo getGameInfo(){
    	return myGameInfo;
    }
    
    public void displaySplash(){
    	
    }
    
    public abstract void start();
    
    public abstract void stop();
    
    public abstract Controller getController(ControllerDelegate manager, GameInfo gameinfo);

    protected abstract Input makeInput();
    
    
}
