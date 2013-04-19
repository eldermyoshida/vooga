package vooga.towerdefense.action;

import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Vector;

public class TrackTarget extends Action{
	
	private Vector myHeading;
	private Location myStart;

	public TrackTarget(GameElement initiator, Location destination){
		super(initiator);
		myStart = initiator.getCenter();
		myHeading = new Vector(Vector.angleBetween(myStart, destination), 
				initiator.getAttributeManager().getAttribute(Attribute.ATTRIBUTE_CONSTANTS.MOVE_SPEED).getValue());
	}

	@Override
	public void executeAction(double elapseTime) {
		while (Vector.distanceBetween(myStart, getInitiator().getCenter()) <= 
				getInitiator().getAttributeManager().getAttribute(Attribute.ATTRIBUTE_CONSTANTS.ATTACK_RADIUS).getValue()){
				getInitiator().translate(myHeading);
		}
	}
	

}
