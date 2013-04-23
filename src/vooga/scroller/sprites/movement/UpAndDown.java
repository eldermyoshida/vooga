package vooga.scroller.sprites.movement;

import util.Vector;
import vooga.scroller.util.Sprite;

/**
 * This is a type of Movement that moves a NonStaticEntity up to down. All 
 * you need to do is specify the top bounds, bottom bounds, and the speed. A canonical 
 * example that uses this kind of movement would be a platform that moves from up to 
 * down. 
 * <br>
 * <br>
 * However, if you do decide to use this kind of movement, you must instantiate your 
 * sprite within the top and bottom bounds. 
 * 
 * @author Jay Wang
 *
 */
public class UpAndDown extends Movement {

    private Sprite myEntity;
    private MovementHelper helper;

    
    public UpAndDown (Sprite nse) {
        super();
        myEntity = nse;
        helper = new MovementHelper(myEntity);
    }

    /**
     * This method will only work if the Y coordinate of moving platform is 
     * instantiated somewhere between TOP and BOTTOM. You can't create a moving platform 
     * outside the bounds of TOP and BOTTOM. Likewise, you therefore cannot give TOP 
     * and BOTTOM bounds that do not encapsulate where your moving platform is instantiated. 
     * 
     * @param top
     * @param bottom
     * @param speed
     * @return a vector in the UP or DOWN direction with given SPEED
     */
    public Vector execute (int top, int bottom, int speed) {
        return helper.handlePlatformMovements(myEntity.getTop(), myEntity.getBottom(), top, bottom, speed);
    }

}
