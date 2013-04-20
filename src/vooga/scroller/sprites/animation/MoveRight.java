package vooga.scroller.sprites.animation;

import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

/**
 * Represents the right movement and right standing of a sprite.
 * 
 * @author Scott Valentine
 *
 */
public class MoveRight extends AnimationState {

    private static final double MOVEMENT_BUFFER_VALUE = .2;

    
    private Pixmap myStand;

    /**
     * Builds this animation state based on the minimal amount of Pixmaps needed to display states.
     * 
     * @param moveImage is the Pixmap that represents the sprite moving right.
     * @param standImage is the Pixmap that represents the sprite standing facing right.
     */
    public MoveRight (Pixmap moveImage, Pixmap standImage) {
        super(moveImage);
        myStand = standImage;
    }

    @Override
    public boolean validAnimation (Sprite unit) {
        if (unit.getCenter().x - unit.lastLocation().x > MOVEMENT_BUFFER_VALUE) {            
            unit.getView().setDefaultView(myStand);
            return true;
        }
        return false;
    }

    @Override
    public void update () {
        // this does nothing in this class        
    }

}
