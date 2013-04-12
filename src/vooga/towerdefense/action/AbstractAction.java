package vooga.towerdefense.action;

import java.util.List;

import vooga.towerdefense.gameElements.GameElement;

/**
 * An AbstractAction is superclassed to define specific Actions that can be taken by game elements. 
 * This includes attacks, upgrades, path creation and anything the developer may wish to implement. 
 *  
 * 
 * @author XuRui
 *
 */

public abstract class AbstractAction {
	private infoBridge myInfoBridge;
	
	public AbstractAction(infoBridge info){
		myInfoBridge=info;
		
	}
	
	/**
	 * Executes action and inputs who initiated this action.
	 */
	
	public abstract void execute(GameElement initiator);
	
	/**
	 * executes action state according to elapsed time.
	 * @param elapsedTime
	 */
	public abstract void execute(double elapsedTime);
	
	/**
	 * executes action that needs knowledge to initiator and elapsedTime
	 * @param initiator
	 * @param elapsedTime
	 */
	public abstract void execute(GameElement initiator, double elapsedTime);
	
	
	
}
