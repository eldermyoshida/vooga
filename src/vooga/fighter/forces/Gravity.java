package vooga.fighter.forces;

import util.Vector;
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
        Vector newForce = getPhysics().applyForce(object.getVelocity(), object.getMass(), myVector);
        object.getLocation().setVelocity(newForce);
    }

    
    
}
