package games.scroller.arcadedemopackage.collisions;


import games.scroller.arcadedemopackage.Spaceship;
import vooga.scroller.marioGame.spritesDefinitions.players.Mario;
import vooga.scroller.sprites.interfaces.ICollectible;
import vooga.scroller.sprites.interfaces.IDoor;
import vooga.scroller.sprites.interfaces.IEnemy;
import vooga.scroller.sprites.interfaces.IPlatform;
import vooga.scroller.sprites.superclasses.Player;

/**
 * This is where you want to place your visit methods. To keep this class as 
 * clean as possible, I don't actually handle the collision logic here. I handle 
 * that logic in a Game specific Collisions class. You can, of course, handle all 
 * collisions in these visit() methods if you prefer. 
 * 
 * @author Jay Wang
 *
 */
public class VisitMethods {

       
    private SpaceshipCollisions collisions = new SpaceshipCollisions();
    
    public void visit (Spaceship spaceship, ICollectible collectible) {
        collisions.spaceshipAndCollectibleCollision(spaceship, collectible);
    }
        
    public void visit (Spaceship spaceship, IEnemy enemy) {
        collisions.spaceshipAndEnemyCollision(spaceship, enemy);
    }
    
    public void visit (Player player, IDoor levelPortal) {
        collisions.spaceshipAndLevelPortalDetection(player, levelPortal);
    }
}
