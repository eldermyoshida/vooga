package vooga.scroller.sprites.test_sprites.pikachu.animation_states;

import vooga.scroller.sprites.animation.AnimationState;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

public class RightStand extends AnimationState {

    private static final Pixmap RIGHT_STAND = new Pixmap("standright.png");

    private boolean myFacingLeft;
    
    public RightStand () {
        super(RIGHT_STAND);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean validAnimation (Sprite unit) {

        
        if(unit.getVelocity().getComponentVector(Sprite.RIGHT_DIRECTION).getMagnitude() >= 10|| 
                unit.getVelocity().getComponentVector(Sprite.LEFT_DIRECTION).getMagnitude() >= 10){
            myFacingLeft = false;
        }
        if (unit.lastLocation().x - unit.getCenter().x < -.3){ 
            myFacingLeft = true;
        }
        
        return myFacingLeft;
    }

}
