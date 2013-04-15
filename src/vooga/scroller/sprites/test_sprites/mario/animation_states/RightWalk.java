package vooga.scroller.sprites.test_sprites.mario.animation_states;

import vooga.scroller.sprites.animation.AnimationState;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

public class RightWalk extends AnimationState {
    public static final Pixmap RIGHT = new Pixmap("mario_right.png");

    public RightWalk () {
        super(RIGHT);
    }

    @Override
    public boolean validAnimation (Sprite unit) {
        return unit.lastLocation().x - unit.getCenter().x < -1;
    }

}
