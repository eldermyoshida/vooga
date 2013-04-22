package vooga.towerdefense.action;

import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.attributes.Attribute;
/**
 * 
 * Finds the attribute in the target object and sets it to the attribute given
 * If the target doesn't have the attribute, it places the new attribute in the target
 * 
 * e.g. replace a tower's missiles with pebbles 
 * 
 * @author Matthew Roy
 *
 */
public class TargetedModifyAttributeAction extends Action{

    GameElement myTarget;
    Attribute myTargetAttribute;
    
    /**
     * @param initiator 
     */
    public TargetedModifyAttributeAction (GameElement target, Attribute toModify) {
        myTarget = target;
        myTargetAttribute = toModify;
    }

    
    @Override
    public void initAction () {
        Attribute targetsAttribute = myTarget.getAttributeManager().getAttribute(myTargetAttribute.getName());
        if(targetsAttribute != null) {
            targetsAttribute.setValue(myTargetAttribute.getValue());
        }
        else {
            myTarget.getAttributeManager().addAttribute(myTargetAttribute);
        }
    }

    
    @Override
    public void executeAction(double elapsedTime) {
        // TODO Auto-generated method stub

    }


	@Override
	public void update(double elapsedTime) {
		// TODO Auto-generated method stub
		
	}

}
