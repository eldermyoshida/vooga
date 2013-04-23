
package vooga.scroller.sprites.superclasses;

import java.awt.Dimension;
import util.Location;
import util.Vector;
import vooga.scroller.sprites.movement.Movement;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

/**
 * This is the superclass for all Sprites a game designer creates 
 * that MOVE. Critical in this class is the abstract getMovement() method 
 * that this superclass forces its subclasses to implement. This class also 
 * contains a bunch of helper methods pertaining to Velocity / Movement that 
 * many NonStaticEntities may find useful.  
 * <br>
 * <br>
 * Every NonStaticEntity has a default speed that is defaulted to (0, 45). However,
 * this will most definitely be by the NonStaticEntity. 
 * 
 * @author Jay Wang
 *
 */
public abstract class NonStaticEntity extends Sprite {
    
    public static Vector DEFAULT_SPEED = new Vector(0, 45);
    private Player myPlayer;

    /**
     * When you create a NonStaticEntity, you need to give the following five parameters.
     * <br>
     * <br>
     * Note that you must give it a health and a distance, which are Integers. If you have something 
     * like a moving platform, default its health to 1 (really, any positive number would work). The damage 
     * would obviously be 0 (a platform isn't going to do damage on anyone). 
     * @param image
     * @param center
     * @param size
     * @param health
     * @param damage
     */
    public NonStaticEntity (Pixmap image, Location center, Dimension size, int health, int damage) {
        super(image, center, size, DEFAULT_SPEED, health, damage);
    }
    
    /**
     * The most important method of NonStaticEntity. Every subclass must implement getMovement(). 
     * This forces a subclass to NonStaticEntity to move. 
     * @param movement
     * @return
     */
    public abstract Vector getMovement(Movement movement);
   
    /**
     * This will change the Sprite's Velocity vector to the vector that is passed in. 
     * @param vector
     */
    public void changeVelocity(Vector vector) {
        super.setVelocity(vector.getDirection(), vector.getMagnitude());
    }
   
    public void changeVelocity(double direction, double magnitude) {
        super.setVelocity(direction, magnitude);
    }
        
    /** 
     * This method is called by some NonStaticEntites than need the Player's location to handle 
     * various Artifical Intelligence movements. For example, TrackPlayer would require the Player's 
     * Location. 
     * @return Location
     */
    public Location getPlayerLocation() {
        return myPlayer.getCenter();
    }

    /**
     * This is called in the SpriteManager on NonStaticEntities that need a Player
     * @param player
     */
    public void addPlayer (Player player) {
        myPlayer = player;
    }
}
