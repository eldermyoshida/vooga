package vooga.scroller.collision_manager;


import vooga.scroller.sprites.interfaces.ICoin;
import vooga.scroller.sprites.interfaces.IEnemy;
import vooga.scroller.sprites.interfaces.ILevelPortal;
import vooga.scroller.sprites.interfaces.IPlatform;
import vooga.scroller.sprites.interfaces.IPlayer;
import vooga.scroller.util.Direction;

public class VisitMethods {

    /**
     * Begin the long slew of visit() methods... 
     * Thinking about ways to refactor/repackage this.
     * 
     */
       
    private CollisionDirection direction = new CollisionDirection();
    private MarioCollisions collisions = new MarioCollisions();

    public void visit (IPlayer player, IPlatform platform) {
        collisions.marioAndPlatformCollision(player.getPlayer(), platform.getPlatform());
    }
    
    public void visit (IPlayer player, ICoin coin) {
        player.incrementScore(coin.getValue());
        coin.takeHit(player.getPlayer().getHit());
    }
    
    public void visit (IPlayer player, IEnemy enemy) {
        if (direction.collisionDirection(player.getPlayer(), enemy.getEnemy()).equals(Direction.TOP)) {
            enemy.takeHit(player.getPlayer().getHit());
        }
        else {
            player.takeHit(enemy.getHit());
        }        
    }
    
    public void visit (IPlayer player, ILevelPortal levelPortal) {
        levelPortal.goToNextLevel(player.getPlayer());
    }
}
