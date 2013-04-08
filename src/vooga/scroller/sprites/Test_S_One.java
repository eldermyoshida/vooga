
package vooga.scroller.sprites;

import java.awt.Dimension;
import java.awt.Graphics2D;
import vooga.scroller.sprite_superclasses.StaticEntity;
import vooga.scroller.test_sprites.Type;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;


/**
 * This Class is meant to be a place holder for a real static environment  
 * object such as a Platform, Tunnels, swirling ball and chain.    
 *    
 *      
 * @author Jay Wang
 */
public class Test_S_One extends StaticEntity {

    public Test_S_One (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
    }

    public Type getType() {
        return Type.NONE;
    }
}
