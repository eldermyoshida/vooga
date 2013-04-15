package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import java.util.Map;
import vooga.towerdefense.action.AbstractAction;
import vooga.towerdefense.action.ComboAttackAction;
import vooga.towerdefense.attributes.Targetable;
import vooga.towerdefense.attributes.TargetableAttributes;
import vooga.towerdefense.model.Path;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;
import vooga.towerdefense.util.Sprite;
import vooga.towerdefense.util.Vector;


/**
 * used for creating enemy, boss in a tower defense game
 * 
 * @author gouzhen-1
 * 
 */
public class Unit extends GameElement implements Targetable{
    private static final double DISTANCE_OFFSET = 5;
    private Path myPath;
    private Location myDestination;
    private Map<String, State> myStates;
    private State currentState;
    private TargetableAttributes myTargetableAttributes;
    private List<AbstractAction> myActions;
    private StateManager myStateManager;

    public Unit (Location destination,
                 Pixmap image,
                 Location center,
                 Dimension size,
                 Vector velocity,
                 TargetableAttributes attributes,
                 List<AbstractAction> actions) {
        super(image, center, size, actions);
        setVelocity(velocity);
        myDestination = destination;
        myTargetableAttributes = attributes;
    }

    public void updatePath (Location destination) {
        myDestination = destination;

    }

    @Override
    public void paint (Graphics2D pen) {
        myStateManager.updateAndPaint(pen);
    }

    @Override
    public void update (double elapsedTime, Dimension bounds) {
        if (this.hasArrived(myDestination)) {
            updatePath(myPath.next());
            this.turnTo(myDestination); // turnTo should be implemented in Sprite and thus can be
                                        // used for both tower and unit
        }
        updateMove(elapsedTime);
        executeActions(elapsedTime);
    }

    /**
     * move the unit by its velocity
     * 
     * @param elapsedTime
     */

    private void updateMove (double elapsedTime) {
        Vector toMove = new Vector(getVelocity());
        toMove.scale(elapsedTime);
        this.translate(toMove);
    }

    private void executeActions (double elapsedTime) {
        for (AbstractAction act : myActions) {
            act.execute(elapsedTime);

        }
    }

    /**
     * check whether this unit has arrived at the location specified (within some radius of the
     * location)
     * 
     * @param destination
     * @return
     */
    private boolean hasArrived (Location destination) {
        return destination.distance(getCenter()) < DISTANCE_OFFSET;

    }

    public void setPath (Path path) {
        myPath = path;
    }

    /**
     * for model/menu to get info about this unit e.g. descriptions to show to the player
     * 
     * @return
     */
    public String getInfo () {
        return "TO-DO"; // temporarily using String, maybe need a info class to handle more
                        // complicated task
    }

    @Override
    public void takeDamage (double attack) {
        myTargetableAttributes.getHealth().decrement(attack);

    }

    @Override
    public boolean isAlive () {
        return myTargetableAttributes.getHealth().getValue() > 0;
    }

    @Override
    public TargetableAttributes getTargetableAttributes () {
        return myTargetableAttributes;

    }

}
