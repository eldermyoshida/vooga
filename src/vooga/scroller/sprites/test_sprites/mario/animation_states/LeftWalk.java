package vooga.scroller.sprites.test_sprites.mario.animation_states;

import vooga.scroller.sprites.animation.AnimationState;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

public class LeftWalk extends AnimationState {
    private static final Pixmap LEFT = new Pixmap("mario_left.png");

    public LeftWalk () {
        super(LEFT);
    }

    @Override
    public boolean validAnimation (Sprite unit) {
        return unit.lastLocation().x - unit.getCenter().x > 0;
    }

}
