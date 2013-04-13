package vooga.rts.util;

import java.awt.geom.Point2D;


public class Vector3D {

    // Components of the Vector
    private double myX;
    private double myY;
    private double myZ;
    
    private double myMagnitude;

    /**
     * Creates a Vector from the origin to the provided point
     * 
     * @param x X position
     * @param y Y position
     * @param z Z position
     */
    public Vector3D (double x, double y, double z) {
        myX = x;
        myY = y;
        myZ = z;
        calculateMagnitude();
    }

    /**
     * Creates a Vector from the origin to the provided point
     * 
     * @param end
     */
    public Vector3D (Location3D end) {
        this(end.getX(), end.getY(), end.getZ());
    }

    /**
     * Creates a Vector that represents the difference between
     * the two Locations provided.
     * 
     * @param start The start location
     * @param end The end location
     */
    public Vector3D (Location3D start, Location3D end) {
        this(end.getX() - start.getX(), end.getY() - start.getY(), end.getZ() - start.getZ());
    }

    public double getMagnitude () {
        return myMagnitude;
    }
    
    public void setX(double x) {
        myX = x;
        calculateMagnitude();
    }
    
    public void setY(double y) {
        myY = y;
        calculateMagnitude();
    }
    
    public void setZ(double z) {
        myZ = z;
        calculateMagnitude();
    }
    
    private void calculateMagnitude() {
        myMagnitude = Math.sqrt(myX * myX + myY * myY + myZ * myZ);
    }

}
