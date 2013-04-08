package sprites;

import java.awt.Dimension;
import java.awt.Graphics2D;
import sprite_superclasses.StaticEntity;
import test_sprites.Type;
import util.Location;
import util.Pixmap;


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
