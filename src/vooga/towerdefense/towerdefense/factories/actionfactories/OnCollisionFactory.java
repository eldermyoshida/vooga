package vooga.towerdefense.factories.actionfactories;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.OnCollision;
import vooga.towerdefense.gameelements.GameElement;

/**
 * factory that creates onCollision action, has trivial constructor
 * @author Zhen Gou
 *
 */
public class OnCollisionFactory extends ActionFactory {
	public OnCollisionFactory(){
		super();
	}

	@Override
	protected Action buildAction(GameElement e) {
		return new OnCollision(e);
	}
	

}
