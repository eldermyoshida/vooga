
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
    
    
    public Vector upAndDown(int top, int bottom, int speed) {
       
        if (this.getTop() > top) {
            System.out.println("Here");
            return new Vector(Sprite.UP_DIRECTION, speed);
        }
        return new Vector(Sprite.DOWN_DIRECTION, speed);
    }
    

}
