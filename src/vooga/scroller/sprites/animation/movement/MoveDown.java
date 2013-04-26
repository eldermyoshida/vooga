package vooga.scroller.sprites.animation.movement;

import vooga.scroller.sprites.Sprite;
import vooga.scroller.util.ISpriteView;

public class MoveDown extends SpriteMovement {

    public static final int STATE_ID = -2;
    
    private ISpriteView myStandView;

    public MoveDown (Sprite sprite, ISpriteView move, ISpriteView stand, double speed) {
        super(sprite, move, Sprite.DOWN_DIRECTION, speed);
        myStandView = stand;
    }
    
    @Override
    public void deactivate() {
        super.deactivate();
        getUnit().setView(myStandView);
    }

}
