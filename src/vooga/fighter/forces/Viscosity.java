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
        Vector vector = new Vector(object.getVelocity());
        vector.setDirection(vector.getDirection()-180);
        vector.scale(myViscosityFactor);
        object.getLocation().translate(vector);
    }

}
