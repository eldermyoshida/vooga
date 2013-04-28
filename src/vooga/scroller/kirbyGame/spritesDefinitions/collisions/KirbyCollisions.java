package vooga.scroller.kirbyGame.spritesDefinitions.collisions;

import util.Vector;
import vooga.scroller.collision_manager.CollisionDirection;
import vooga.scroller.extra_resources.sprite_interfaces.ICollectible;
import vooga.scroller.extra_resources.sprite_interfaces.IEnemy;
import vooga.scroller.extra_resources.sprite_interfaces.IPlatform;
import vooga.scroller.kirbyGame.spritesDefinitions.players.Kirby;
import vooga.scroller.kirbyGame.spritesDefinitions.players.states.FloatLeftState;
import vooga.scroller.marioGame.spritesDefinitions.players.Mario;
import vooga.scroller.sprites.Sprite;
import vooga.scroller.sprites.interfaces.IDoor;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.Direction;


/**
 * This class is specific to our game and is not intended to be a part of the
 * framework. It is meant to handle certain collisions specific to our Mario
 * game. If the game designer wants to implement specific collision helper methods
 * this is the place where those methods should go. <br>
 * <br>
 * Ultimately, this is the place where the game designer should dump all collision
 * logic into. He/She can then call these methods because VisitMethods.java
 * has a instance of this class.
 * 
 * @author Jay Wang
 */
public class KirbyCollisions {

    private static final double FRICTION = .5;
    private CollisionDirection direction = new CollisionDirection();


    protected void kirbyAndPlatformCollision (Kirby player, IPlatform platform) {

        
        player.stopFloat();
        
        Direction collisionType = direction.collisionDirection(player, platform);

        if (collisionType == null) return;

        switch (collisionType) {
            case TOP:
                player.setCenter(player.getX(), platform.getTop() - (player.getHeight() / 2));
                Vector v = player.getVelocity().getComponentVector((double) Sprite.DOWN_DIRECTION);
                v.negate();
                player.addVector(v);

//                Vector right = player.getVelocity().getComponentVector(Sprite.RIGHT_DIRECTION);
//                Vector left = player.getVelocity().getComponentVector(Sprite.LEFT_DIRECTION);
//
//                right.negate();
//                right.scale(FRICTION);
//                left.negate();
//                left.scale(FRICTION);
//                player.addVector(right);
//                player.addVector(left);
//
//                Vector sLeft = platform.getVelocity().getComponentVector(Sprite.LEFT_DIRECTION);
//                sLeft.scale(FRICTION);
//                Vector sRight = platform.getVelocity().getComponentVector(Sprite.RIGHT_DIRECTION);
//                sRight.scale(FRICTION);
//
//                player.addVector(sRight);
//                player.addVector(sLeft);

                break;
            case BOTTOM:
                player.setCenter(player.getX(), platform.getBottom() + (player.getHeight() / 2));

                Vector up = player.getVelocity().getComponentVector(Sprite.UP_DIRECTION);
                up.negate();
                player.addVector(up);

                break;
            case LEFT:
                player.setCenter(platform.getLeft() - (player.getWidth() / 2), player.getY());
                Vector l = player.getVelocity().getComponentVector(Sprite.LEFT_DIRECTION);
                l.negate();
                player.addVector(l);

                break;
            case RIGHT:
                player.setCenter(platform.getRight() + (player.getWidth() / 2), player.getY());

                Vector r = player.getVelocity().getComponentVector(Sprite.RIGHT_DIRECTION);
                r.negate();
                player.addVector(r);

                break;
            default:
                break;
        }
    }

}
