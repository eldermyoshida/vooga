package vooga.towerdefense.action;

import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.model.GameMap;


/**
 *  Attack action series launched by a GameElement, defined by its parent follow up actions.
 * 
 * @author XuRui
 * @author Matthew Roy
 * @author Zhen Gou
 * 
 */
public class AttackAction extends PeriodicAction {
    
    public AttackAction (GameMap map, GameElement initiator) {
        setCoolDown(initiator.getAttributeManager()
                .getAttribute(AttributeConstants.ATTACK_INTERVAL).getValue());
    }
    
    /**
     * Executes attack sequence by calling parent follow up actions. 
     */
    @Override
    public void executeAction (double elapsedTime) {
        updateTimer(elapsedTime);
        if (isReady()) {
            for (Action a: getFollowUpActions()){
            	a.update(elapsedTime);
            }
            resetTimer();
        }

    }

}
