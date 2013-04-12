package vooga.towerdefense.action;

import java.util.List;

import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.util.CoolDownManager;

/**
 * An AbstractAction is superclassed to define specific Actions that can be taken by game elements. 
 * This includes attacks, upgrades, path creation and anything the developer may wish to implement. 
 *  
 * 
 * @author XuRui
 *
 */

public abstract class AbstractAction {
	private InfoBridge myInfoBridge;
	private CoolDownManager myCDManager;
	
	public AbstractAction(InfoBridge info){
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
	
	/**
	 * sets the time interval needed to elapse before it's ready again.
	 * if the boolean is set to false, the action will be in Not Ready indefinitely.
	 * @param cd
	 * @param canBeDoneAgain
	 */
	public void setCoolDown(double cd, boolean canBeDoneAgain){
		myCDManager.setCoolDown(cd, canBeDoneAgain);
	}
	
	public boolean isReady(){
		return myCDManager.isReady();
		
	}

}
