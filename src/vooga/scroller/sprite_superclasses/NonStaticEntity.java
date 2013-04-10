
package vooga.scroller.sprite_superclasses;

import java.awt.Dimension;
import java.util.Random;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;
import vooga.scroller.util.Vector;

public class NonStaticEntity extends Sprite {
    
    private static Vector DEFAULT_SPEED = new Vector(0, 45);
    
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
}
