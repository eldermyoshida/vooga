package vooga.scroller.sprites.test_sprites.mario.animation_states;

import vooga.scroller.sprites.animation.AnimationState;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

public class RightStand extends AnimationState {

    private static final Pixmap RIGHT_STAND = new Pixmap("llama_stand_right.gif");

    private boolean myFacingLeft;
    
    public RightStand () {
        super(RIGHT_STAND);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean validAnimation (Sprite unit) {
        if (unit.lastLocation().x - unit.getCenter().x < 0 && unit.getVelocity().getComponentVector(Sprite.RIGHT_DIRECTION).getMagnitude() < .2){
            myFacingLeft = true;
        }
        
        if(unit.getVelocity().getComponentVector(Sprite.RIGHT_DIRECTION).getMagnitude() >= 1|| 
                unit.getVelocity().getComponentVector(Sprite.LEFT_DIRECTION).getMagnitude() >= 1){
            myFacingLeft = false;
        }
        
        return myFacingLeft;
    }

}
