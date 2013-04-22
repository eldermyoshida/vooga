package vooga.towerdefense.action;

import java.util.List;
import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.gameElements.GameElement;


/**
 * 
 * @author Matthew Roy
 * 
 */
public class ModifyAttributeValue extends Action {

    private Attribute myAppliedAttribute;
    private String myTargetAttribute;

    public ModifyAttributeValue (Attribute attributeToApply, String targetAttributeName) {
        myTargetAttribute = targetAttributeName;
        myAppliedAttribute = attributeToApply;
    }

    @Override
    public void executeAction (double elapseTime) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update (double elapsedTime) {
        // TODO Auto-generated method stub

    }

}
