package vooga.fighter.forces;

import java.lang.reflect.Field;
import java.util.ResourceBundle;
import vooga.fighter.model.objects.CharacterObject;
import vooga.fighter.util.Physics;

public abstract class Force {
    
	
    private Physics myPhysics;
	private ResourceBundle myResources;
	private static final String RESOURCE_PATH="vooga.fighter.config.forces";
    
    public Force() {
		myResources = ResourceBundle.getBundle(RESOURCE_PATH);

    }
    
    
    public void setPhysics(Physics physics) {
        myPhysics = physics;
    }
    
    public Physics getPhysics() {
        return myPhysics;
    }
    
    public abstract void initialize(double param1, double param2);
    
    public abstract void applyForce(CharacterObject object) ;
    
    
}
