package vooga.towerdefense.action;

import java.util.List;
import vooga.towerdefense.attributes.NumericalAttribute;
import vooga.towerdefense.gameElements.GameElement;

public class TargetedModifyValueAction extends TargetedAction {

    private String myTargetAttribute;
    private double myAttributeChange;
    
    public TargetedModifyValueAction (GameElement initiator, GameElement target, NumericalAttribute attributeToApply) {
        super(initiator, target);
        myTargetAttribute = attributeToApply.getName();
        myAttributeChange = attributeToApply.getValue();
    }
    
    public TargetedModifyValueAction (GameElement initiator, GameElement target, String valueName, double valueToAddToAttribute) {
        super(initiator, target);
        // TODO Auto-generated constructor stub
    }
    
    public TargetedModifyValueAction (GameElement initiator, List<GameElement> target) {
        super(initiator, target);
        // TODO Auto-generated constructor stub
    }

}
