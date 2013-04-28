package vooga.towerdefense.action;

/**
 * A simple Action that disables itself after a certain amount of time.
 * @author JLongley
 *
 */
public class LevelTimerAction extends Action {

	private int myTimer;
	
	public LevelTimerAction(int duration) {
		super();
		myTimer = duration;
	}
	
	@Override
	public void executeAction(double elapsedTime) {
		myTimer+=elapsedTime;
		if(myTimer>myDuration)
			setEnabled(false);
	}
}
