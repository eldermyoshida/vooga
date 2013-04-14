package vooga.fighter.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import javax.swing.JComponent;
import vooga.fighter.controller.ViewDataSource;
import vooga.fighter.view.CanvasLayout;


/**
 * Creates an area of the screen in which the game will be drawn that supports:
 * <UL>
 * <LI>animation via the Timer
 * <LI>mouse input via the MouseListener
 * <LI>keyboard input via the KeyListener
 * </UL>
 * 
 * @author Robert C Duvall
 * @author Wayne You
 */
public class Canvas extends JComponent {
    // default serialization ID
    private static final long serialVersionUID = 1L;
    
    // This object is needed to create the full screen, see full screen method
    private DisplayMode dm;
    // Needed in order to implement the full screen option
    private GraphicsDevice VideoCard;

    // game to be animated
    private ViewDataSource myViewDataSource;
    // current layout of the game
    private CanvasLayout myLayout = null;

    /**
     * Create a panel so that it knows its size
     */
    public Canvas (Dimension size) {
        // set size (a bit of a pain)
        setPreferredSize(size);
        setSize(size);
        // Get our graphics environment
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        // Get access to graphics card
        VideoCard = environment.getDefaultScreenDevice();
        // prepare to receive input
        setFocusable(true);
        requestFocus();
    }
    
    /**
     * Sets the data source from the controller.
     * @param data
     */
    public void setViewDataSource (ViewDataSource data) {
        myViewDataSource = data;
    }
    
    /**
     * Sets up the layout of the view. Null implies no layout.
     * @param layout
     */
    public void setLayout (CanvasLayout layout) {
        myLayout = layout;
    }
    
    /**
     * Calls java's repaint method.
     */
    public void paint() {
        repaint();
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
    public void paintComponent (Graphics pen) {
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, getSize().width, getSize().height);
        // first time needs to be special cased :(
        if (myLayout == null) {
            for (int i = 0; i < myViewDataSource.ObjectNumber(); i++) {
                myViewDataSource.getPaintable(i).paint((Graphics2D) pen,
                                                 myViewDataSource.getLocation(i),
                                                 myViewDataSource.getSize(i));
            }
        }
        else {
            myLayout.paintComponents(pen, myViewDataSource, this.getSize());
        }
    }
}
