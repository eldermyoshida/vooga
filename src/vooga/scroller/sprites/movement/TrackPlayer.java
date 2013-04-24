package vooga.scroller.sprites.movement;

import util.Vector;
import vooga.scroller.sprites.superclasses.Locatable;
import vooga.scroller.util.Sprite;

/**
 * This is a type of Movement that does simple AI in tracking the player. This method's execute() 
 * method will return the vector in the direction of the player with the given speed. 
 * 
 * @author Jay Wang
 *
 */
public class TrackPlayer implements Movement {

   
    // TODO: can't leave this here. I am going to ask jay more about this.
    private static final Vector DEFAULT_SPEED = new Vector(0,100);
    private int mySpeed;
    private int myRadius;
    private Sprite myPredator;
    private Locatable myTarget; 
    
    
    public TrackPlayer (Sprite predator, Locatable target, int speed, int radius) {
        super();
        myPredator = predator;
        myTarget = target;
        mySpeed = speed;
        myRadius = radius;
    }
    

    /**
     * This method will allow a Non Static Entity to track down a Player - a simple AI of sorts. 
     * Essentially, if the player gets within the specified radius of this entity, the entity will 
     * change its velocity vector with a vector that is in the direction of the player with the 
     * given SPEED. 
     * 
     * @param speed
     * @param radius
     * @return a vector that in direction of the player with the given SPEED
     */
    public void execute () {
        //out of range
        // TODO :
//        if(myTarget == null){
//            return;
//        }
        
        if (Vector.distanceBetween(myPredator.getCenter(), myTarget.getCenter()) < (double) myRadius) {
            myPredator.setVelocity(Vector.angleBetween(myPredator.getCenter(), myTarget.getCenter()), mySpeed); 
        }
    }


    public void setTarget (Locatable target) {
        myTarget = target;       
    }

}
