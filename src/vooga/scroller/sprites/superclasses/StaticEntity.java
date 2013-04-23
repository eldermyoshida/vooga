package vooga.scroller.sprites.superclasses;

import java.awt.Dimension;
import util.Location;
import util.Vector;
import vooga.scroller.util.ISpriteView;
import vooga.scroller.util.Sprite;

/**
 * This is the superclass for all Sprites a game designer creates 
 * that do not MOVE. This class is very simple. The main difference 
 * between this and NonStaticEntity is that they call different 
 * constructors. In this call to super, we are instantiating Sprite 
 * with no Velocity, which is just what we want for a StaticEntity. 
 * <hr>
 * <b> Some examples of Static Entities: </b>
 * <ul>
 * <li> Platforms (that don't move)
 * <li> Spikes
 * <li> Coins 
 * </ul>
 * <hr>
 * @author Jay Wang
 * @author Scott Valentine
 *
 */
public class StaticEntity extends Sprite {

    /**
     * Creates a new static entity with the parameters needed for a sprite.
     * @param image is the View of this sprite.
     * @param center is where this sprite will be located.
     * @param size is the dimensions of this sprite.
     */
    public StaticEntity (ISpriteView image, Location center, Dimension size) {
        super(image, center, size);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void update(double elapsedTime, Dimension bounds) {
        // never moves or changes state (could change state in other implementations).
    }
    
    @Override
    public void translate (Vector v) {
        // you can't translate this to pretend it is moving
    }



}
