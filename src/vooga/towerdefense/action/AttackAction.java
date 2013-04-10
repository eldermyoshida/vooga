package vooga.towerdefense.action;

import java.util.List;

/**
 * An attack action is an action which may contain a series of subactions that act on (potentially damage) one or more targets.
 *  
 * @author XuRui
 *
 */

public abstract class AttackAction extends AbstractAction {
	
	List<AttackAction> myAttackMoves; //list of attack moves in attack action called by game element
	
	public AttackAction(List<AttackAction> attackMoves){
		myAttackMoves = attackMoves;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(double elapsedTime) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Get all targets for attack.
	 * 
	 * @param targets
	 */
	public abstract void getTarget(List<Targetable> targets);
	
	
	/**
	 * Act on all targets locked. 
	 * 
	 * @param targets
	 */
	public abstract void actOnTarget(List<Targetable> targets);
	
	

}
