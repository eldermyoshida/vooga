package vooga.scroller.sprites.test_sprites.pikachu.animation_states;

import vooga.scroller.sprites.animation.AnimationState;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

public class LeftStand extends AnimationState {

    private static final Pixmap LEFT_STAND = new Pixmap("llama_still.gif");

    private boolean myFacingLeft;
    
    public LeftStand () {
        super(LEFT_STAND);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean validAnimation (Sprite unit) {

        
        if(unit.getVelocity().getComponentVector(Sprite.RIGHT_DIRECTION).getMagnitude() >= 5|| 
                unit.getVelocity().getComponentVector(Sprite.LEFT_DIRECTION).getMagnitude() >= 5){
            myFacingLeft = false;
        }
        if (unit.lastLocation().x - unit.getCenter().x > .3){ 
            myFacingLeft = true;
        }
        
        return myFacingLeft;
    }

}
