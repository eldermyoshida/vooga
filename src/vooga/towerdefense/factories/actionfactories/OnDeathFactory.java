package vooga.towerdefense.factories.actionfactories;

import java.awt.List;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.actionlist.OnDeath;
import vooga.towerdefense.gameElements.GameElement;

public class OnDeathFactory extends ActionFactory{
	public OnDeathFactory(List<Action> followups){
		super(followups);
	}
	@Override
	public Action buildAction(GameElement element){
		Action action=new OnDeath(element);
		action.addFollowUpActions(getFollowupActions());
		return action;
	}
}
