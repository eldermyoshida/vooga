package vooga.towerdefense.action;

/**
 * A simple Action that disables itself after a certain amount of time.
 * @author JLongley
 *
 */
public class TimerAction extends Action {

	private int myDuration;
	private int myTimer;
	
	public TimerAction(int duration) {
		super();
		myTimer = 0;
		myDuration = duration;
	}
	
	@Override
	public void executeAction(double elapsedTime) {
		myTimer+=elapsedTime;
		System.out.println("Time remaining in wave: " + ((myDuration-myTimer)/1000));
		if(myTimer>myDuration)
			setEnabled(false);
	}
}
