package vooga.scroller.sprites.test_sprites.mario.animation_states;

import vooga.scroller.sprites.animation.AnimationState;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

public class LeftWalk extends AnimationState {
    public static final Pixmap LEFT = new Pixmap("llama_walk_left.gif");

    public LeftWalk () {
        super(LEFT);
    }

    @Override
    public boolean validAnimation (Sprite unit) {
        
        return unit.lastLocation().x - unit.getCenter().x > 1;
    }

}
