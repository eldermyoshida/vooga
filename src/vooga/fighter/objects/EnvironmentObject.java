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
	private long myInstanceId; 
	private ObjectLoader myLoader; 
    /**
     * Constructs a new EnvironmentObject with the given image, center, and size.
     * In the future this will use the object loader to read from XML.
     */
    public EnvironmentObject (long instanceId, int objectId) {
        super(instanceId);
    	myLoader= new EnvironmentObjectLoader(objectId);
    }

}
