package vooga.towerdefense.factories.actionfactories;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.TimerAction;
import vooga.towerdefense.factories.ActionAnnotation;
import vooga.towerdefense.gameelements.GameElement;

public class TimerActionFactory extends ActionFactory {
	
	private int myDuration;
	public TimerActionFactory(@ActionAnnotation(name = "duration", value = "int") String duration) {
		myDuration = Integer.parseInt(duration);
	}

	@Override
	protected Action buildAction(GameElement e) {
		return new TimerAction(myDuration);
	}

}
