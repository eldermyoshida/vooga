package vooga.scroller.util;

import util.Vector;

/**
 * This is how we want to handle gravity. Every sprite will have an instance of this 
 * gravity object. 
 * 
 * @author Jay Wang
 */

public class Gravity {

    Sprite sprite;
    private double groundLoc;
    private static final double DISTANCE_OFF_GROUND = 15;
    private static final double GRAVITY_CONSTANT = -2;

    private Vector gravityVector;
    
    public Gravity (Sprite sprite) {
        this.sprite = sprite;
        groundLoc = (PlatformerConstants.DEFAULT_WINDOW_SIZE.height) - DISTANCE_OFF_GROUND;
        gravityVector = new Vector(Sprite.UP_DIRECTION, GRAVITY_CONSTANT);
    }
    
    public void applyGravity() {
        sprite.addVector(gravityVector);
    }
}
