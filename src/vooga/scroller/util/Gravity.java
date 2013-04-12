package vooga.scroller.util;

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
    private static final double GRAVITY_CONSTANT = -6;

    private Vector gravityVector;
    
    public Gravity (Sprite sprite) {
        this.sprite = sprite;
        groundLoc = (PlatformerConstants.DEFAULT_WINDOW_SIZE.height) - DISTANCE_OFF_GROUND;
        gravityVector = new Vector(270, GRAVITY_CONSTANT);
    }
    
    public void applyGravity() {
        if (sprite.getBottom() < groundLoc) {
            sprite.translate(gravityVector);
        }
    }
}
