package vooga.fighter.forces;

import java.lang.reflect.Field;
import java.util.ResourceBundle;
import util.Velocity;
import vooga.fighter.model.objects.CharacterObject;
import vooga.fighter.util.Physics;

public abstract class Force {
    
    private Physics myPhysics;
    
    public Force() {
    }
    
    public void setPhysics(Physics physics) {
        myPhysics = physics;
    }
    
    public Physics getPhysics() {
        return myPhysics;
    }
    
    public abstract void applyForce(CharacterObject object) ;
    
    
}
