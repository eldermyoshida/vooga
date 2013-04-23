
package vooga.scroller.sprites.superclasses;

import java.awt.Dimension;
import util.Location;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

/**
 * This is the superclass for all Sprites a game designer creates 
 * that do not MOVE. This class is very simple. The main difference 
 * between this and NonStaticEntity is that they call different 
 * constructors. In this call to super, we are instantiating Sprite 
 * with no Velocity, which is just what we want for a StaticEntity. 
 * <br>
 * <br>
 * <b> Some examples of Static Entities: </b><br>
 *      Platforms (that don't move) <br>
 *      Spikes <br>
 *      Coins <br>
 * 
 * @author Jay Wang
 *
 */
public class StaticEntity extends Sprite {
    
    public StaticEntity (Pixmap image, Location center, Dimension size, int health, int damage) {
        super(image, center, size, health, damage); 
    }    

}
