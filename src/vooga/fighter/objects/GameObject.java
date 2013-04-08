package vooga.fighter.objects;

import vooga.fighter.util.Pixmap;
import vooga.fighter.util.Location;
import vooga.fighter.util.Vector;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;


/**
 * Represents a single object in the game.
 * 
 * @author james, alanni
 * 
 */
public abstract class GameObject {
    
    private long myId;
    private Pixmap myImage;
    private Location myCenter;
    private Rectangle myHitbox;
    
    private Dimension mySize;
    
    private Location myOriginalCenter;
    private Pixmap myOriginalImage;

    public GameObject(Pixmap image, Location center, Dimension size) {
        this(image, center, size, new Vector());       
    }

    public GameObject(Pixmap image, Location center, Dimension size, Vector velocity) {
        // make copies just to be sure no one else has access
        myOriginalCenter = new Location(center);
        myOriginalImage = new Pixmap(image);
        mySize = size;
        reset();
    }
    
    /**
     * Returns the game object's id.
     */
    public long getId() {
        return myId;
    }
    
    /**
     * Sets game object's image.
     */
    public void setImage(Pixmap image) {
        if (image != null) {
            myImage = image;
        }
    }
    
    /**
     * Returns the game object's image.
     */
    public Pixmap getImage() {
        return myImage;
    }

    /**
     * Sets game object's center.
     */
    public void setCenter(double x, double y) {
        myCenter.setLocation(x, y);
    }

    /**
     * Returns game object's center.
     */
    public Location getCenter() {
        return myCenter;
    }
    
    /**
     * Sets the hitbox for this game object.
     */
    public void setHitbox(Rectangle hitbox) {
        myHitbox = hitbox;
    }

    /**
     * Returns the hitbox for this game object.
     */
    public Rectangle getHitbox() {
        return myHitbox;
    }
    
    /**
     * Returns the original image of the game object.
     */
    public Location getOriginalImage() {
        return new Location(myOriginalCenter);
    }
    
    /**
     * Returns the original center of the game object.
     */
    public Location getOriginalCenter() {
        return new Location(myOriginalCenter);
    }

    /**
     * Reset shape back to its original values.
     */
    public void reset() {
        myCenter = new Location(myOriginalCenter);
        myImage = new Pixmap(myOriginalImage);
    }    

    /**
     * Returns true if the given point is within a rectangle representing this shape.
     */
    public boolean intersects(GameObject other) {
        return getHitbox().intersects(other.getHitbox());
    }

    /**
     * Returns true if the given point is within a rectangle representing this shape.
     */
    public boolean intersects(Point2D pt) {
        return getHitbox().contains(pt);
    }
    
    /**
     * Paints the object. This will be deleted.
     */
    public void paint(Graphics2D pen) {
        myImage.paint(pen, myCenter, mySize);
    }
    
}
