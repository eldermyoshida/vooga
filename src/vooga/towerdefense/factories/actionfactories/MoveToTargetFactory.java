package vooga.towerdefense.factories.actionfactories;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.actionlist.MoveToTarget;
import vooga.towerdefense.gameelements.GameElement;

/**
 * factory that creates a MoveToTarget action, constructor needs a String referencing 
 * which attribute to be used as move speed. Also call buildTargetedAction to create the
 * action INSTEAD OF buildAction.
 *   
 * @author Zhen Gou
 *
 */
public class MoveToTargetFactory extends ActionFactory {
	private String myMovespeedReference;
	public MoveToTargetFactory(String movespeedReference){
		super();
		myMovespeedReference=movespeedReference;
		
	}

	@Override
	@Deprecated//shouldn't be used, instead use buildTargetedAction
	protected Action buildAction(GameElement e) {
		return null;
	}
	@Override
	public Action buildTargetedAction(GameElement element, GameElement target){
		return new MoveToTarget(element.getCenter(),target.getCenter(),element.getAttributeManager().getAttribute(myMovespeedReference));
	}
	

}
