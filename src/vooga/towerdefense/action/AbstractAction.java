package vooga.towerdefense.action;

import java.util.List;

import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.util.CoolDownManager;

/**
 * An AbstractAction is superclassed to define specific Actions that can be taken by game elements. 
 * This includes attacks, upgrades, path creation and anything the developer may wish to implement. 
 *  
 * test
 * @author XuRui
 *
 */

public abstract class AbstractAction {
	private GameElement myInitiator;
	private InfoBridge myInfoBridge;
	//private CoolDownManager myCDManager;
	private boolean enabled;
	
	public AbstractAction(GameElement initiator){
		//myInfoBridge=info;	
		myInitiator = initiator;
	}
	
	public abstract void initAction();
	
	public InfoBridge getInfoBridge(){
		return myInfoBridge;
	}
	
	public abstract void execute(double elapsedTime);
	
	
	/*public void setCoolDown(double cd, boolean isOneTime){
		myCDManager.setCoolDown(cd, isOneTime);
	}
	
	public boolean isReady(){
		return myCDManager.isReady();
		
	}*/
	
	public boolean isEnabled(){
		return enabled;
	}

}
