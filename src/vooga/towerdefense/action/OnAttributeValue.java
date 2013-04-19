package vooga.towerdefense.action;

import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.gameElements.GameElement;

/**
 * @author Matthew Roy
 *
 */
public class OnAttributeValue extends Action {

    /**
     * @param initiator
     */
    public OnAttributeValue (GameElement initiator, Attribute attributeWatched) {
        super(initiator);
        // TODO Auto-generated constructor stub
    }

    /**
     * Overrides from superclasses
     * @param elapseTime 
     */
    @Override
    public void executeAction (double elapseTime) {
        // TODO Auto-generated method stub
        getInitiator().getAttributeManager().getAttribute("Health");

    }

    /**
     * Overrides from superclasses
     * @param elapsedTime 
     */
    @Override
    public void update (double elapsedTime) {
        // TODO Auto-generated method stub

    }

}
