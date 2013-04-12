package vooga.scroller.animation;

import util.Pixmap;
import util.Sprite;

public class Stand extends AnimationState {

    private static final Pixmap RIGHT = new Pixmap("StandR.gif");
    
    public Stand (Pixmap image) {
        super(image);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean validAnimation (Sprite unit) {
        if(unit.getCenter().equals(unit.lastLocation())){
            return true;
        }
        return false;
    }

}
