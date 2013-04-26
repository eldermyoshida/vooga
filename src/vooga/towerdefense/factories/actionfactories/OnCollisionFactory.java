package vooga.towerdefense.factories.actionfactories;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.OnCollision;
import vooga.towerdefense.gameElements.GameElement;

/**
 * factory that creates onCollision action, has trivial constructor
 * @author Zhen Gou
 *
 */
public class OnCollisionFactory extends ActionFactory {

	@Override
	protected Action buildAction(GameElement e) {
		return new OnCollision(e);
	}
	

}
