package vooga.scroller.sprites.superclasses;

import java.awt.geom.Point2D;

/**
 * Interface that allows for objects to be located in the 2d plane of the real numbers.
 * 
 * @author Scott Valentine
 *
 */
public interface Locatable {

    /**
     * Gives the location of this object as a 2d point.
     * 
     * @return the 2d point that represents the center of this object.
     */
    public Point2D getCenter();
}
