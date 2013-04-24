package vooga.towerdefense.factories.actionfactories;


import java.util.List;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.actionlist.OnDeath;
import vooga.towerdefense.gameElements.GameElement;

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
