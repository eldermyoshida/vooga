package vooga.scroller.sprites.animation;

import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

public class MoveRight extends AnimationState {

    private Pixmap myStand;

    public MoveRight (Pixmap move, Pixmap stand) {
        super(move);
        myStand = stand;
    }

    @Override
    public boolean validAnimation (Sprite unit) {
        if(unit.getCenter().x - unit.lastLocation().x > .2){            
            unit.getView().setDefaultView(myStand);
            return true;
        }
        return false;
    }

}
