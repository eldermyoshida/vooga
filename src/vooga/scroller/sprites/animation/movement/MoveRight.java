package vooga.scroller.sprites.animation.movement;

import vooga.scroller.sprites.Sprite;
import vooga.scroller.util.ISpriteView;

public class MoveRight extends SpriteMovement {
    
    public static final int STATE_ID = -5;

    
    private ISpriteView myStandView;

    public MoveRight (Sprite sprite, ISpriteView move, ISpriteView stand, double speed) {
        super(sprite, move, Sprite.RIGHT_DIRECTION, speed);
        myStandView = stand;
    }
    
    @Override
    public void deactivate() {
        super.deactivate();
        getUnit().setView(myStandView);
    }
}
