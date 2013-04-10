package vooga.rts.gamedesign.sprite;

import java.awt.Dimension;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import vooga.rts.util.ThreeDimension;
import vooga.rts.util.Vector;

public class GameEntity extends GameSprite {
    private Vector myVelocity;
    private Sound mySound;
    
    private Vector myOriginalVelocity;
    
    public GameEntity (Pixmap image, Location center, ThreeDimension size) {
        super(image, center, size);
        
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
     * Rotates the Unit by the given angle. 
     * @param angle
     */
    public void turn(double angle){
        myVelocity.turn(angle);
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
        Vector v = new Vector(myVelocity);
        v.scale(elapsedTime);
        translate(v);
    }
    
    /**
     * Moves shape's center by given vector.
     */
    public void translate (Vector v) {
        getCenter().translate(v);
        resetBounds();
    }

}
