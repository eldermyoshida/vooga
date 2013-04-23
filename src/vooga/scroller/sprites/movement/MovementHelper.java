package vooga.scroller.sprites.movement;

import util.Vector;
import vooga.scroller.util.Sprite;

/**
 * This is a helper class where the game designer can store helper functions 
 * that specific movements may want to call. For example, LeftAndRight and 
 * UpAndDown both need to call the method - handlePlatformMovements. Rather than 
 * keep a copy of this method in both LeftAndRight and UpAndDown, I extracted it 
 * into it's own class. 
 * <br>
 * <br>
 * Not every Movement subclass will need an instance of the MovementHelper. Only the 
 * ones that have methods in this helper that they would like to call in their 
 * execute() methods need an instance of the helper. 
 * 
 * @author Jay Wang
 *
 */
public class MovementHelper {


    private static final String PLATFORM_BOUNDS_ERROR = "ERROR: Cannot give moving platform bounds " +
    		"that do not encapsulate its instantiated (X,Y) position.";
    
    
    private Sprite myEntity;
    
    public MovementHelper (Sprite nse) {
        myEntity = nse;
    }
    
    public Vector handlePlatformMovements (double position1, double position2, int bounds1, int bounds2, int speed) {
        
        if (position1 < bounds1) {
            if (position2 < bounds2) { 
                myEntity.getVelocity().turn(180);
                return myEntity.getVelocity();
            }
            myEntity.getVelocity();
        }
        
        if (position2 > bounds2) {
            if (position1 > bounds1) { 
                myEntity.getVelocity().turn(180);
                return myEntity.getVelocity();
            }
            myEntity.getVelocity();
        }
        
        if (position1 < (bounds1 - myEntity.getHeight()) || position2 > (bounds2 + myEntity.getHeight())) {
            return null;
        }      
        return myEntity.getVelocity();
    }
}
