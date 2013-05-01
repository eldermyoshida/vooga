package vooga.towerdefense.action.actionlist;

import vooga.towerdefense.action.TargetedAction;
import vooga.towerdefense.gameelements.GameElement;
import vooga.towerdefense.model.GameMap;

/**
 * Removes a game element from the game map. Can remove target game element or
 * itself.
 * 
 * @author Matthew Roy
 * 
 */
public class RemoveGameElement extends TargetedAction {

	private GameMap myMap;
	private GameElement myElement;

	/**
     * 
     */
	public RemoveGameElement(GameMap map) {
		super();
		myMap = map;
	}

	@Override
	public void executeAction(double elapsedTime) {
		if (!getTargets().isEmpty()) {
			myElement = getTargets().get(0);
			myMap.removeGameElement(myElement);
		}
	}

}
