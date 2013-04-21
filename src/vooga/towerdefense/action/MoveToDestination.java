package vooga.towerdefense.action;

import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Vector;

public class MoveToDestination extends Action{
	
	private Vector myHeading;
	private Location myStart;
	private Location myTarget;
	private Attribute mySpeed;
	private boolean following;

	public MoveToDestination(Location destination, Location start, Attribute movespeed){
		mySpeed = movespeed;
		following = true;
		myStart = start;
		myTarget = destination;
		myHeading = new Vector(Vector.angleBetween(myStart, destination), movespeed.getValue());
	}
	
	public void update(double elapsedTime) {
		if(following) {
			executeAction(elapsedTime);
		}
	}

	@Override
	public void executeAction(double elapsedTime) {
		myHeading = new Vector(myStart, myTarget);
		myHeading.scale(myHeading.getMagnitude()/mySpeed.getValue());
		myHeading.scale(elapsedTime);
		if (myStart.distance(myTarget) < myHeading.getMagnitude()) {
			following = false;
			myStart.setLocation(myTarget);
		}
		else {
			myStart.translate(myHeading);
		}
	}
	

}
