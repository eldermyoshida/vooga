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
        // TODO Auto-generated constructor stub
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
    @Override
    public void update (double elapsedTime) {
        // TODO Auto-generated method stub

    }

}
