package vooga.scroller.sprites.movement;

import java.awt.geom.Point2D;
import util.Vector;
import vooga.scroller.util.Sprite;


/**
 * Represents the back and forth movement between two points.
 * 
 * 
 * @author Scott Valentine
 * @author Jay Wang
 * 
 */
public class BackAndForth implements Movement {

    private static final int MAX_ANGLE = 360;
    private Sprite myEntity;
    private Point2D myStart;
    private Point2D myEnd;
    private int mySpeed;
    private double myMax;;
    private double myMin;;
    private double myAngle;

    /**
     * Creates a new back and forth movement that can only be used for the given sprite.
     * 
     * @param sprite on which this movement applies.
     * @param start point of the back and forth movement.
     * @param end point of the back and forth movement.
     * @param speed of the back and forth movement.
     */
    public BackAndForth (Sprite sprite, Point2D start, Point2D end, int speed) {
        myEntity = sprite;
        myStart = start;
        myEnd = end;
        mySpeed = speed;

        myMax = Math.max(start.getX(), end.getX());
        myMin = Math.min(start.getX(), end.getX());

        myAngle = Vector.angleBetween(start, end);

        placeEntityOnLine();
        setInitialVelocity();
    }

    @Override
    public void execute () {
        applyBoundary();
    }

    private void setInitialVelocity () {
        myEntity.setVelocity(new Vector(myAngle, mySpeed));
    }

    private void placeEntityOnLine () {

        int toStart =
                normalizeAngle((int) Vector.angleBetween(myEntity.getCenter(), myStart) % MAX_ANGLE);
        int toEnd =
                normalizeAngle(((int) Vector.angleBetween(myEntity.getCenter(), myEnd) 
                        + MAX_ANGLE / 2) % MAX_ANGLE);

        if (toStart != toEnd) {
            moveEntityToLine();
        }
    }

    private void moveEntityToLine () {
        myEntity.setCenter(myStart.getX(), myStart.getY());
    }

    private int normalizeAngle (int angle) {
        if (angle < 0) {
            return MAX_ANGLE + angle;
        }
        else {
            return angle;
        }
    }

    private void applyBoundary () {
        if (myEntity.getX() > myMax) {
            myEntity.getVelocity().negate();
        }
        else if (myEntity.getX() < myMin) {
            myEntity.getVelocity().negate();
        }
    }
}
