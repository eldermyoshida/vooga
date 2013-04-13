package vooga.fighter.objects;

import vooga.fighter.objects.utils.Hitbox;
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
    
    private long myInstanceId;
    private long myObjectId;
    private Pixmap myImage;
    private Location myCenter;
    private Hitbox myHitbox;    
    private Dimension mySize;

    /**
     * Constructs a new GameObject with the given image, center, and size.
     * 
     * Note: Dayvid, once the loader is fully functional we will modify this to
     * only take in an object ID, and we will load the parameters from the XML.
     */
    public GameObject(long instanceId) {
        myInstanceId=instanceId;        
    }
    
    /**
     * Returns the game object's instance id. This id is unique to this particular
     * instantiation of the object.
     */
    public long getInstanceId() {
        return myInstanceId;
    }
    
    /**
     * Returns the game object's object id. This id is unique to the type of object
     * this instance represents.
     */
    public long getObjectId() {
        return myObjectId;
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
    public void setHitbox(Hitbox hitbox) {
        myHitbox = hitbox;
    }

    /**
     * Returns the hitbox for this game object.
     */
    public Hitbox getHitbox() {
        return myHitbox;
    }

    /**
     * Returns true if this object collides with another object.
     */
    public boolean collidesWith(GameObject other) {
        return getHitbox().getCurrentRectangle().intersects(other.getHitbox().getCurrentRectangle());
    }
    
}
