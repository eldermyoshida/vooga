package vooga.scroller.sprites.test_sprites.mario.animation_states;

import vooga.scroller.sprites.animation.AnimationState;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

public class Stand extends AnimationState {

    private static final Pixmap STAND = new Pixmap("llama_still.gif");
    
    public Stand () {
        super(STAND);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean validAnimation (Sprite unit) {
        return unit.getCenter().equals(unit.lastLocation());
    }

}
