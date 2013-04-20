package vooga.fighter.model.objects;

import vooga.fighter.model.loaders.EnvironmentObjectLoader;
import vooga.fighter.model.utils.UpdatableLocation;

/**
 * Represents an environment object like a block or platform.
 * 
 * More behavior will be added.
 * 
 * @author James Wei, alanni, David Le
 * 
 */
public class EnvironmentObject extends GameObject {

	private static final String MAP_PATH = "src/vooga/fighter/config/environmentobjects.xml";
	
    /**
     * Constructs a new EnvironmentObject with the given image, center, and size.
     * In the future this will use the object loader to read from XML.
     */
    public EnvironmentObject(String name, UpdatableLocation center) {
        super();
        setLoader(new EnvironmentObjectLoader(name, this));
        setCurrentState("default");
        getCurrentState().setLooping(true);
        setLocation(center);
        setImageData();
    }

    /**
     * Updates the environment object. Behavior to be added.
     */
    public void update() {
        super.update();
    }

    /**
     * Returns false for now.
     */
    public boolean shouldBeRemoved() {
        return false;
    }
    
    /**
     * Dispatches a colliding object to allow for proper collision handling. 
     */
    public void dispatchCollision(GameObject other) {
        other.handleCollision(this);
    }
    
    /**
     * Collision with another CharacterObject.
     */
    public void handleCollision(CharacterObject other) {
        System.out.println("EnvironmentObject handleCollision : Environment collided with character");
    }
    
    /**
     * Collision with an AttackObject.
     */
    public void handleCollision(AttackObject other) {
        System.out.println("EnvironmentObject handleCollision : Environment collided with attack");
    }
    
    /**
     * Collision with an EnvironmentObject.
     */
    public void handleCollision(EnvironmentObject other) {
        System.out.println("EnvironmentObject handleCollision : Environment collided with environment");
    }

}
