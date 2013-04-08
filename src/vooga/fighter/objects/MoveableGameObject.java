package vooga.fighter.objects;

import java.awt.Dimension;
import java.awt.Rectangle;

import vooga.fighter.util.Location;
import vooga.fighter.util.Pixmap;
import vooga.fighter.util.Vector;

/**
 * 
 * @author alanni
 * Objects that can be moved 
 */
public class MoveableGameObject extends GameObject{
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
    private int myPriority;   
    
    public void update (double elapsedTime, Dimension bounds) {
		// do not change original velocity
        Vector v = new Vector(myVelocity);
        v.scale(elapsedTime);
        translate(v);
    }

	public MoveableGameObject(Pixmap image, Location center, Dimension size, Vector velocity) {
		super(image, center, size, velocity);
	}
	
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
	
    /**
     * Moves shape's center by given vector.
     */
    public void translate (Vector v) {
        myCenter.translate(v);
    }

}
