package vooga.towerdefense.action;

import java.util.List;

import vooga.towerdefense.gameElements.GameElement;

/**
 * An attack action is an action which may contain a series of subactions that act on (potentially damage) one or more targets.
 *  
 * @author XuRui
 *
 */

public abstract class ComboAttackAction extends AbstractAction {
	
	List<ComboAttackAction> myAttackMoves; //list of attack moves in attack action called by game element
	
	public ComboAttackAction(InfoBridge info,List<ComboAttackAction> attackMoves){
		super(info);
		myAttackMoves = attackMoves;
	}

	@Override
	public void execute(GameElement initiator,double elapsedTime) {
		
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
