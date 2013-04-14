package vooga.fighter.objects;

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
    public EnvironmentObject(int objectId) {
        super();
//    	setLoader(new EnvironmentObjectLoader(objectId));
    }    
    
    /**
     * Updates the environment object. Behavior to be added.
     */
    public void update(){
//    	super.update();
    }

	@Override
	public void applyCollideEffect(GameObject o) {
		// TODO Auto-generated method stub
		
	}

}
