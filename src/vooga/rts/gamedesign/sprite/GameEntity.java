package vooga.rts.gamedesign.sprite;

import java.awt.Dimension;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import vooga.rts.util.Vector;

public class GameEntity extends GameSprite {
    private Vector myVelocity;
    private Sound mySound;
    
    private Vector myOriginalVelocity;
    
    public GameEntity (Pixmap image, Location center, Dimension size) {
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
     * Translates the current center by vector v
     * @param v
     */
    public void translate(Vector v){
    	getCenter().translate(v);
    }
    
    /**
     * Updates the GameEntity. 
     */
    @Override
    public void update (double elapsedTime) {
    	if(!isVisible()) return;
        Vector v = new Vector(myVelocity);
        v.scale(elapsedTime);
        translate(v);
        resetBounds();
    }

}
