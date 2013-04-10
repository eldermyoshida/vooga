package vooga.rts.util;

import java.awt.Point;
import java.awt.geom.Point2D;

public class Location3D {
    
    private double myX;
    private double myY;
    private double myZ;

    
    /**
     * Create a Location3D at the origin.
     */
    public Location3D () {
        this(0.0, 0.0, 0.0);
    }

    /**
     * Creates a Location3D with the specified co-ordinates.
     * 
     * @param x The X value
     * @param y The Y value
     * @param z The Z value
     */
    public Location3D (double x, double y, double z) {
        myX = x;
        myY = y;
        myZ = z;
    }

    /**
     * Creates a Location3D with the specified Point 2D and 
     * sets the Z value to 0.
     *  
     * @param source The Point2D to copy from.
     */
    public Location3D (Point2D source) {        
        this(source.getX(), source.getY(), 0);
    }
    
    /**
     * Creates a Location3D with the same values as the specified parameter.
     *  
     * @param source The Location3D to copy from.
     */
    public Location3D (Location3D source) {        
        this(source.getX(), source.getY(), 0);
    }

    /**
     * Reset this location to origin.
     */
    public void reset () {
        setLocation(0, 0);
    }

    /**
     * Move this location by given vector.
     * 
     * @see java.awt.Point#translate(int, int)
     */
    public void translate (Vector amount) {
        setLocation(getX() + amount.getXChange(), getY() + amount.getYChange());
    }

    /**
     * Returns a vector that is the difference between this location and
     * the given other location.
     */
    public Vector difference (Point2D other) {        
        return new Vector(this, other);
    }
    
    public void setLocation(double X, double Y, double Z) {
        myX = X;
        myY = Y;
        myZ = Z;
    }
    
    public void add(Location3D add) {
        myX += add.getX();
        myY += add.getY();
        myZ += add.getZ();
    }

    /**
     * @return the X Coordinate
     */
    public double getX () {
        return myX;
    }

    /**
     * @return the Y Coordinate
     */
    public double getY () {
        return myY;
    }

    /**
     * @return the Z Coordinate
     */
    public double getZ () {
        return myZ;
    }
}
