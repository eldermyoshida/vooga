package vooga.fighter.controller;

import vooga.fighter.game.SplashScreen;
import vooga.fighter.input.Input;
import vooga.fighter.input.InputClassTarget;

import java.awt.Dimension;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import vooga.fighter.view.Canvas;



/**
 * 
 * @author Jerry Li
 * 
 * @Modified by Jack Matteucci
 *
 */
public abstract class Controller{
    
    protected Mode myGame;
    private Input myInput;
    protected final Dimension DEFAULT_BOUNDS = new Dimension(800, 800);
    private ManagerDelegate myManager;
    private String myName;
    private String myPath;
    private Canvas myCanvas;
    
    public Controller(String name, Canvas frame){
    	myName = name;
    	myCanvas = frame;
    	myInput = makeInput();
    }
    
    public Controller(String name, Canvas frame, ManagerDelegate manager) {
    	this(name, frame);
    	myManager = manager;
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
    
    protected ManagerDelegate getManager(){
    	return myManager;
    }
    
    public void displaySplash(){
    	
    }
    
    public abstract void start();
    
    public abstract void stop();
    
    public abstract Controller getController();

    protected abstract Input makeInput();
    
    
}
