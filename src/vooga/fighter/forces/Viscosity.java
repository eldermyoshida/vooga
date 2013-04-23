package vooga.fighter.forces;

import util.Vector;
import util.Velocity;
import vooga.fighter.model.objects.CharacterObject;

public class Viscosity extends Force{
    
    private double myViscosityFactor;
    
    public Viscosity() {
        super();
        myViscosityFactor = Double.parseDouble(getProperties()[0]);
    }
    
    public void applyForce(CharacterObject object) {
        Vector vector = object.getVelocity();
        vector.setDirection(180 - (object.getVelocity().getDirection()));
        vector.scale(myViscosityFactor);
        object.getLocation().addAcceleration(vector);
    }

}
