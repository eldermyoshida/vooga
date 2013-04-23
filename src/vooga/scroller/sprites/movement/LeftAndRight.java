package vooga.scroller.sprites.movement;

import util.Vector;
import vooga.scroller.sprites.superclasses.NonStaticEntity;

/**
 * This is a type of Movement that moves a NonStaticEntity from the left to right. All 
 * you need to do is specify the left bounds, right bounds, and the speed. A canonical 
 * example that uses this kind of movement would be a platform that moves from left to 
 * right. 
 * <br>
 * <br>
 * However, if you do decide to use this kind of movement, you must instantiate your 
 * sprite within the left and right bounds. 
 * 
 * @author Jay Wang
 *
 */
public class LeftAndRight extends Movement {

    private NonStaticEntity myEntity;
    private MovementHelper helper;
    
    public LeftAndRight (NonStaticEntity nse) {
        super();
        myEntity = nse;
        helper = new MovementHelper(myEntity);
    }

    /**
     * This method will only work if the X coordinate of moving platform is 
     * instantiated somewhere between LEFT and RIGHT. You can't create a moving platform 
     * outside the bounds of LEFT and RIGHT. Likewise, you therefore cannot give LEFT 
     * and RIGHT bounds that do not encapsulate where your moving platform is instantiated. 
     * <br>
     * <br>
     * Essentially, the implementation for this method mirrors the upAndDown() method.
     * 
     * @param left
     * @param right
     * @param speed
     * @return a vector in the LEFT or RIGHT direction with given SPEED
     */
    public Vector execute (int left, int right, int speed) {
        return helper.handlePlatformMovements(myEntity.getLeft(), myEntity.getRight(), left, right, speed);
    }

}
