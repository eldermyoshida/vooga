package vooga.towerdefense.factories.actionfactories;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.actionlist.RemoveGameElement;
import vooga.towerdefense.gameElements.GameElement;

/**
 * factory for remove element action
 * @author Zhen Gou
 *
 */
public class RemoveElementFactory extends ActionFactory {
	public RemoveElementFactory(){
		
	}
	@Override
	public Action buildAction(GameElement element){
		return new RemoveGameElement(getMap(),element);
	}



}
