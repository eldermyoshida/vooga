package vooga.scroller.collision_manager;

import util.Vector;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.Direction;
import vooga.scroller.util.Sprite;


/**
 * This class is specific to our game and is not intended to be a part of the
 * framework. It is meant to handle certain collisions specific to our Mario
 * game.
 * 
 * @author Jay Wang
 */
public class MarioCollisions {

    private static final double FRICTION = .5;
    private CollisionDirection direction = new CollisionDirection();

    void marioAndPlatformCollision (Player mario, Sprite sprite) {

        Direction collisionType = direction.collisionDirection(mario, sprite);

        if (collisionType == null) return;

        switch (collisionType) {
            case TOP:
                mario.setCenter(mario.getX(), sprite.getTop() - (mario.getHeight() / 2));
                Vector v = mario.getVelocity().getComponentVector((double) Sprite.DOWN_DIRECTION);
                v.negate();
                mario.addVector(v);

                Vector right = mario.getVelocity().getComponentVector(Sprite.RIGHT_DIRECTION);
                Vector left = mario.getVelocity().getComponentVector(Sprite.LEFT_DIRECTION);

                right.negate();
                right.scale(FRICTION);
                left.negate();
                left.scale(FRICTION);
                mario.addVector(right);
                mario.addVector(left);

                Vector sLeft = sprite.getVelocity().getComponentVector(Sprite.LEFT_DIRECTION);
                sLeft.scale(FRICTION);
                Vector sRight = sprite.getVelocity().getComponentVector(Sprite.RIGHT_DIRECTION);
                sRight.scale(FRICTION);

                mario.addVector(sRight);
                mario.addVector(sLeft);

                break;
            case BOTTOM:
                mario.setCenter(mario.getX(), sprite.getBottom() + (mario.getHeight() / 2));
                // mario.addVector(force);

                break;
            case LEFT:
                mario.setCenter(sprite.getLeft() - (mario.getWidth() / 2), mario.getY());
                // mario.addVector(force);

                break;
            case RIGHT:
                mario.setCenter(sprite.getRight() + (mario.getWidth() / 2), mario.getY());

                // mario.addVector(force);

                break;
            default:
                break;
        }
    }

}
