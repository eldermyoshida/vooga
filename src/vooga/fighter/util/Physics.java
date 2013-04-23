package vooga.fighter.util;

import util.Vector;
import util.Velocity;

/**
 * Physics methods for dealing with various forces and collision.
 * 
 * @author Wayne You
 *
 */
public class Physics {
    /**
     * Calculates an elastic collision given two objects of given masses and velocities.
     * 
     * @param aVelocity The velocity of object A
     * @param aMass The mass of object A
     * @param bVelocity The velocity of object B
     * @param bMass The mass of object B
     * @return Two vectors in an array, the first is the new velocity of object A and the second is
     *         the new velocity of object B.
     */
    public static Velocity[] elasticCollision (Velocity aVelocity,
                                             int aMass,
                                             Velocity bVelocity,
                                             int bMass) {
        return partiallyInelasticCollision(1, aVelocity, aMass, bVelocity, bMass);
    }

    /**
     * Calculates a perfectly inelastic collision given two objects of given masses and velocities.
     * 
     * @param aVelocity The velocity of object A
     * @param aMass The mass of object A
     * @param bVelocity The velocity of object B
     * @param bMass The mass of object B
     * @return Two vectors in an array, the first is the new velocity of object A and the second is
     *         the new velocity of object B.
     */
    public static Velocity[] inelasticCollision (Velocity aVelocity,
                                               int aMass,
                                               Velocity bVelocity,
                                               int bMass) {
        return partiallyInelasticCollision(0, aVelocity, aMass, bVelocity, bMass);
    }

    /**
     * Calculates a partially inelastic collision given two objects of given masses and velocities.
     * 
     * @param restitution The coefficient of restitution where 1 is perfectly elastic and 0 is
     *        perfectly inelastic
     * @param aVelocity The velocity of object A
     * @param aMass The mass of object A
     * @param bVelocity The velocity of object B
     * @param bMass The mass of object B
     * @return Two vectors in an array, the first is the new velocity of object A and the second is
     *         the new velocity of object B.
     */
    public static Velocity[] partiallyInelasticCollision (double restitution,
                                                        Velocity aVelocity,
                                                        int aMass,
                                                        Velocity bVelocity,
                                                        int bMass) {

        double referenceAngle = Math.toDegrees(Math.atan2(aVelocity.getY() - bVelocity.getY(),
                                                          aVelocity.getX() - bVelocity.getX()));

        Velocity aTurned = aVelocity.clone();
        aTurned.turn(-referenceAngle);

        Velocity bTurned = bVelocity.clone();
        bTurned.turn(-referenceAngle);

        double aVectorTurnedDX =
                (restitution * bMass * (bTurned.getXChange() - aTurned.getXChange()) +
                 aMass * aTurned.getXChange() + bMass * bTurned.getXChange()) / (aMass + bMass);

        double bVectorTurnedDX =
                (restitution * aMass * (aTurned.getXChange() - bTurned.getXChange()) +
                 aMass * aTurned.getXChange() + bMass * bTurned.getXChange()) / (aMass + bMass);

        Velocity[] newDirections = new Velocity[2];
        newDirections[0] = new Velocity(aVelocity.getX(),aVelocity.getY(),0,0);
        newDirections[1] = new Velocity(bVelocity.getX(),bVelocity.getY(),0,0);
        
        newDirections[0].setVector(aVectorTurnedDX,aTurned.getYChange());
        newDirections[1].setVector(bVectorTurnedDX,bTurned.getYChange());
        
        newDirections[0].turn(-referenceAngle);
        newDirections[1].turn(-referenceAngle);

        return newDirections;
    }

    /**
     * Computes a vector after gravitational force is applied.
     * 
     * @param velocity The velocity of the object
     * @param gravitationalAcceleration The acceleration due to gravity.
     * @param terminalSpeed The max speed an object can fall down.
     * @return A vector with gravity applied for one time period of acceleration.
     */
    public static Velocity gravity (Velocity velocity,
                                  double gravitationalAcceleration,
                                  double terminalSpeed) {
        double dY = velocity.getYChange() - gravitationalAcceleration;
        if (dY < -terminalSpeed) {
            dY = -terminalSpeed;
        }

        return new Velocity(velocity.getX(), velocity.getY(), velocity.getXChange(), dY);
    }

    /**
     * Reduces the magnitude of a vector due to friction.
     * A crude representation that does not work by opposing force.
     * 
     * @param velocity The original velocity.
     * @param coefficientOfFriction The coefficient of friction (between 0 and 1)
     * @return A reduced velocity vector.
     */
    public static Velocity friction (Velocity velocity, double coefficientOfFriction) {
        Velocity velocityClone = velocity.clone();
        velocityClone.scale(coefficientOfFriction);

        return velocityClone;
    }

