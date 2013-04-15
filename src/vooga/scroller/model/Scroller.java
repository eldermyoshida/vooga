package vooga.scroller.model;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import arcade.games.ArcadeInteraction;
import arcade.games.Game;
import arcade.games.UserGameData;
import vooga.scroller.scrollingmanager.DefaultScrollingManager;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.scrollingmanager.StaticScrollingManager;
import vooga.scroller.util.PlatformerConstants;
import vooga.scroller.view.View;


/**
 * Creates window that can be moved, resized, and closed by the user.
 *
 * @author Ross Cahoon
 */
public class Scroller extends Game
{
    public Scroller (ArcadeInteraction arcade) {
        super(arcade);
        // TODO Auto-generated constructor stub
    }


    // constants
    public static final String TITLE = "Scrolling Demo";


    /**
     * main --- where the program starts
     * @param args
     */
    public static void main (String args[])
    {
        // view of user's content
        ScrollingManager scrollManager = new DefaultScrollingManager();
        View display = new View(PlatformerConstants.DEFAULT_WINDOW_SIZE, scrollManager);
        scrollManager.initView(display);
        
        // container that will work with user's OS
        JFrame frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add our user interface components
        frame.getContentPane().add(display, BorderLayout.CENTER);
        // display them
        frame.pack();
        frame.setVisible(true);
        // start animation
        display.start();
    }


    @Override
    public UserGameData generateNewProfile () {
        return null;
    }


    @Override
    public void run () {
        // view of user's content
        
        // TODO: this seems intrinsic to the level
        ScrollingManager scrollManager = new DefaultScrollingManager();
        View display = new View(PlatformerConstants.DEFAULT_WINDOW_SIZE, scrollManager);
        scrollManager.initView(display);
        
        // container that will work with user's OS
        JFrame frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add our user interface components
        frame.getContentPane().add(display, BorderLayout.CENTER);
        // display them
        frame.pack();
        frame.setVisible(true);
        // start animation
        display.start();
        
    }
}
