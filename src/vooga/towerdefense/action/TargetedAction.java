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
public class TargetedAction extends Action implements TargetTracker {
    
    protected List<Targetable> myTargets;

    public TargetedAction (GameElement initiator) {
        super(initiator);
        myTargets = new ArrayList<Targetable>();
    }
    
    @Override 
    public void executeAction(){
    	super.executeAction();
    	addTargetsInRange();
    	aimAtTarget();
    	actOnTarget();
    	markComplete();
    }
    
	@Override
	public void addTargetsInRange() {
		//How to find targets in range? 
	}

	@Override
	public void aimAtTarget() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actOnTarget() {
		// TODO Auto-generated method stub
	}


}