    /**
     * Applies gravity to an object in contact with something acting as the ground with a particular
     * angle.
     * 
     * @param velocity The current velocity of the object.
     * @param gravitationalAcceleration The acceleration due to gravity
     * @param terminalSpeed The maximum magnitude the velocity may have.
     * @param inclineAngle The incline of the angled slope in degrees. [0, 180)
     * @param coefficientOfFriction The coefficient of friction.
     * @return A modified velocity vector after applying gravity.
     */
    public static Velocity sliding (Velocity velocity,
                                  double gravitationalAcceleration,
                                  double terminalSpeed,
                                  double inclineAngle,
                                  double coefficientOfFriction) {

        double terminalXVelocity = -(Math.sin(Math.toRadians(inclineAngle)) * terminalSpeed);
        double terminalYVelocity = -(Math.cos(Math.toRadians(inclineAngle)) * terminalSpeed);

        // Represents the adjustment to the velocity by one time period.
        // The adjustment scales linearly with how
        // close the velocities are to matching and inversely with the
        // coefficient of friction, where a higher
        // coefficient represents a slower change and slower max speed.
        double gravityDXVelocity =
                -(Math.sin(Math.toRadians(inclineAngle)) * gravitationalAcceleration) *
                        (terminalSpeed * coefficientOfFriction - velocity.getMagnitude()) *
                        (1 - coefficientOfFriction);

        double gravityDYVelocity =
                (Math.cos(Math.toRadians(inclineAngle)) * gravitationalAcceleration) *
                        (terminalSpeed * coefficientOfFriction - velocity.getMagnitude()) *
                        (1 - coefficientOfFriction);

        double newXVelocity = velocity.getXChange() + gravityDXVelocity;
        double newYVelocity = velocity.getYChange() + gravityDYVelocity;

        // Don't overshoot the change and reverse direction.
        if ((terminalXVelocity - newXVelocity <= 0) != (terminalXVelocity - velocity.getXChange() <= 0)) {
            newXVelocity = terminalXVelocity;
        }
        if ((terminalYVelocity - newYVelocity <= 0) != (terminalYVelocity - velocity.getYChange() <= 0)) {
            newYVelocity = terminalYVelocity;
        }

        return new Velocity(velocity.getX(), velocity.getY(), newXVelocity, newYVelocity);
    }

    /**
     * Returns the velocity vector reflected about a wall of impact. Assumes a perfect elastic
     * collision. 
     * 
     * @param velocity The velocity of the object
     * @param inclineAngle The angle of the wall being hit. [0, 180)
     * @return A reflected velocity vector.
     */
    public static Velocity bounce (Velocity velocity, double inclineAngle) {
        Velocity wall =
                new Velocity(velocity.getX(), velocity.getY(), Math.cos(Math.toRadians(inclineAngle)), Math.sin(Math
                        .toRadians(inclineAngle)));

        Velocity reflectedVector = wall.clone();
        reflectedVector.scale(2 * velocity.getLocationDotProduct(wall) / wall.getLocationDotProduct(wall));
        reflectedVector.difference(velocity);

        return reflectedVector;
    }

    /**
     * Applies a force on an object with a given velocity and mass.
     * 
     * @param velocity The object's velocity
     * @param mass The object's mass
     * @param force The force applied to the object
     * @return The new velocity with force applied
     */
    public Velocity applyForce (Velocity velocity, double mass, Velocity force) {
        Velocity modifiableForce = force.clone();
        modifiableForce.scale(1 / mass);
        Velocity newVelocity = velocity.clone();
        newVelocity.sum(modifiableForce);

        return newVelocity;
    }

    /**
     * Applies a force on an object with a given velocity and mass. Limits the
     * maximum speed of the object.
     * 
     * @param velocity The object's velocity
     * @param mass The object's mass
     * @param force The force applied to the object
     * @param terminalSpeed The maximum speed the object may have.
     * @return The new velocity with force applied
     */
    public static Velocity applyForce (Velocity velocity,
                                     double mass,
                                     Velocity force,
                                     double terminalSpeed) {
        Velocity newVelocity = applyForce(velocity, mass, force);
        if (newVelocity.getMagnitude() > terminalSpeed) {
            newVelocity.scale(terminalSpeed / newVelocity.getMagnitude());
        }

        return newVelocity;
    }
}
