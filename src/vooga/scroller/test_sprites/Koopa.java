
package vooga.scroller.test_sprites;

import java.awt.Dimension;
import vooga.scroller.sprite_superclasses.NonStaticEntity;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;

public class Koopa extends NonStaticEntity {


    public Koopa (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
    }

    public void print() {
        System.out.println("Koopa");
    }
    
    @Override
    public Type getType() {
        return Type.KOOPA;
    }
    
}
