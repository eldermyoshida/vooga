package vooga.towerdefense.gameElements;

import java.util.List;

/**
 * An AbstractAction is superclassed to define specific Actions that can be taken by game elements. 
 * E.g. Use assets (such as fire weapons), boost or kill surround game units 
 * 
 * @author XuRui
 *
 */

public abstract class AbstractAction {
	
	public AbstractAction(){
		
	}
	
	/**
	 * Executes action as specific by developer.
	 */
	
	public abstract void execute();
	
	/**
	 * Act on target units
	 */
	abstract void actOnUnitTargets();
	
	/**
	 * Act on tower targets
	 */
	abstract void actOnTowerTargets();
	
	/**
	 * Use a particular asset
	 */
	public void useAsset(Asset asset){
		asset.use();
	}


}
