package vooga.scroller.sprites.movement;

import util.Vector;
import vooga.scroller.sprites.superclasses.NonStaticEntity;
import vooga.scroller.sprites.superclasses.Player;

public class LeftAndRight extends Movement {

    private NonStaticEntity myEntity;
    public LeftAndRight (NonStaticEntity nse) {
        super(nse);
        myEntity = nse;
    }

    @Override
    /**
     * This method will only work if the X coordinate of moving platform is 
     * instantiated somewhere between LEFT and RIGHT. You can't create a moving platform 
     * outside the bounds of LEFT and RIGHT. Likewise, you therefore cannot give LEFT 
     * and RIGHT bounds that do not encapsulate where your moving platform is instantiated. 
     * 
     * Essentially, the implementation for this method mirrors the upAndDown() method.
     * 
     * @param left
     * @param right
     * @param speed
     * @return a vector in the LEFT or RIGHT direction with given SPEED
     */
    public Vector execute (int left, int right, int speed) {
        return handlePlatformMovements(myEntity.getLeft(), myEntity.getRight(), left, right, speed);
    }

    @Override
    public Vector execute () {
        return null;
    }


    @Override
    public Vector execute (int speed, int radius, Player myPlayer) {
        return null;
    }



    
    

}
