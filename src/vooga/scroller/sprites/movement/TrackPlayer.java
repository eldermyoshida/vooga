package vooga.scroller.sprites.movement;

import util.Location;
import util.Vector;
import vooga.scroller.util.Sprite;

/**
 * This is a type of Movement that does simple AI in tracking the player. This method's execute() 
 * method will return the vector in the direction of the player with the given speed. 
 * 
 * @author Jay Wang
 *
 */
public class TrackPlayer extends Movement {

    private Sprite myTarget;
   
    // TODO: can't leave this here. I am going to ask jay more about this.
    private static final Vector DEFAULT_SPEED = new Vector(0,100);
    
    
    public TrackPlayer (Sprite nse) {
        super();
        myTarget = nse;
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
    public Vector execute (int speed, int radius, Location playerLocation) {
        if (Vector.distanceBetween(playerLocation, myTarget.getCenter()) > (double) radius) {
            return DEFAULT_SPEED; 
        }
        return new Vector(Vector.angleBetween(playerLocation, myTarget.getCenter()), speed);
    }

}
