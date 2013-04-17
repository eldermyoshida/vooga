package vooga.towerdefense.action;

import java.util.ArrayList;
import java.util.List;

import vooga.towerdefense.attributes.TargetTracker;
import vooga.towerdefense.attributes.Targetable;
import vooga.towerdefense.gameElements.GameElement;

/**
 * Action that targets a GameElement or multiple GameElements
 * 
 * @author Xu Rui
 *
 */
public class TargetedAction extends Action {
    
    protected List<Targetable> myTargets;

    public TargetedAction (GameElement initiator) {
        super(initiator);
        myTargets = new ArrayList<Targetable>();
    }
    
    @Override 
    public void executeAction(){
    	super.executeAction();

    	markComplete();
    }
    

}
