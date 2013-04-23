package vooga.fighter.forces;

import util.Vector;
import vooga.fighter.model.objects.CharacterObject;

public class Viscosity extends Force{
    
    private double myViscosityFactor;
    
    public Viscosity() {
        super();
    }
    
    public void applyForce(CharacterObject object) {
        Vector vector = new Vector(object.getVelocity());
        vector.setDirection(vector.getDirection()-180);
        vector.scale(myViscosityFactor);
        object.getLocation().translate(vector);
    }
    
    public void initialize(double param1, double param2) {
        myViscosityFactor = param1;
        
    }

}
