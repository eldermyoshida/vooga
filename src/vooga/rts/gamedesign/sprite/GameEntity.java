package vooga.rts.gamedesign.sprite;

import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import vooga.rts.util.ThreeDimension;
import vooga.rts.util.Vector;


/**
 * This class represents Sprites that can be attacked (have health value),
 * can move (have velocity value), and is belonged to a certain team (have
 * team ID).
 *
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 *
 */
public class GameEntity extends GameSprite {
    private Vector myVelocity;
    private Sound mySound;
    
    private int myTeamID;
    
    private Vector myOriginalVelocity;
    
    public GameEntity (Pixmap image, Location center, ThreeDimension size, int teamID) {
        super(image, center, size);
        myTeamID = teamID;
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
     * Returns the teamID the shape belongs to.
     */
    public int getTeamID(){
    	return myTeamID;
    }
    
    /**
     * Rotates the Unit by the given angle. 
     * @param angle
     */
    public void turn(double angle){
        myVelocity.turn(angle);
    }
    /**
     * Translates the current center by vector v
     * @param v
     */
    public void translate(Vector v){
    	getCenter().translate(v);
    }
    
    /**
     * Reset shape back to its original values.
     */
    @Override
    public void reset () {
        super.reset();
        myVelocity = new Vector(myOriginalVelocity);
    }
    
    /**
     * Updates the shape's location.
     */
    //TODO: make Velocity three dimensional...
    public void update (double elapsedTime) {
    	if(!isVisible()) return;
        Vector v = new Vector(myVelocity);
        v.scale(elapsedTime);
        translate(v);
    }
    
}
