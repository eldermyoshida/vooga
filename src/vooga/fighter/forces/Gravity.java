package vooga.fighter.forces;

import util.Vector;
import util.Velocity;
import vooga.fighter.model.objects.CharacterObject;
import vooga.fighter.util.Physics;

public class Gravity extends Force {
    
    private double myDirection;
    private double myMagnitude;
    private Vector myVector;
    
    public Gravity() {
        super();
    }

    public void applyForce(CharacterObject object) {
        Velocity newForce = getPhysics().applyForce((Velocity) object.getVelocity(), (double) object.getMass(), (Velocity) myVector);
        object.getLocation().setVelocity(newForce);
    }

    
    
}
