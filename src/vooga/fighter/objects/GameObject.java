package vooga.fighter.objects;
import vooga.fighter.util.Pixmap;
import vooga.fighter.util.Location;
import vooga.fighter.util.Vector;

import java.awt.Dimension; 
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

public class GameObject {
	private static final int DEFAULT_HEALTH=10;
	
	private Pixmap myImage;
	private Location myCenter;
	private Dimension mySize;  
	private Vector myVelocity;
    private Location myOriginalCenter;
    private Vector myOriginalVelocity;
    private Dimension myOriginalSize;
    private Pixmap myOriginalImage;
    private Rectangle myBounds;
    private int myHealth= DEFAULT_HEALTH;  
    
	public GameObject(Pixmap image, Location center, Dimension size){
		this(image, center, size, new Vector());
	}
	
	 public GameObject (Pixmap image, Location center, Dimension size, Vector velocity) {
	        // make copies just to be sure no one else has access
	        myOriginalCenter = new Location(center);
	        myOriginalSize = new Dimension(size);
	        myOriginalVelocity = new Vector(velocity);
	        myOriginalImage = new Pixmap(image);
	        reset();
	        resetBounds();
	 }
	   /**
     * Describes how to "animate" the shape by changing its state.
     * 
     * Currently, moves by the current velocity.
     */
    public void update (double elapsedTime, Dimension bounds) {
        
		// do not change original velocity
        Vector v = new Vector(myVelocity);
        v.scale(elapsedTime);
        translate(v);
    }

    /**
     * Moves shape's center by given vector.
     */
    public void translate (Vector v) {
        myCenter.translate(v);
        resetBounds();
    }

    /**
     * Resets shape's center.
     */
    public void setCenter (double x, double y) {
        myCenter.setLocation(x, y);
        resetBounds();
    }

    /**
     * Returns shape's x coordinate in pixels.
     */
    public double getX () {
        return myCenter.getX();
    }

    /**
     * Returns shape's y-coordinate in pixels.
     */
    public double getY () {
        return myCenter.getY();
    }

    /**
     * Returns shape's left-most coordinate in pixels.
     */
    public double getLeft () {
        return myCenter.getX() - mySize.width / 2;
    }

    /**
     * Returns shape's top-most coordinate in pixels.
     */
    public double getTop () {
        return myCenter.getY() - mySize.height / 2;
    }

    /**
     * Returns shape's right-most coordinate in pixels.
     */
    public double getRight () {
        return myCenter.getX() + mySize.width / 2;
    }

    /**
     * Returns shape's bottom-most coordinate in pixels.
     */
    public double getBottom () {
        return myCenter.getY() + mySize.height / 2;
    }

    /**
     * Returns shape's width in pixels.
     */
    public double getWidth () {
        return mySize.getWidth();
    }

    /**
     * Returns shape's height  in pixels.
     */
    public double getHeight () {
        return mySize.getHeight();
    }

    /**
     * Scales shape's size by the given factors.
     */
    public void scale (double widthFactor, double heightFactor) {
        mySize.setSize(mySize.width * widthFactor, mySize.height * heightFactor);
        resetBounds();
    }

    /**
     * Resets shape's size.
     */
    public void setSize (int width, int height) {
        mySize.setSize(width, height);
        resetBounds();
    }

    /**
     * Returns shape's velocity.
     */
    public Vector getVelocity () {
        return myVelocity;
    }

    /**
     * Resets shape's velocity.
     */
    public void setVelocity (double angle, double magnitude) {
        myVelocity = new Vector(angle, magnitude);
    }
    

    /**
     * Resets shape's image.
     */
    public void setView (Pixmap image) {
        if (image != null) {
            myImage = image;
        }
    }

    /**
     * Returns rectangle that encloses this shape.
     */
    public Rectangle getBounds () {
        return myBounds;
    }

    /**
     * Returns true if the given point is within a rectangle representing this shape.
     */
    public boolean intersects (GameObject other) {
        return getBounds().intersects(other.getBounds());
    }

    /**
     * Returns true if the given point is within a rectangle representing this shape.
     */
    public boolean intersects (Point2D pt) {
        return getBounds().contains(pt);
    }

    /**
     * Reset shape back to its original values.
     */
    public void reset () {
        myCenter = new Location(myOriginalCenter);
        mySize = new Dimension(myOriginalSize);
        myVelocity = new Vector(myOriginalVelocity);
        myImage = new Pixmap(myOriginalImage);
    }
    
    public Location getOriginalCenterLocation() {
    	return new Location(myOriginalCenter);
    }
	
    

    /**
     * Display this shape on the screen.
     */
    public void paint (Graphics2D pen)
    {
        myImage.paint(pen, myCenter, mySize);
    }

    /**
     * Returns rectangle that encloses this shape.
     */
    protected void resetBounds () {
        myBounds = new Rectangle((int)getLeft(), (int)getTop(), mySize.width, mySize.height);
    }

	public void reduceHealth(int amount){
		myHealth-=amount; 
	}
	
	public int getHealth() {
		return myHealth;
	}
	
	public void setHealth(int amount){
		myHealth=amount; 
	}
}
