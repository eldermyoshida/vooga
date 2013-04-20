package util;

import java.awt.geom.Point2D;

/**
 * Extension of vector to provide location of the vector for use
 * in physics calculations.
 * 
 * @author Wayne You
 *
 */
public class Velocity extends Vector {
    //public static instance variables defining degrees for directions
    public static final int DEGREES_RIGHT = 0;
    public static final int DEGREES_DOWN = 90;
    public static final int DEGREES_LEFT = 180;
    public static final int DEGREES_UP = 270;
    
    //Location variables
    private double myX = 0;
    private double myY = 0;
    
    /**
     * Create a new vector based on magnitude and direction with base at a point (x,y)
     * @param x X location of the base of the vector.
     * @param y Y location of the base of the vector.
     * @param angle Angle the vector points in.
     * @param magnitude Magnitude of the vector.
     */
    public Velocity (double x, double y, double angle, double magnitude) {
        super(angle, magnitude);
        myX = x;
        myY = y;
    }
    
    /**
     * Create a vector whose direction and magnitude are determined by
     * direction and distance between the two given points and whose
     * location is the source point.
     */
    public Velocity (Point2D source, Point2D target) {
        super(angleBetween(target, source), distanceBetween(target, source));
        myX = source.getX();
        myY = source.getY();
    }
    
    /**
     * Create a vector that is identical to the given other vector.
     */
    public Velocity (Velocity other) {
        this(other.getX(), other.getY(), other.getDirection(), other.getMagnitude());
    }
    
    /**
     * Generates a velocity with the origin point at (0,0)
     * @param vec A directional vector.
     */
    public Velocity (Vector vec) {
        this(0,0,vec.getDirection(),vec.getMagnitude());
    }
    
    /**
     * @return The x coordinate of the origin of the vector
     */
    public double getX () {
        return myX;
    }
    
    /**
     * @return The y coordinate of the origin of the vector
     */
    public double getY () {
        return myY;
    }
    
    /**
     * Translates the origin of the vector
     * @param dx The amount to shift in the x direction
     * @param dy The amount to shift in the y direction 
     */
    public void translate (double dx, double dy) {
        myX += dx;
        myY += dy;
    }
    
    @Override
    public Velocity clone () {
        return new Velocity(this);
    }
    
    public double getLocationDotProduct (Velocity other) {
        return myX * other.getX() + myY * other.getY();
    }
    
    public void setVector (double dX, double dY) {
        setMagnitude(Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2)));
        setDirection(Math.atan2(dX, dY));
    }
}
