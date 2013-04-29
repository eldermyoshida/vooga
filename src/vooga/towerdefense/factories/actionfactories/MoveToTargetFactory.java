package vooga.towerdefense.factories.actionfactories;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.movement.MoveToTarget;
import vooga.towerdefense.factories.ActionAnnotation;
import vooga.towerdefense.gameelements.GameElement;

/**
 * Factory that creates a MoveToTarget action, constructor needs a String
 * referencing which attribute to be used as move speed. Also call
 * buildTargetedAction to create the action INSTEAD OF buildAction.
 * 
 * @author Zhen Gou
 * 
 */
public class MoveToTargetFactory extends ActionFactory {
	private String myMoveSpeedReference;

	public MoveToTargetFactory(
			@ActionAnnotation(name = "move speed", value = "attribute") String moveSpeedReference) {
		super();
		myMoveSpeedReference = moveSpeedReference;

	}

	/*@Override
	public Action buildTargetedAction(GameElement element, GameElement target) {
		return new MoveToTarget(element.getCenter(), target.getCenter(),
				element.getAttributeManager()
						.getAttribute(myMovespeedReference));
	}*/

	@Override
	protected Action buildAction(GameElement e) {
		System.out.println("building move to target action\n\n\n\n");
		return new MoveToTarget(e.getCenter(), e.getCenter(),
				e.getAttributeManager()
						.getAttribute(myMoveSpeedReference));
		/*Action action = new Move(e.getCenter(), e
				.getAttributeManager().getAttribute(myMoveSpeedReference),
				e
				.getAttributeManager().getAttribute(AttributeConstantsEnum.DIRECTION.name()));
		return action;*/
	}

}
