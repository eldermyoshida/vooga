package vooga.scroller.sprites.movement;

import util.Location;
import util.Vector;
import vooga.scroller.sprites.superclasses.NonStaticEntity;
import vooga.scroller.sprites.superclasses.Player;

public class TrackPlayer extends Movement {


    private NonStaticEntity myEntity;
    public TrackPlayer (NonStaticEntity nse) {
        super(nse);
        myEntity = nse;
    }

    
    @Override
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
    public Vector execute (int speed, int radius, Player myPlayer) {
        Location player = myPlayer.getCenter();
        if (Vector.distanceBetween(player, myEntity.getCenter()) > (double) radius) return NonStaticEntity.DEFAULT_SPEED; 
        return new Vector(Vector.angleBetween(player, myEntity.getCenter()), speed);
    }
    
    
    @Override
    public Vector execute () {
        return null;
    }

    @Override
    public Vector execute (int bounds1, int bounds2, int speed) {
        return null;
    }


}
