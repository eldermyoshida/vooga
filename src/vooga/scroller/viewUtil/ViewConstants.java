package vooga.scroller.viewUtil;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * Class holding keyword strings for the view package
 * @author Ross
 *
 */
public class ViewConstants {
    
    /**
     * The size for Window objects
     */
    public static final Dimension DEFAULT_WINDOW_SIZE = new Dimension(1200, 800);

    /**
     * The size for TabView objects
     */
    public static final Dimension DEFAULT_TAB_SIZE = new Dimension(800, 800);

    /**
     * The size for FeedBackView objects
     */
    public static final Dimension DEFAULT_FEEDBACK_SIZE = new Dimension(800, 100);
    
    /**
     * The size for ConsoleView objects
     */
    public static final Dimension DEFAULT_CONSOLE_SIZE = new Dimension(500, 700);
    /**
     * The size for RoomView objects
     */
    public static final Dimension DEFAULT_ROOM_SIZE = new Dimension(700, 500);
    /**
     * The border size for views
     */
    public static final Border DEFAULT_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    
    /**
     * The size of the dialog box
     */
    public static final Dimension DEFAULT_PEN_OPTIONS_VIEW_SIZE = new Dimension(300, 150);
    
    /**
     * Added to fully prevent instantiation of this utility class.
     */
    private ViewConstants() {
        
    }

}
