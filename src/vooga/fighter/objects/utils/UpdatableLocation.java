package vooga.fighter.objects.utils;

import java.awt.geom.Point2D;
import java.util.Stack;
import util.Location;
import util.Vector;

/**
 * Represents a location that can take in acceleration forces and resolve them
 * in an update method.
 * @author james
 *
 */
public class UpdatableLocation extends Location {

    private Point2D.Double myCoordinates;
    private Stack<Vector> myAccelerations;
    private Vector myVelocity;
    
    /**
     * Constructs a new updatable location at coordinates (0,0).
     */
    public UpdatableLocation() {
        this(0, 0);
    }
    
    /**
     * Constructs a new updatable location at the given coordinates.
     */
    public UpdatableLocation(double x, double y) {
        myCoordinates = new Point2D.Double(x, y);
        myAccelerations = new Stack<Vector>();
        myVelocity = new Vector();
    }
    
    /**
     * Adds an acceleration force to the list of accelerations.
     */
    public void addAcceleration(Vector v) {
        myAccelerations.add(v);
    }
    
    /**
     * Clears the list of acceleration forces.
     */
    public void clearAccelerations() {
        myAccelerations.clear();
    }
    
    public void update() {
        while (!myAccelerations.isEmpty()) {
            Vector acceleration = myAccelerations.pop();
            myVelocity.sum(acceleration);
        }
        Vector v = new Vector(myVelocity);
        translate(v);
    }    
    
    /**
     * Moves this location according to a given vector.
     */
    public void translate(Vector v) {
        double x = myCoordinates.getX();
        double y = myCoordinates.getY();
        myCoordinates.setLocation(x + v.getXChange(), y + v.getYChange());        
    }

    /**
     * Sets the velocity for this updatable location.
     */
    public void setVelocity(double angle, double magnitude) {
        myVelocity = new Vector(angle, magnitude);
    }
    
    /**
     * Returns the velocity for this updatable location.
     */
    public Vector getVelocity() {
        return myVelocity;
    }
    
}
