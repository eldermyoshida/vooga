package vooga.fighter.objects;

import java.awt.Dimension;
import vooga.fighter.util.Location;
import vooga.fighter.util.Pixmap;
import vooga.fighter.util.Vector;


/**
 * Represents a game object that is moveable.
 * 
 * @author alanni, james
 * 
 */
public class MoveableGameObject extends GameObject {

    private Vector myVelocity;

    public MoveableGameObject(Pixmap image, Location center) {
        super(image, center);
        myVelocity = new Vector();
    }

    public void update(double elapsedTime, Dimension bounds) {
        Vector v = new Vector(myVelocity);
        v.scale(elapsedTime);
        translate(v);
    }

    /**
     * Moves the center for this moveable game object by a given vector.
     */
    public void translate(Vector v) {
        getCenter().translate(v);
    }


    /**
     * Sets the velocity for this moveable game object.
     */
    public void setVelocity(double angle, double magnitude) {
        myVelocity = new Vector(angle, magnitude);
    }
    
    /**
     * Returns the velocity for this moveable game object.
     */
    public Vector getVelocity() {
        return myVelocity;
    }

}
