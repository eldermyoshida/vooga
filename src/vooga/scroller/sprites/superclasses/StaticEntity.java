
package vooga.scroller.sprites.superclasses;

import java.awt.Dimension;
import util.Location;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

public class StaticEntity extends Sprite {

    public static final int INANIMATE_ENTITY_HEALTH = 1;
    
    public StaticEntity (Pixmap image, Location center, Dimension size) {
        super(image, center, size, INANIMATE_ENTITY_HEALTH); //static entities have a health of 1
    }
    
    
    

}
