package vooga.fighter.controller;



import util.Location;
import util.Pixmap;
import util.input.Input;
import vooga.fighter.model.*;
import vooga.fighter.view.Canvas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.Timer;




/**
 * 
 * @author Jerry Li and Jack Matteucci
 *
 * This class is the basic controller from which all subclasses extend.  Only should
 * you subclass this controller if there are major changes to be made to the actual
 * mode, as subclassing this controller gives you the freedom to choose what mode it 
 * is attached to.
 *
 *
 */

public abstract class Controller{
    public static final String DEFAULT_RESOURCE_PACKAGE = "vooga.fighter.config.";
	public static final String DEFAULT_IMAGE_PACKAGE = "vooga.fighter.images.";
    public static final String NEXT = "Next";
    public static final String BACK = "Back";
    public static final String EXIT = "EXIT";
    public static final String SPLASH = "Splash";
    public static final String CONTROL = "Control";
    
    protected ControllerDelegate myManager;
    private String myName;
    private String myPath;
    private Canvas myCanvas;
    private GameInfo myGameInfo;
    private ResourceBundle mySplashResource;
    private String mySplashPath;

    private Input myInput;
    public static final int FRAMES_PER_SECOND = 25;
    // better way to think about timed events (in milliseconds)
    public static final int ONE_SECOND = 1000;
    public static final int DEFAULT_DELAY = ONE_SECOND / FRAMES_PER_SECOND;
    private Timer myTimer;
    private Mode myMode;
    private DisplayInfo myDisplayInfo;

    public Controller(){
    
    }
    
    public void initializeName(String name) {
        myName = name;
    }

    public Controller(String name, Canvas frame, ControllerDelegate manager, GameInfo gameinfo) {
        myName = name;
        myCanvas = frame;
        mySplashResource = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + SPLASH);
        mySplashPath = DEFAULT_IMAGE_PACKAGE+ mySplashResource.getString(CONTROL);
        myManager = manager;
        myGameInfo = gameinfo;
        loadMode();
    }
    
    public abstract Controller getController(String name, Canvas frame, ControllerDelegate manager, GameInfo gameinfo);
    
    protected void setInput(Input input){
    	myInput = input;
    }

    public String getName(){
        return myName;
    }
    
    public void setName(String name) {
        myName = name;
    }
    
    protected Input getInput(){
    	return myInput;
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
    
    protected Mode getMode(){
    	return myMode;
    }

    protected void setMode(Mode mode){
        myMode = mode;
        myMode.initializeMode();
    }
    
    protected void setLoopInfo(DisplayInfo loopinfo){
    	myDisplayInfo = loopinfo;
    	myCanvas.setViewDataSource(myDisplayInfo);
    }

    public void displaySplash(){
    	myCanvas.setViewDataSource(myDisplayInfo);
    	myCanvas.paint();
    }
    
    private void generateSplash(){
    	myDisplayInfo = new DisplayInfo();
    	myDisplayInfo.clear();
    	
        myDisplayInfo.setSize(0, GameManager.SIZE);
        myDisplayInfo.setGameObjectLocation(0, new Location(GameManager.SIZE.getWidth()/2, GameManager.SIZE.getHeight()/2));
        myDisplayInfo.setGamePaintable(0, new Pixmap(mySplashPath));
    }

    public void start() {
        final int stepTime = DEFAULT_DELAY;
        // create a timer to animate the canvas
         myTimer = new Timer(stepTime, 
                               new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                myMode.update((double) stepTime / ONE_SECOND, myCanvas.getSize());
                myDisplayInfo.update();
                myCanvas.paint();
                checkConditions();
            }
        });
        // start animation
        myTimer.start();
    }

    /**
     * Exits program.
     */
    public void exit () {
        System.exit(0);
    }

    public void stop () {
        myTimer.stop();

    }

    public void loadMode() {

    }
    public void removeListener(){
    	getInput().removeListener(this);
    }
    
    public abstract void checkConditions();
 
    public abstract void notifyEndCondition(String choice);
    public abstract Controller getController();

        


}
