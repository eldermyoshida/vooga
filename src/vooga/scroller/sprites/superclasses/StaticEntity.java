
package vooga.scroller.sprites.superclasses;

import java.awt.Dimension;
import util.Location;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

public class StaticEntity extends Sprite {
    
    public StaticEntity (Pixmap image, Location center, Dimension size, int health, int damage) {
        super(image, center, size, health, damage); //static entities have a health of 1
    }    

}
