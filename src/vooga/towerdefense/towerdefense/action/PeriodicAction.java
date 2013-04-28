package vooga.towerdefense.action;

import vooga.towerdefense.attributes.Attribute;

/**
 * @author Matthew Roy
 * @author Zhen Gou
 * 
 */
public class PeriodicAction extends TargetedAction {
	private Attribute myCd;
	private double myTimer;

	public PeriodicAction(Attribute cd) {
		myCd = cd;
		resetTimer();
	}

	public void update(double elapsedTime) {
		if (isEnabled()) {
			executeAction(elapsedTime);
		}
	}

	/**
	 * 
	 * @param elapsedTime
	 */
	@Override
	public void executeAction(double elapsedTime) {
		updateTimer(elapsedTime);
		if (myTimer > myCd.getValue()) {
			updateFollowUpActions(elapsedTime);
			resetTimer();
		}

	}

	private void updateTimer(double elapsedTime) {
		myTimer += elapsedTime;
	}

	private void resetTimer() {
		myTimer = 0;
	}

}
