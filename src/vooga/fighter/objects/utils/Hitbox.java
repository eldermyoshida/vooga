package vooga.fighter.objects.utils;

import java.awt.Rectangle;
import vooga.fighter.objects.GameObject;

/**
 * Holds a series of rectangles representing hitboxes for an object. Used for
 * collision detection and handling.
 * 
 * @author james
 *
 */
public class Hitbox {

    private int myNumFrames;
    private int myCurrentFrame;
    private int myPriority;
    private Rectangle[] myRectangles;    
    private GameObject myOwner;    
    
    /**
     * Creates a hitbox with the given owner, number of frames, and default priority of zero.
     */
    public Hitbox(GameObject owner, int numFrames) {
        this(owner, numFrames, 0);
    }
    
    /**
     * Creates a hitbox with the given owner, number of frames, and priority.
     */
    public Hitbox(GameObject owner, int numFrames, int priority) {
        myOwner = owner;
        myNumFrames = numFrames;
        myPriority = priority;
        myRectangles = new Rectangle[myNumFrames];
    }    
    
    /**
     * Adds the rectangles for the hitboxes into this object's rectangle array.
     * 
     * Not yet implemented.
     * 
     * Note: Dayvid once you determine how you want the data from the XML file to be
     * loaded into a hitbox object we will tweak this method appropriately.
     */
    public void populateRectangles() {
        
    }
    
    /**
     * Returns the current active rectangle for this hitbox.
     */
    public Rectangle getCurrentRectangle() {
        return myRectangles[myCurrentFrame];
    }
    
    /**
     * Progresses this hitbox to the next frame in its animation.
     */
    public void progressNextRectangle() {
        myCurrentFrame++;
    }
    
    /**
     * Returns the priority of this hitbox. Lower numbers are considered higher priority.
     */
    public int getPriority() {
        return myPriority;
    }
    
    /**
     * Returns true if this hitbox has priority over another, or false otherwise.
     * Note that returning false DOES NOT necessarily indicate that the other
     * hitbox has priority, as the two could have equal priorities.
     */
    public boolean hasPriority(Hitbox other) {
        int difference = myPriority - other.getPriority();
        return (difference < 0);
    }
    
}
