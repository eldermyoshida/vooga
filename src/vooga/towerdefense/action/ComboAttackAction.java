package vooga.towerdefense.action;

import java.util.List;

import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.model.GameMap;

/**
 * An attack action is an action which may contain a series of subactions that act on (potentially damage) one or more targets.
 *  
 * @author XuRui
 *
 */

public abstract class ComboAttackAction extends Action {
	
	List<AttackAction> myAttackMoves; //list of attack moves in attack action called by game element
	GameMap myMap;
	
	public ComboAttackAction(GameElement initiator, GameMap map, List<AttackAction> attackMoves){
		super(initiator);
		myAttackMoves = attackMoves;
	}

	//@Override
	//public void executeAction(GameElement initiator,double elapsedTime) {
		
	//}
	
	/**
	 * Get all targets for attack.
	 * 
	 * @param targets
	 */
	public abstract void getTarget(List<GameElement> targets);
	
	
	/**
	 * Act on all targets locked. 
	 * 
	 * @param targets
	 */
	public abstract void actOnTarget(List<GameElement> targets);
	
	

}
