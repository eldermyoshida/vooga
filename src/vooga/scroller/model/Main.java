package model;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import scrollingmanager.DefaultScrollingManager;
import scrollingmanager.ScrollingManager;
import util.PlatformerConstants;
import view.View;


/**
 * Creates window that can be moved, resized, and closed by the user.
 *
 * @author Robert C. Duvall
 */
public class Main
{
    // constants
    public static final String TITLE = "Scrolling Test";


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
        // TODO: handle iconify (reason for start/stop)
        // TODO: full screen?
    }
}
