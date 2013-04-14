package vooga.fighter.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.awt.*;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

import vooga.fighter.controller.Mode;
import vooga.fighter.controller.ViewDelegate;


import vooga.fighter.util.Pixmap;
import vooga.fighter.util.Text;


/**
 * Creates an area of the screen in which the game will be drawn that supports:
 * <UL>
 *   <LI>animation via the Timer
 *   <LI>mouse input via the MouseListener
 *   <LI>keyboard input via the KeyListener
 * </UL>
 * 
 * @author Robert C Duvall
 */
public class Canvas extends JComponent {
    // default serialization ID
    private static final long serialVersionUID = 1L;
    
    private GraphicsEnvironment vc;
    // animate 25 times per second if possible
    public static final int FRAMES_PER_SECOND = 25;
    // better way to think about timed events (in milliseconds)
    public static final int ONE_SECOND = 1000;
    public static final int DEFAULT_DELAY = ONE_SECOND / FRAMES_PER_SECOND;
    // input state
    public static final int NO_KEY_PRESSED = -1;
    //Key to turn Full Screen on during splash screen
    private static final int FULL_SCREEN_ON = KeyEvent.VK_M;
  //Key to turn Full Screen off during splash screen
    private static final int FULL_SCREEN_OFF = KeyEvent.VK_N;
    // This is the Splash Backdrop
	private static final Pixmap SPLASH_IMAGE = new Pixmap("MarioBackground.jpeg");
	// This is the Text the Splash Screen will display
    private Text SplashScreenText;
    
	// This object is needed to create the full screen, see full screen method
    private DisplayMode dm;
    // Needed in order to implement the full screen option
    private GraphicsDevice VideoCard;

    // drives the animation
    private Timer myTimer;
    // game to be animated
    private ViewDataSource myViewDelegate;

    // input state
    private int myLastKeyPressed;
    private Point myLastMousePosition;

    /**
     * Create a panel so that it knows its size
     */
    public Canvas (Dimension size) {
        // set size (a bit of a pain)
        setPreferredSize(size);
        setSize(size);
        //Get our graphics environment
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //Get access to graphics card
        VideoCard = environment.getDefaultScreenDevice();
        // prepare to receive input
        setFocusable(true);
        requestFocus();
        setInputListeners();
    }

    /**
     * Paint the contents of the canvas.
     * 
     * Never called by you directly, instead called by Java runtime
     * when area of screen covered by this container needs to be
     * displayed (i.e., creation, uncovering, change in status)
     * 
     * @param pen used to paint shape on the screen
     */
    @Override
    public void paintComponent(Graphics pen) {
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, getSize().width, getSize().height);
        // first time needs to be special cased :(
        for(int i = 0; i< myViewDelegate.ObjectNumber(); i++){
        	myViewDelegate.getPaintable(i).paint(pen, 
        			myViewDelegate.getLocation(i),
        			myViewDelegate.size(i));
        }
    }


    /**
     * Returns last key pressed by the user.
     */
    public int getLastKeyPressed () {
        return myLastKeyPressed;
    }

    /**
     * Returns last position of the mouse in the canvas.
     */
    public Point getLastMousePosition () {
        return myLastMousePosition;
    }
    
    public void paintMode(){
    	repaint();
    }

    public void setMode(Mode mode){
    	myMode = mode;
    }

    /**
     * This checks if the Splash Screen is up, and if it is, enables changing to full screen
     * and back.  Unfortunately, this is implemented in the Start() method and therefore makes
     * the start method take a JFrame input.
     */
    private void checkFullScreenOptions(JFrame frame){
    	if(getLastKeyPressed()== FULL_SCREEN_ON){
    	setFullScreen(dm, frame);
    }
    
    	if(getLastKeyPressed()== FULL_SCREEN_OFF){
    	restoreScreenSize();
    }
    	}

    /**
     * This sets the screen to Full Screen
     */
    public void setFullScreen(DisplayMode dm, JFrame window){
    	VideoCard.setFullScreenWindow(window);
    	//setSize(VideoCard.getFullScreenWindow().getSize());
    	
    	if(dm != null && VideoCard.isDisplayChangeSupported()){
    		try{
    			VideoCard.setDisplayMode(dm);
    		}catch(Exception exception){}
    	}
    	
    }
    
    /**
     * This returns the Screen back to its regular size
     */
    public void restoreScreenSize(){
    	Window w = VideoCard.getFullScreenWindow();
    	VideoCard.setFullScreenWindow(null);
    }

    /**
     * Create listeners that will update state based on user input.
     */
    private void setInputListeners () {
        // initialize input state
        myLastKeyPressed = NO_KEY_PRESSED;
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed (KeyEvent e) {
                myLastKeyPressed = e.getKeyCode();
            }
            @Override
            public void keyReleased (KeyEvent e) {
                myLastKeyPressed = NO_KEY_PRESSED;
            }
        });
        myLastMousePosition = new Point();
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved (MouseEvent e) {
                myLastMousePosition = e.getPoint();
            }
        });
    }
}
