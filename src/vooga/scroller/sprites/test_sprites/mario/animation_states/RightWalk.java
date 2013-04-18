package vooga.scroller.sprites.test_sprites.mario.animation_states;

import vooga.scroller.sprites.animation.AnimationState;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

public class RightWalk extends AnimationState {
    public static final Pixmap RIGHT = new Pixmap("runright.gif");
    private static final Pixmap RIGHT_STAND = new Pixmap("standright.png");

    public RightWalk () {
        super(RIGHT);
    }

    @Override
    public boolean validAnimation (Sprite unit) {
        if(unit.lastLocation().x - unit.getCenter().x < -.5){
            unit.getView().setDefaultView(RIGHT_STAND);
            return true;
        }
        return false;
        //return unit.lastLocation().x - unit.getCenter().x < -.5;
    }

}
