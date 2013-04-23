package vooga.scroller.sprites.movement;

import util.Vector;
import vooga.scroller.sprites.superclasses.NonStaticEntity;
import vooga.scroller.sprites.superclasses.Player;

/**
 * Abstract superclass using the strategy design pattern. Every movement of 
 * a NonStaticEntity will extend Movement. Thus, each NonStaticEntity only needs 
 * an instance of the Movement they want. They can then call execute on their 
 * Movement object to get the vector they need. 
 * 
 * @author Jay Wang
 *
 */
public abstract class Movement {

    protected NonStaticEntity myEntity;
    
    public Movement (NonStaticEntity nse) {
        myEntity = nse;
    }
    
    public Vector execute () {
        return null;
    }
    public Vector execute (int bounds1, int bounds2, int speed) {
        return null;
    }
    public Vector execute (int speed, int radius, Player myPlayer) {
        return null;
    }

    
    /*
     * HELPER FUNCTIONS TO USE IN BUILDING YOUR PERSONAL MOVEMENTS ---------------------------------------------
     */
    protected Vector handlePlatformMovements (double position1, double position2, int bounds1, int bounds2, int speed) {
        
        if (position1 < bounds1) {
            if (position2 < bounds2) { //this line may need to be adjusted by a size of this.getHeight()
                myEntity.getVelocity().turn(180);
                return myEntity.getVelocity();
            }
            myEntity.getVelocity();
        }
        
        if (position2 > bounds2) {
            if (position1 > bounds1) { //this line may need to be adjusted by a size of this.getHeight()
                myEntity.getVelocity().turn(180);
                return myEntity.getVelocity();
            }
            myEntity.getVelocity();
        }
        
        if (position1 < (bounds1 - myEntity.getHeight()) || position2 > (bounds2 + myEntity.getHeight())) {
            System.err.println("ERROR: Cannot give moving platform bounds that do not encapsulate its instantiated (X,Y) position.");
            return null;
        }      
        return myEntity.getVelocity();
    }
}
