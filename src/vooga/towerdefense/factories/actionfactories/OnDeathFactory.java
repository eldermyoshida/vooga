package vooga.towerdefense.factories.actionfactories;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.actionlist.OnDeath;
import vooga.towerdefense.gameElements.GameElement;
/**
 * factory for creating OnDeathFactory
 * @author Zhen Gou
 *
 */
public class OnDeathFactory extends ActionFactory{
	public OnDeathFactory(){
		super();
	}
	@Override
	public Action buildAction(GameElement element){
		Action action=new OnDeath(element);
		return action;
	}
}
