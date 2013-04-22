package vooga.scroller.model;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;
import vooga.scroller.scrollingmanager.OmniScrollingManager;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.PlatformerConstants;
import vooga.scroller.view.GameView;
import arcade.games.ArcadeInteraction;
import arcade.games.Game;
import arcade.games.GameData;
import arcade.games.UserGameData;


/**
 * 
 * @author Scrolling Platformer Team
 * 
 */
public abstract class ScrollerGame extends Game {
    private ScrollingManager myScrollingManager;
    private Model myModel;
    private GameView myDisplay;
    private Player myPlayer;
    private String myTitle;
    private String[] myLevels;

    public ScrollerGame (ArcadeInteraction arcade) {
        super(arcade);
        initializeInstanceVariables();
        makeModel();

    }
    
    protected GameView getDisplay(){
        return myDisplay;
    }
    
    protected ScrollingManager getScrollingManager(){
        return myScrollingManager;
    }

    private void initializeInstanceVariables () {
        myScrollingManager = setScrollingManager();
        myDisplay = new GameView(PlatformerConstants.DEFAULT_WINDOW_SIZE, myScrollingManager);
        myPlayer = setPlayer();
        myTitle = setTitle();
        myLevels = setLevelFileNames();
    }

    /**
     * Instantiate and return the Player-extended class you have created.
     * 
     * @return Player
     */
    protected abstract Player setPlayer ();

    /**
     * Instantiate and return the ScrollingManager-extended class.
     * 
     * @return ScrollingManager
     */
    protected abstract ScrollingManager setScrollingManager ();

    /**
     * Create a String array containing the filenames of the levels you
     * have created in the order that you want the levels to be played.
     * 
     * @return String[] of Level filenames
     */
    protected abstract String[] setLevelFileNames ();

    /**
     * Set the title of your game.
     * 
     * @return String title
     */
    protected abstract String setTitle ();

    private void makeModel () {
        myModel = new Model(myDisplay, myScrollingManager, myPlayer, myLevels);
        myModel.addPlayerToLevel();
        myDisplay.setModel(myModel);
    }

    @Override
    public void run () {
        // container that will work with user's OS
        JFrame frame = new JFrame(myTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add our user interface components
        frame.getContentPane().add(myDisplay, BorderLayout.CENTER);
        // display them
        frame.pack();
        frame.setVisible(true);
        // start animation
        myDisplay.start();
    }

}
