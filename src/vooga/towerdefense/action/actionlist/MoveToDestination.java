package vooga.towerdefense.action.actionlist;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Vector;


/**
 * Action to move from one location to another. 
 * 
 * @author Matthew Roy
 * @author Xu Rui
 *
 */
public class MoveToDestination extends Action{
	
	private Vector myHeading;
	private Location myCenter;
	private Location myDestination;
	private Attribute mySpeed;

	public MoveToDestination(Location start, Location destination, Attribute movespeed){
		mySpeed = movespeed;
		myCenter = start;
		myDestination = destination;
		myHeading = new Vector(Vector.angleBetween(myCenter, destination), movespeed.getValue());
	}

	@Override
	public void executeAction(double elapsedTime) {
        Vector v = new Vector(myHeading.getDirection(), mySpeed.getValue());
        v.scale(elapsedTime / 1000);
        myCenter.translate(v);
		if (myCenter.distance(myDestination) < myHeading.getMagnitude()) {
			setEnabled(false);
			myCenter.setLocation(myDestination);
		}
		else {
			myCenter.translate(myHeading);
		}
	}
	

}
