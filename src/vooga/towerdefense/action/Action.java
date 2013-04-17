package vooga.towerdefense.action;

import vooga.towerdefense.event.EventHandler;
import vooga.towerdefense.event.evented;
import vooga.towerdefense.gameElements.GameElement;

/**
 * An Action is superclassed to define specific Actions that can be taken by game elements. 
 * This includes attacks, upgrades, path creation and anything the developer may wish to implement. 
 * Action is triggered by events handled by eventHandler.
 *  
 * @author XuRui
 *
 */

public class Action implements evented{
	
	private EventHandler myEventHandler;
	private GameElement myInitiator;
	private boolean enabled;
	private boolean complete;
	
	public Action(GameElement initiator){
		myInitiator = initiator;
	}
	
	public void initAction(){
		enabled = true;
		//initialize resources
	}
	
	public GameElement getInitiator(){
		return myInitiator;
	}
 
	public void executeAction(){
		initAction();
		//execute action
	}
		
	public boolean isComplete(){
		enabled = false;
		return complete;
	}
	
	public void markComplete(){
		complete = true;
		enabled = false;
	}
	public boolean isEnabled(){
		return enabled;
	}
	
	public void setEnabled(boolean isEnabled){
		enabled = isEnabled;
	}

	@Override
	public boolean eventTriggered() {
		return (myEventHandler.hasEvent());
		
	}

	@Override
	public void update(double elapsedTime) {
		if (eventTriggered()){
			executeAction();
		}
	}
}
