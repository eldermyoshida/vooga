package vooga.fighter.controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

import vooga.fighter.util.Pixmap;
import vooga.fighter.util.Text;
import vooga.fighter.view.Canvas;
import vooga.fighter.game.*;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller {
	public static final Dimension SIZE = new Dimension(800, 600);
    public static final String TITLE = "Mario!";

    public static final int FRAMES_PER_SECOND = 25;
    // better way to think about timed events (in milliseconds)
    public static final int ONE_SECOND = 1000;
    public static final int DEFAULT_DELAY = ONE_SECOND / FRAMES_PER_SECOND;
    private Canvas myCanvas;
    private ModeManager myModeManager;
    private PlayerStatus myPlayerStatus;
    
    //added by Jerry
    private ResourceBundle myResources;
    private Map<String, String> myLevelPaths; 
    private List<String> myLevelNames;
    private List<GameInstance> myLevels;
    
    //added by Jerry
    private static final String DEFAULT_RESOURCE_PACKAGE = "vooga.fighter.config.";
    
    
   
   
	
    public Controller() {
        myCanvas = new Canvas(SIZE); 
        //DisplayMode dm = new DisplayMode(SIZE.width,SIZE.height, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
        // container that will work with user's OS
        JFrame frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add our user interface components
        frame.getContentPane().add(myCanvas, BorderLayout.CENTER);
        // display them
        frame.pack();
        frame.setVisible(true);
	myModeManager = new ModeManager(myCanvas, myPlayerStatus);
	
	//Added by Jerry
	myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "LevelConfig");
	readFile(myResources);
	
	}
        
        //added by Jerry
        public void readFile(ResourceBundle resources) {
            Enumeration<String> keys = resources.getKeys();
            String key = null;
            while(keys.hasMoreElements()) {
                key = keys.nextElement();
                myLevelPaths.put(key, myResources.getObject(key).toString());
                myLevelNames.add(key);
            }
            loadGame(myLevelPaths);
        }
        
        //added by jerry
        //THis is kinda messy but gets the point across. Mainly adding the games with the string and key is
        //simple enough, but passing through the next mode is tricky once you reach the end of the array.
        //So the last level just gets passed the first level as the next mode
        public void loadGame(Map<String, String> levels) {
            for (int i = 1; i <= myLevelNames.size(); i++) {
               if (i == myLevelNames.size()) {
                   GameInstance game = 
                           new GameInstance(myLevelNames.get(i), myLevelPaths.get(i), myLevelNames.get(0));
                   myLevels.add(game);
               }
                GameInstance game = 
                        new GameInstance(myLevelNames.get(i), myLevelPaths.get(i), myLevelNames.get(i+1));
                   myLevels.add(game);
            }
        }
    
	
	 public void start () {
	        final int stepTime = DEFAULT_DELAY;
	        // create a timer to animate the canvas
	        Timer timer = new Timer(stepTime, 
	            new ActionListener() {
	                public void actionPerformed (ActionEvent e) {
	                    myModeManager.update((double) stepTime / ONE_SECOND);
	                    myCanvas.paintMode();
	                }
	            });
	        // start animation
	        timer.start();
	    }

}
