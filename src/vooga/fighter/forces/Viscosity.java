package vooga.fighter.forces;

import util.Vector;
import util.Velocity;
import vooga.fighter.model.objects.CharacterObject;

public class Viscosity extends Force{
    
    private double myViscosityFactor;
    
    public Viscosity() {
        super();
    }
    
    public void applyForce(CharacterObject object) {
        Vector vector = object.getVelocity();
        vector.setDirection(180 - (object.getVelocity().getDirection()));
        vector.scale(myViscosityFactor);
        object.getLocation().addAcceleration(vector);
    }
    
    public void initialize(double param1, double param2) {
        myViscosityFactor = param1;
        
    }

}
