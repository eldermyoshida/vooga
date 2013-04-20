package vooga.scroller.sprites.movement;

import util.Vector;
import vooga.scroller.sprites.superclasses.NonStaticEntity;
import vooga.scroller.sprites.superclasses.Player;

public class UpAndDown extends Movement {

    private NonStaticEntity myEntity;
    
    public UpAndDown (NonStaticEntity nse) {
        super(nse);
        myEntity = nse;
    }

    @Override
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
        return handlePlatformMovements(myEntity.getTop(), myEntity.getBottom(), top, bottom, speed);
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
