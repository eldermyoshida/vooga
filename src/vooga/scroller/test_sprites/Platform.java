
package vooga.scroller.test_sprites;

import java.awt.Dimension;
import vooga.scroller.sprite_superclasses.StaticEntity;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;

public class Platform extends StaticEntity{


    
    public Platform (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
        // TODO Auto-generated constructor stub
    }

    public void print() {
        System.out.println("Platform");
    }
    

}
