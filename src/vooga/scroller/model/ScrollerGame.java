package vooga.scroller.model;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;
import vooga.scroller.scrollingmanager.OmniScrollingManager;
import vooga.scroller.scrollingmanager.ScrollingManager;
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
public abstract class ScrollerGame  {
    private static ScrollingManager DEFAULT_SM = new OmniScrollingManager();
    private Model myModel;
    private GameView myDisplay;

    public ScrollerGame () {
        myDisplay = new GameView(PlatformerConstants.DEFAULT_WINDOW_SIZE, DEFAULT_SM);
        Model myModel = makeModel(getLevelFileNames());
        myDisplay.setModel(myModel);
    }
    

    private Model makeModel(String ... levelFileNames) {
        return new Model(myDisplay, DEFAULT_SM, levelFileNames);
    }
    
    protected abstract String[] getLevelFileNames();
    
    public void start() {
     // container that will work with user's OS
        JFrame frame = new JFrame(getTitle());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add our user interface components
        frame.getContentPane().add(myDisplay, BorderLayout.CENTER);
        // display them
        frame.pack();
        frame.setVisible(true);
        // start animation
        myDisplay.start();
    }


    protected abstract String getTitle ();
    

    
}
