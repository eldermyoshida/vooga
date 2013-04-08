package vooga.rts.gamedesign.sprite.map;

import java.awt.Dimension;

import vooga.rts.gamedesign.sprite.Sprite;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;

/**
 * An object that appears on the map such as a tree or rock.  This would also
 * account for raised or lowered ground (for example a mountain or lake).
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public abstract class Terrain extends Sprite {

    // myLevel is how tall each terrain is. 1 = base level, and it increases in 
    // increments of 1. We can then use the level in the pathfinding algorithm for units that aren't on the ground.
    public int myHeight;
    public int myLevel;

    public Terrain(Pixmap image, Location center, Dimension size) {
        super(image, center, size);
    }

    public int getLevel () {
        return myLevel;
    }
}