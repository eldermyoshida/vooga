package vooga.scroller.sprites.superclasses;

import util.Vector;
import vooga.scroller.sprites.movement.Movement;

public interface Movable {

    /**
     * @param movement
     * @return
     */
    public Vector getMovement(Movement movement);
    
}
