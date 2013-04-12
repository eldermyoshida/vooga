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
	public InfoBridge getInfoBridge(){
		return myInfoBridge;
	}
	
	public abstract void execute(GameElement initiator, double elapsedTime);
	
	
	public void setCoolDown(double cd, boolean canBeDoneAgain){
		myCDManager.setCoolDown(cd, canBeDoneAgain);
	}
	
	public boolean isReady(){
		return myCDManager.isReady();
		
	}

}
