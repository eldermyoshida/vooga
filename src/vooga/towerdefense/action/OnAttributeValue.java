package vooga.towerdefense.action;

import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.gameElements.GameElement;

/**
 * @author Matthew Roy
 *
 */
public class OnAttributeValue extends Action {
    
    Attribute myMonitoredAttribute;

    /**
     * @param initiator
     */
    public OnAttributeValue (Attribute attributeWatched) {
        myMonitoredAttribute = attributeWatched;
    }

    /**
     * Overrides from superclasses
     * @param elapseTime 
     */
    @Override
    public void executeAction (double elapseTime) {
        // TODO Auto-generated method stub
        myMonitoredAttribute.getValue();

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
