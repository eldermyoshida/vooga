package vooga.towerdefense.factories.actionfactories;


import java.util.List;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.actionlist.OnDeath;
import vooga.towerdefense.gameElements.GameElement;

public class OnDeathFactory extends ActionFactory{
	public OnDeathFactory(List<ActionFactory> followups){
		super();
		addFollowUpActionsFactories(followups);
	}
	@Override
	public Action buildAction(GameElement element){
		Action action=new OnDeath(element);
		action.addFollowUpActions(createFollowUpActions(element));
		return action;
	}
}
