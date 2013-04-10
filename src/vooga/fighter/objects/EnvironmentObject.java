package vooga.fighter.objects;

import java.awt.Dimension;
import vooga.fighter.util.Location;
import vooga.fighter.util.Pixmap;

/**
 * Represents an environment object like a block or platform.
 * 
 * More behavior will be added.
 * 
 * @author james, alanni
 *
 */
public class EnvironmentObject extends GameObject {

    /**
     * Constructs a new EnvironmentObject with the given image, center, and size.
     * In the future this will use the object loader to read from XML.
     */
    public EnvironmentObject (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
    }

}
