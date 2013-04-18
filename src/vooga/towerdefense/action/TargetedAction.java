package vooga.towerdefense.action;

import java.util.ArrayList;
import java.util.List;

import vooga.towerdefense.gameElements.GameElement;

/**
 * Action that targets a GameElement or multiple GameElements
 * 
 * @author Xu Rui
 *
 */
public class TargetedAction extends Action {
    
    protected List<GameElement> myTargets;

    public TargetedAction (GameElement initiator) {
        super(initiator);
        myTargets = new ArrayList<GameElement>();
    }
    
    public TargetedAction (GameElement initiator, GameElement target) {
        super(initiator);
        myTargets = new ArrayList<GameElement>();
        myTargets.add(target);
    }
    
    public TargetedAction (GameElement initiator, List<GameElement> targets) {
        super(initiator);
        myTargets = targets;
    }
    
	
	public GameElement getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void aimAtTarget(GameElement element) {
		// TODO Auto-generated method stub
		
	}

	public void actOnTarget() {
		// TODO Auto-generated method stub
		
	}

	
	public void addTarget() {
		myTargets.add(getTarget());
		
	}

	
	public List<GameElement> getTargets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void executeAction(double elapseTime) {
		
		
	}


}
