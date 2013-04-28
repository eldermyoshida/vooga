package vooga.towerdefense.action.actionlist;

import vooga.towerdefense.action.TargetedAction;
import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.gameelements.GameElement;


/**
 * Modify a specified attribute value.
 * 
 * @author Matthew Roy
 */
public class ModifyAttributeValue extends TargetedAction {

    private Attribute myAppliedAttribute;
    private String myTargetAttribute;

    public ModifyAttributeValue (Attribute attributeToApply, String targetAttributeName) {
        super();
        myTargetAttribute = targetAttributeName;
        myAppliedAttribute = attributeToApply;

    }

    /**
     * applies the modify attribute value to all the given elements
     * Overrides from superclasses
     * 
     * @param elapsedTime
     */
    public void executeAction (double elapsedTime) {
        double modifier = myAppliedAttribute.getValue();
        for (GameElement e : getTargets()) {
            Attribute toChange = e.getAttributeManager().getAttribute(myTargetAttribute);
            if (toChange != null) {
                toChange.modifyValue(modifier);
            }
        }
    }

}
