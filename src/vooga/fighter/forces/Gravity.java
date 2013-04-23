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
        //Velocity newForce = getPhysics().applyForce(new Velocity(object.getVelocity()), (double) object.getMass(), new Velocity(myVector));
        object.getLocation().addAcceleration(myVector);
    }
    
    public void initialize(double param1, double param2) {
        myDirection = param1;
        myMagnitude = param2;
        myVector= new Vector(myDirection, myMagnitude);
    }


    
}
