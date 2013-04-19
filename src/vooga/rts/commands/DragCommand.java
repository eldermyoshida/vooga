package vooga.rts.commands;

import java.awt.geom.Rectangle2D;

/**
 * Extension of Command which contains the size of the area that is dragged over
 * when the mouse is clicked and dragged
 * 
 * @author Challen Herzberg-Brovold
 * 
 */
public class DragCommand extends Command {
    
    public Rectangle2D myRectangle;
    
    public DragCommand (String inputName, Rectangle2D rectangle) {
        super(inputName);
        myRectangle = rectangle;
    }
    
    public Rectangle2D getRectangle () {
        return myRectangle;
    }
}
