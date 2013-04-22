package vooga.towerdefense.action;

/**
 * super class for all actions that is periodic. Means they only apply very cooldown time
 * @author Zhen Gou
 *
 */

public abstract class PeriodicAction extends Action {
	private double myTimer=0;
	private double myCD=0;
	
/**
 * MUST be called in the update method of the subclasses of periodicAction for it to work
 * @param elapsedTime
 */
	
	public void updateTimer(double elapsedTime){
		myTimer+=elapsedTime;
		
	}
	/**
	 * tells whether this action is ready e.g. more time has elapsed than the cool down since last use
	 * @return
	 */
	public boolean isReady(){
		return myTimer>=myCD;
	}
	
	/**
	 * tells the timer that this action is just used
	 */
	public void resetTimer(){
		myTimer=0;
	}
	/**
	 * set the cooldown
	 * @param cd
	 */
	
	public void setCoolDown(double cd){
		myCD=cd;
	}




}
