package vooga.rts.gamedesign.sprite;

import java.awt.Dimension;
import java.awt.Graphics2D;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import vooga.rts.util.ThreeDimension;
import vooga.rts.util.Vector;


/**
 * This class represents Sprites that can be attacked (have health value),
 * can move (have velocity value), and is belonged to a certain team (have
 * team ID).
 *
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 *
 */
public class GameEntity extends GameSprite {
    private Vector myVelocity;

    private int myMaxHealth;
    private int myCurrentHealth;

    private int myTeamID;

    private Vector myOriginalVelocity;

    public GameEntity (Pixmap image, Location center, Dimension size, int teamID, int health) {
        super(image, center, size);
        myMaxHealth = health;
        myCurrentHealth = myMaxHealth;
        myTeamID = teamID;

        //ALERT THIS IS JUST FOR TESTING
        myOriginalVelocity = new Vector(0,0);
        myVelocity = new Vector(0,0);
    }

    /**
     * Returns shape's velocity.
     */
    public Vector getVelocity () {
        return myVelocity;
    }

    /**
     * Resets shape's velocity.
     */
    public void setVelocity (double angle, double magnitude) {
        myVelocity = new Vector(angle, magnitude);
    }

    public int getHealth() {
        return myCurrentHealth;
    }

    public void setHealth(int health) {
        myCurrentHealth = health;
    }

    /**
     * Returns the teamID the shape belongs to.
     */
    public int getTeamID(){
        return myTeamID;
    }

    /**
     * Rotates the Unit by the given angle.
     * @param angle
     */
    public void turn(double angle){
        myVelocity.turn(angle);
    }
    /**
     * Translates the current center by vector v
     * @param v
     */
    public void translate(Vector v){
        getCenter().translate(v);
    }

    /**
     * Reset shape back to its original values.
     */
    @Override
    public void reset () {
        super.reset();
        myVelocity = myOriginalVelocity;
    }
    /**
     * Moves the Unit only. Updates first the angle the Unit is facing,
     * and then its location.
     * Possible design choice error. 
     */
    public void move (Location loc){
        double magnitude = getCenter().difference(loc).getMagnitude();
        double angle = getCenter().difference(loc).getDirection();

        turn(angle);
        setVelocity(angle, magnitude);
    }


    /**
     * Updates the shape's location.
     */
    //TODO: make Velocity three dimensional...
    public void update (double elapsedTime) {
        if(!isVisible()) return;
        Vector v = new Vector(myVelocity);
        v.scale(elapsedTime);
        translate(v);
    }

    public void changeHealth(int change) {
        myCurrentHealth -= change;
    }

    /**
     * Checks to see if an RTSprite is dead.
     * @return true if the RTSprite has been killed and true if the RTSprite 
     * is still alive.
     */
    public boolean isDead() {
        return myCurrentHealth <= 0;
    }

    public void die(){
        myCurrentHealth = 0;
    }

    public void paint(Graphics2D pen) {
        if (!isDead()) {
            super.paint(pen);
        }
    }

}

