package vooga.towerdefense.action;

import java.util.List;

/**
 * An AbstractAction is superclassed to define specific Actions that can be taken by game elements. 
 * This includes attacks, upgrades, path creation and anything the developer may wish to implement. 
 *  
 * 
 * @author XuRui
 *
 */

public abstract class AbstractAction {
	
	public AbstractAction(){
		
	}
	
	/**
	 * Executes action as specified by developer.
	 */
	
	public abstract void execute();
	
	/**
	 * Updates action state according to elapsed time.
	 * @param elapsedTime
	 */
	public abstract void execute(double elapsedTime);
	
	
	
}
