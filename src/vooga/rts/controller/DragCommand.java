package vooga.rts.controller;

import java.awt.geom.Rectangle2D;

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
