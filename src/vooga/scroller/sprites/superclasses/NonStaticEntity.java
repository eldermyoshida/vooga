
package vooga.scroller.sprites.superclasses;

import java.awt.Dimension;
import java.util.Random;
import util.Location;
import util.Vector;
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
    
    public static Vector DEFAULT_SPEED = new Vector(0, 45);
    private Player myPlayer;
    
    public NonStaticEntity (Pixmap image, Location center, Dimension size) {
        super(image, center, size, DEFAULT_SPEED, StaticEntity.INANIMATE_ENTITY_HEALTH);  //health defaulted to 1
    }
    
    public NonStaticEntity (Pixmap image, Location center, Dimension size, int health) {
        super(image, center, size, DEFAULT_SPEED, health);
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

    public Vector upAndDown(int top, int bottom, int speed) {       
        if (this.getTop() > top) {
            return new Vector(Sprite.UP_DIRECTION, speed);
        }
        return new Vector(Sprite.DOWN_DIRECTION, speed);
    }
    
    public Player getPlayer() {
        return myPlayer;
    }

    public int getHit () {
        return 1;
    }
    
    public void takeHit() {
        // TODO:
    }
    
    


}
