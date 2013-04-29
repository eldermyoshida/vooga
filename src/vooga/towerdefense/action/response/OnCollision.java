package vooga.towerdefense.action.response;

import vooga.towerdefense.action.TargetedAction;
import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.attributes.AttributeConstantsEnum;
import vooga.towerdefense.gameelements.GameElement;
import vooga.towerdefense.model.GameMap;

/**
 * Defines actions on collision; after collision is detected, follow up actions
 * are executed. Added as a parent action for all game elements that collide
 * with another game element.
 * 
 * @author XuRui
 * 
 */
public class OnCollision extends TargetedAction {

	private Attribute myTargetAffiliationID;
	private GameElement myInitiator;
	private GameMap myMap;

	public OnCollision(GameMap map, GameElement initiator,
			Attribute targetAffiliation) {
		myInitiator = initiator;
		myTargetAffiliationID = targetAffiliation;
		myMap = map;
	}

	@Override
	public void update(double elapsedTime) {
		if (collisionDetected()) {
			executeAction(elapsedTime);
			updateFollowUpActions(elapsedTime);
		}
	}

	@Override
	public void executeAction(double elapsedTime) {
		System.out.printf("on collision targets are %d\n", getTargets().size());
		// updateTargetedFollowUpActions(getTargets());
		//myMap.removeGameElement(getTargets().get(0));
		//myMap.removeGameElement(myInitiator);
	}

	/**
	 * Checks if collision with any of the valid targets is detected.
	 * 
	 * @return
	 */
	public boolean collisionDetected() {
		System.out.printf("collision detected found %d targets\n", getTargets()
				.size());
		for (GameElement target : getTargets()) {
			System.out.println(myInitiator.intersects(target));
			if (myInitiator.intersects(target) || checkTargetMatch(target)) {
				System.out.println("COLLISION DETECTED!!!!!!");
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if target matches with the affiliationID this collision action is
	 * designed to handle.
	 * 
	 * @param target
	 * @return
	 */
	private boolean checkTargetMatch(GameElement target) {
		// System.out.println(myTargetAffiliationID.getValue());
		// System.out.println(target.getAttributeManager().getAttribute(AttributeConstantsEnum.AFFILIATION.getStatusCode()).getValue());
		return (target
				.getAttributeManager()
				.getAttribute(
						AttributeConstantsEnum.AFFILIATION.getStatusCode())
				.getValue() == myTargetAffiliationID.getValue());
	}
}
