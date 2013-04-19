package vooga.scroller.sprites.test_sprites.pikachu.animation_states;

import vooga.scroller.sprites.animation.AnimationState;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

public class LeftWalk extends AnimationState {
    public static final Pixmap LEFT = new Pixmap("runleft.gif");
    private static final Pixmap LEFT_STAND = new Pixmap("standleft.png");
    
    
    public LeftWalk () {
        super(LEFT);
    }

    @Override
    public boolean validAnimation (Sprite unit) {
        if(unit.lastLocation().x - unit.getCenter().x > .5) {
            unit.getView().setDefaultView(LEFT_STAND);
            return true;
        }
        return false;
        //return unit.lastLocation().x - unit.getCenter().x > .5;
    }

}
