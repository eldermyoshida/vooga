package vooga.scroller.collision_manager;

import vooga.scroller.sprites.interfaces.ISprite;
import vooga.scroller.util.Direction;

public class CollisionDirection {
    
    
    private static final int COLLISION_GRANULARITY = 15;

    /**
     * Helper Methods for getting Collision Direction
     * @param Sprite sprite1
     * @param Sprite sprite2
     * @return one of four Direction enums
     */
    public Direction collisionDirection (ISprite sprite1, ISprite sprite2) {  
        if (checkTop(sprite1, sprite2)) return Direction.TOP;
        else if (checkBottom(sprite1, sprite2)) return Direction.BOTTOM;
        else if (checkLeft(sprite1, sprite2)) return Direction.LEFT;
        else if (checkRight(sprite1, sprite2)) return Direction.RIGHT;        
        return null;
    }
    
    private boolean checkTop(ISprite sprite1, ISprite sprite2) {
        return (sprite1.getBottom() >= sprite2.getTop() && sprite1.getBottom() <= sprite2.getTop() + COLLISION_GRANULARITY);
    }
    
    private boolean checkBottom(ISprite sprite1, ISprite sprite2) {
        return (sprite1.getTop() <= sprite2.getBottom() && sprite1.getTop() >= sprite2.getBottom() - COLLISION_GRANULARITY);
    }
    
    private boolean checkLeft(ISprite sprite1, ISprite sprite2) {
        return (sprite1.getRight() >= sprite2.getLeft() && sprite1.getRight() <= sprite2.getLeft() + COLLISION_GRANULARITY);
    }
    
    private boolean checkRight(ISprite sprite1, ISprite sprite2) {
        return (sprite1.getLeft() <= sprite2.getRight() && sprite1.getLeft() >= sprite2.getRight() - COLLISION_GRANULARITY);
    }
    

}
