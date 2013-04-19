package vooga.towerdefense.action;

import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Vector;

public class TrackTarget extends Action{
	
	private Vector myHeading;
	private Location myStart;
	private Location myTarget;
	private Attribute myMoveSpeed;
	private boolean following;

	public TrackTarget(GameElement initiator, Location destination, Attribute movespeed){
		super(initiator);
		myMoveSpeed = movespeed;
		following = true;
		myStart = initiator.getCenter();
		myTarget = destination;
		myHeading = new Vector(Vector.angleBetween(myStart, destination), 
				initiator.getAttributeManager().getAttribute(AttributeConstants.MOVE_SPEED).getValue());
	}
	
	public void update(double elapsedTime) {
		if(following) {
			executeAction(elapsedTime);
		}
	}

	@Override
	public void executeAction(double elapsedTime) {
		myHeading = new Vector(myStart, myTarget);
		myHeading.scale(myHeading.getMagnitude()/myMoveSpeed.getValue());
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
