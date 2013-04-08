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
import vooga.fighter.input.Input;
import vooga.fighter.input.InputClassTarget;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;


@InputClassTarget
public class Controller {
	public static final Dimension SIZE = new Dimension(800, 600);
    public static final String TITLE = "Fighter!";

    public static final int FRAMES_PER_SECOND = 25;
    // better way to think about timed events (in milliseconds)
    public static final int ONE_SECOND = 1000;
    public static final int DEFAULT_DELAY = ONE_SECOND / FRAMES_PER_SECOND;
    private Canvas myCanvas;
    private ModeManager myModeManager;
    private PlayerStatus myPlayerStatus;
    private MediaManager myMediaManager;
    private Input myInput;
  

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
        myMediaManager = new MediaManager();
		myInput = new Input("vooga.fighter.input.Game1Mapping_en_US", myCanvas);
		myInput.addListenerTo(this);
		myModeManager = new ModeManager(myCanvas, myPlayerStatus, myMediaManager, myInput);
	
	}

	
	 public void start () {
	        final int stepTime = DEFAULT_DELAY;
	        // create a timer to animate the canvas
	        Timer timer = new Timer(stepTime, 
	            new ActionListener() {
	                public void actionPerformed (ActionEvent e) {
	                    myModeManager.update((double) stepTime / ONE_SECOND, myCanvas.getSize());
	                    myCanvas.paintMode();
	                }
	            });
	        // start animation
	        timer.start();
	    }

}
