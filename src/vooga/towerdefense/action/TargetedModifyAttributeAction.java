package vooga.towerdefense.action;

import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.attributes.Attribute;
/**
 * @author Matthew Roy
 *
 */
public class TargetedModifyAttributeAction extends AbstractAction {

    GameElement myTarget;    
    
    /**
     * @param initiator 
     */
    public TargetedModifyAttributeAction (GameElement initiator, GameElement target, Attribute toModify) {
        super(initiator);
        myTarget = target;
    }

   
    @Override
    public void initAction () {
        // TODO Auto-generated method stub

    }

    
    @Override
    public void execute (double elapsedTime) {
        // TODO Auto-generated method stub

    }

}
