package vooga.fighter.forces;

import java.lang.reflect.Field;
import java.util.ResourceBundle;
import util.Velocity;
import vooga.fighter.model.objects.CharacterObject;
import vooga.fighter.util.Physics;

public abstract class Force {
    
	
    private Physics myPhysics;
	private ResourceBundle myResources;
    private static final String delimiter= ",";
	private static final String RESOURCE_PATH="vooga.fighter.config.forces";
    
    public Force() {
		myResources = ResourceBundle.getBundle(RESOURCE_PATH);

    }
    
    protected String[] getProperties(){
    	return myResources.getString(getClass().getSimpleName()).split(delimiter);
    }
    
    public void setPhysics(Physics physics) {
        myPhysics = physics;
    }
    
    public Physics getPhysics() {
        return myPhysics;
    }
    
    public abstract void applyForce(CharacterObject object) ;
    
    
}
