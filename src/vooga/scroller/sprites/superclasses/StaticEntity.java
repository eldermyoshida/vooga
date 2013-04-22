
package vooga.scroller.sprites.superclasses;

import java.awt.Dimension;
import util.Location;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

public class StaticEntity extends Sprite {
    
    private int myHealth; //TODO - not too sure what is supposed to be here.
    private int myDamage;
   
    public StaticEntity (Pixmap image, Location center, Dimension size) {
        super(image, center, size); //static entities have a health of 1
        myHealth = 1;
        myDamage = 0;
    }
    
    public StaticEntity (Pixmap image, Location center, Dimension size, int health, int damage) {
        super(image, center, size); //static entities have a health of 1
        myHealth = health;
        myDamage = damage;
    }
    
    
    public void takeHit(int damage) {
        myHealth -= damage;
    }

    public int getHit () {
        return myDamage;
    }
    
    public int getHealth() {
        return myHealth;
    }
    
    

}
