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
        myDirection= Double.parseDouble(getProperties()[0]);
        myMagnitude= Double.parseDouble(getProperties()[1]);
        myVector= new Vector(myDirection, myMagnitude);
    }

    
    public void applyForce(CharacterObject object) {
        Velocity newForce = getPhysics().applyForce(new Velocity(object.getVelocity()), (double) object.getMass(), new Velocity(myVector));
        object.getLocation().setVelocity(newForce);
    }

    
    
}
