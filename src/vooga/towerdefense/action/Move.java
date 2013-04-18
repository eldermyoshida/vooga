
package vooga.towerdefense.action;

import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.gameElements.GameElement;

/**
 * Uses the sprite move method
 * @author Matthew Roy
 *
 */
public class Move extends Action {
	private static final AttributeConstants ATTRIBUTE_CONSTANTS = new AttributeConstants();
    private Attribute myMovespeed;
    private Attribute myDirection;

    /**
     * @param initiator
     */
    public Move (GameElement initiator) {
        super(initiator);
        myMovespeed = initiator.getAttributeManager().getAttribute(ATTRIBUTE_CONSTANTS.MOVE_SPEED);
        myDirection = initiator.getAttributeManager().getAttribute(ATTRIBUTE_CONSTANTS.DIRECTION);
    }
    
    @Override
    public void executeAction(double elapsedTime) {
        getInitiator().setVelocity(myDirection.getValue(), myMovespeed.getValue());
        getInitiator().getVelocity().scale(elapsedTime);
        getInitiator().translate(getInitiator().getVelocity());
    }

}

