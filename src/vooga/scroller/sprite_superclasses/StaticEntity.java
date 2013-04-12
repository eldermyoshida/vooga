
package vooga.scroller.sprite_superclasses;

import java.awt.Dimension;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;
import vooga.scroller.util.Sprite_Type;

public class StaticEntity extends Sprite {

    public StaticEntity (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
        // TODO Auto-generated constructor stub
    }
    
    
    public Sprite_Type getSpriteType() {
        return Sprite_Type.STATIC;
    }

}
