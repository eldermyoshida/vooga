package vooga.scroller.sprites.animation;

import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

/**
 * Represents the left moving and standing of a sprite.
 * 
 * @author Scott Valentine
 *
 */
public class MoveLeft extends AnimationState {

    private static final double MOVEMENT_BUFFER_VALUE = -.2;
    
    private Pixmap myStand;
    
    

    /**
     * Constructor that builds the animation state based on the images for moving left 
     * and standing left.
     * 
     * 
     * @param moveImage is the Pixmap that represents the sprite moving left.
     * @param standImage is the Pixmap that represents the sprite moving right.
     */
    public MoveLeft (Pixmap moveImage, Pixmap standImage) {
        super(moveImage);
        myStand = standImage;
    }

    
    
    
    @Override
    public boolean validAnimation (Sprite unit) {
        if (unit.getCenter().x - unit.lastLocation().x < MOVEMENT_BUFFER_VALUE) {            
            unit.getView().setDefaultView(myStand);
            return true;
        }
        return false;
    }


    @Override
    public void update () {
        // In this case this does nothing.       
    }
}


