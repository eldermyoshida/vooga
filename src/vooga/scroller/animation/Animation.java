package vooga.scroller.animation;

import java.awt.Dimension;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;


public class Animation extends Sprite{

    private static final Pixmap STAND_RIGHT = new Pixmap("StandR.gif");
    private static final Pixmap STAND_LEFT = new Pixmap("StandL.gif");
    private static final Pixmap DUCK_RIGHT = new Pixmap("DuckR.gif");
    private static final Pixmap DUCK_LEFT = new Pixmap("DuckL.gif");
    private static final Pixmap WALK_RIGHT = new Pixmap("WalkR.gif");
    private static final Pixmap WALK_LEFT = new Pixmap("WalkL.gif");
    private static final Pixmap RUN_RIGHT = new Pixmap("RunR.gif");
    private static final Pixmap RUN_LEFT = new Pixmap("RunL.gif");
    private static final Pixmap JUMP_RIGHT = new Pixmap("JumpR.gif");
    private static final Pixmap JUMP_LEFT = new Pixmap("JumpL.gif");
    
    private Location myLastLocation;
    
    public Animation (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
        myLastLocation = new Location(0,0);
    }
    
    @Override
    public void update(double elapsedTime, Dimension bounds) {
        myLastLocation = this.getCenter();
        super.update(elapsedTime, bounds);
    }
    
    public Location lastLocation() {
        return myLastLocation;
    }


}
