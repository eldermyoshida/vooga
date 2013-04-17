package vooga.towerdefense.action.attacks;

import java.util.List;

import vooga.towerdefense.action.InfoBridge;
import vooga.towerdefense.attributes.Targetable;
import vooga.towerdefense.gameElements.GameElement;

/**
 * An attack action is an action which may contain a series of subactions that act on (potentially damage) one or more targets.
 *  
 * @author XuRui
 *
 */

public abstract class ComboAttackAction extends AbstractAction {
	
	List<TargetedAttack> myAttackMoves; //list of attack moves in attack action called by game element
	
	public ComboAttackAction(InfoBridge info,List<TargetedAttack> attackMoves){
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
