
package vooga.scroller.sprites.superclasses;

import java.awt.Dimension;
import java.util.Random;
import vooga.scroller.level_editor.Level;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;
import vooga.scroller.util.Vector;

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
        // TODO Auto-generated constructor stub
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
    
    
    public Vector trackPlayer(int speed, int radius) {
        Location player = myPlayer.getCenter();
        if (Vector.distanceBetween(player, this.getCenter()) > (double) radius) return DEFAULT_SPEED; 
        return new Vector(Vector.angleBetween(player, this.getCenter()), speed);
    }
    
    public void addPlayer(Player player) {
        myPlayer = player;
    }
    
    
    /**
     * NOTE - this method will only work if the Y coordinate of moving platform is 
     * instantiated somewhere between TOP and BOTTOM. You can't create a moving platform 
     * outside the bounds of TOP and BOTTOM. Likewise, you therefore cannot give TOP 
     * and BOTTOM bounds that do not encapsulate where your moving platform is instantiated. 
     * 
     * @param top
     * @param bottom
     * @param speed
     * @return
     */
    public Vector upAndDown(int top, int bottom, int speed) {
 
        if (this.getTop() < top) {
            if (this.getBottom() < top) { //this line may need to be adjusted by a size of this.getHeight()
                this.getVelocity().turn(180);
                return this.getVelocity();
            }
            this.getVelocity();
        }
        
        if (this.getBottom() > bottom) {
            if (this.getTop() > bottom) { //this line may need to be adjusted by a size of this.getHeight()
                this.getVelocity().turn(180);
                return this.getVelocity();
            }
            this.getVelocity();
        }
        
        if (this.getTop() < (top - this.getHeight()) || this.getBottom() > (bottom + this.getHeight())) {
            System.err.println("ERROR: Cannot give moving platform bounds that do not encapsulate its instantiated Y position.");
            return null;
        }
        
        return this.getVelocity();
    }
    
    

    public int getHit () {
        // TODO Auto-generated method stub
        return 1;
    }
    

}
