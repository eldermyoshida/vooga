package vooga.towerdefense.action;

import java.util.List;
import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.gameElements.GameElement;

/**
 * 
 * @author Matthew Roy
 *
 */
public class TargetedModifyValueAction extends Action {

    private String myTargetAttribute;
    private double myAttributeChange;
    
    public TargetedModifyValueAction (GameElement initiator, GameElement target, Attribute attributeToApply) {
        myTargetAttribute = attributeToApply.getName();
        myAttributeChange = attributeToApply.getValue();
    }
    
    public TargetedModifyValueAction (GameElement initiator, GameElement target, String valueName, double valueToAddToAttribute) {
        // TODO Auto-generated constructor stub
    }
    
    public TargetedModifyValueAction (GameElement initiator, List<GameElement> target) {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void executeAction(double elapseTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(double elapsedTime) {
		// TODO Auto-generated method stub
		
	}

}
