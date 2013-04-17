package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import vooga.towerdefense.action.Action;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.model.Path;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;
import vooga.towerdefense.util.Vector;

/**
 * used for creating enemy, boss in a tower defense game
 * 
 * @author gouzhen-1
 * 
 */
public class UnitG extends GameElement {
	private static final AttributeConstants myAttributeConstants = new AttributeConstants();
	private static final double DISTANCE_OFFSET = 5;
	private Path myPath;
	private Location myDestination;
	private List<Action> myActions;
	private StateManager myStateManager;

	public UnitG(Location destination, Pixmap image, Location center,
			Dimension size, Vector velocity, AttributeManager attributes,
			List<Action> actions) {
		super(image, center, size, attributes, actions);
		setVelocity(velocity);
		myDestination = destination;

	}

	public void updatePath(Location destination) {
		myDestination = destination;

	}

	@Override
	public void paint(Graphics2D pen) {
		myStateManager.updateAndPaint(pen);
	}

	@Override
	public void update(double elapsedTime, Dimension bounds) {
		if (this.hasArrived(myDestination)) {
			updatePath(myPath.next());
			this.turnTo(myDestination); // turnTo should be implemented in
										// Sprite and thus can be
										// used for both tower and unit
		}
		updateMove(elapsedTime);
		updateActions(elapsedTime);
	}

	/**
	 * move the unit by its velocity
	 * 
	 * @param elapsedTime
	 */

	private void updateMove(double elapsedTime) {
		Vector toMove = new Vector(getVelocity());
		toMove.scale(elapsedTime);
		this.translate(toMove);
	}

	private void updateActions(double elapsedTime) {
		for (Action act : myActions) {
			act.update(elapsedTime);

		}
	}

	/**
	 * check whether this unit has arrived at the location specified (within
	 * some radius of the location)
	 * 
	 * @param destination
	 * @return
	 */
	private boolean hasArrived(Location destination) {
		return destination.distance(getCenter()) < DISTANCE_OFFSET;

	}

	public void setPath(Path path) {
		myPath = path;
	}

	/**
	 * for model/menu to get info about this unit e.g. descriptions to show to
	 * the player
	 * 
	 * @return
	 */
	public String getInfo() {
		return "TO-DO"; // temporarily using String, maybe need a info class to
						// handle more
						// complicated task
	}

	
	public void takeDamage(double attack) {
		getAttributeManager().getAttribute(myAttributeConstants.HEALTH)
				.modifyValue(-attack);

	}

	
	public boolean isAlive() {
		return getAttributeManager().getAttribute(myAttributeConstants.HEALTH)
				.getValue() > 0;
	}

}
