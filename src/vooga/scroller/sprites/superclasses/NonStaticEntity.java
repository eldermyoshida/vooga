
package vooga.scroller.sprites.superclasses;

import java.awt.Dimension;
import java.util.Random;
import util.Location;
import util.Vector;
import vooga.scroller.level_editor.Level;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

/**
 * This is the superclass for all entities that move. Generally 
 * these are going to be enemies that extend this class. 
 * 
 * This class provides some tracking functionality as well as ways 
 * to generate random movements. 
 * 
 * @author Jay Wang
 *
 */
public class NonStaticEntity extends Sprite {
    
    private static Vector DEFAULT_SPEED = new Vector(0, 45);
    private Player myPlayer;
    
    public NonStaticEntity (Pixmap image, Location center, Dimension size) {
        super(image, center, size, DEFAULT_SPEED);
    }
    
    public void changeVelocity(Vector vector) {
        super.setVelocity(vector.getDirection(), vector.getMagnitude());
    }
    
    public void changeVelocity(double direction, double magnitude) {
        super.setVelocity(direction, magnitude);
    }
    
    public Vector getRandomVelocity() {
        Random randomGenerator = new Random(); 
        return new Vector((double) randomGenerator.nextInt(360), (double) randomGenerator.nextInt(100));
    }
    
    public void addPlayer(Player player) {
        myPlayer = player;
    }
    
    
    /**
     * This method will allow a Non Static Entity to track down a Player - a simple AI of sorts. 
     * Essentially, if the player gets within the specified radius of this entity, the entity will 
     * change its velocity vector with a vector that is in the direction of the player with the 
     * given SPEED. 
     * 
     * @param speed
     * @param radius
     * @return a vector that in direction of the player with the given SPEED
     */
    public Vector trackPlayer(int speed, int radius) {
        Location player = myPlayer.getCenter();
        if (Vector.distanceBetween(player, this.getCenter()) > (double) radius) return DEFAULT_SPEED; 
        return new Vector(Vector.angleBetween(player, this.getCenter()), speed);
    }
    
    
    /**
     * This method will only work if the Y coordinate of moving platform is 
     * instantiated somewhere between TOP and BOTTOM. You can't create a moving platform 
     * outside the bounds of TOP and BOTTOM. Likewise, you therefore cannot give TOP 
     * and BOTTOM bounds that do not encapsulate where your moving platform is instantiated. 
     * 
     * @param top
     * @param bottom
     * @param speed
     * @return a vector in the UP or DOWN direction with given SPEED
     */
    public Vector upAndDown(int top, int bottom, int speed) {
        return handlePlatformMovements(this.getTop(), this.getBottom(), top, bottom, speed);
    }
    
    
    /**
     * This method will only work if the X coordinate of moving platform is 
     * instantiated somewhere between LEFT and RIGHT. You can't create a moving platform 
     * outside the bounds of LEFT and RIGHT. Likewise, you therefore cannot give LEFT 
     * and RIGHT bounds that do not encapsulate where your moving platform is instantiated. 
     * 
     * Essentially, the implementation for this method mirrors the upAndDown() method.
     * 
     * @param left
     * @param right
     * @param speed
     * @return a vector in the LEFT or RIGHT direction with given SPEED
     */
    public Vector leftAndRight(int left, int right, int speed) {
        return handlePlatformMovements(this.getLeft(), this.getRight(), left, right, speed);
    }

    public int getHit () {
        return 1;
    }
    
    
    /*
     * LIST OF ALL PRIVATE METHODS --------------------------------------------------------------------------
     */
    private Vector handlePlatformMovements (double position1, double position2, int bounds1, int bounds2, int speed) {
        
        if (position1 < bounds1) {
            if (position2 < bounds2) { //this line may need to be adjusted by a size of this.getHeight()
                this.getVelocity().turn(180);
                return this.getVelocity();
            }
            this.getVelocity();
        }
        
        if (position2 > bounds2) {
            if (position1 > bounds1) { //this line may need to be adjusted by a size of this.getHeight()
                this.getVelocity().turn(180);
                return this.getVelocity();
            }
            this.getVelocity();
        }
        
        if (position1 < (bounds1 - this.getHeight()) || position2 > (bounds2 + this.getHeight())) {
            System.err.println("ERROR: Cannot give moving platform bounds that do not encapsulate its instantiated (X,Y) position.");
            return null;
        }      
        return this.getVelocity();
    }

}
