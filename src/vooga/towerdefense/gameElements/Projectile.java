package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import vooga.towerdefense.action.Action;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;
import vooga.towerdefense.util.Vector;
import vooga.towerdefense.gameElements.GameElement;


/**
 * GameElement projectile that can affect other game elements.
 * 
 * @author Matthew Roy
 * 
 */
public class Projectile extends GameElement {
    private GameElement myTarget;
    private Location myTargetLocation;
    private GameElement myInitiator;
    private Vector myHeading;

    /**
     * Creates a projectile GameElement that is homing onto a single element target, and will only
     * attack that target
     * 
     * @param image
     * @param size
     * @param initiator
     * @param targetElement
     * @param actions
     * @param attributes
     */
    public Projectile (Pixmap image, Dimension size, GameElement initiator,
                       GameElement targetElement, List<Action> actions,
                       AttributeManager attributes) {
        super(image, initiator.getCenter(), size, attributes, actions);
        myTargetLocation = targetElement.getCenter();
        myInitiator = initiator;
        myHeading =
                new Vector(Vector.angleBetween(myInitiator.getCenter(), myTargetLocation),
                           initiator.getAttributeManager().getAttribute(AttributeConstants.MOVE_SPEED).getValue());
    }

    /**
     * Creates a projectile that travels towards a location.
     * If the location given is the myCenter of a GameElement, it will follow that element
     * 
     * @param image
     * @param size
     * @param initiator
     * @param targetLocation
     * @param actions
     * @param attributes
     */
    public Projectile (Pixmap image, Dimension size, GameElement initiator,
                       Location targetLocation, List<Action> actions,
                       AttributeManager attributes) {
        super(image, initiator.getCenter(), size, attributes, actions);
        myTargetLocation = targetLocation;
        myInitiator = initiator;
        myHeading = new Vector(Vector.angleBetween(myInitiator.getCenter(), myTargetLocation), 0);

    }

    /*
     * public Projectile (GameElement initiator, GameElement target,
     * List<Action> actions) { super(DEFAULT_IMAGE, initiator.getCenter(),
     * DEFAULT_SIZE, DEFAULT_ACTIONS); myAttributeManager =
     * initiator.getAttributeManager();
     * 
     * }
     * 
     * public Projectile(Location spawn,GameElement target){
     * super(DEFAULT_IMAGE,spawn,DEFAULT_SIZE,DEFAULT_ACTIONS); }
     */
    public void update (double elapsedTime) {
        // to-do mostly needs to move towards target;
    }

    /**
     * Returns a target element, or null if it is not tracking an element
     * 
     * @return
     */
    public GameElement getTarget () {
        return myTarget;
    }

    /**
     * Returns a the location the projectile is traveling to
     * 
     * @return
     */
    public Location getTargetLocation () {
        return myTargetLocation;
    }

    public void addTarget () {

    }

    public Location getAttackCenter () {
        return getCenter();
    }

}
