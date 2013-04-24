package vooga.towerdefense.factories.actionfactories;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.tobetested.FollowPath;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.model.Path;
/**
 * Factory for creating FollowPath action, to create followPath actions of different path
 * need different instances of this factory.
 * 
 * Design tradeoff: seems bad to need different followpath factory for different paths
 * however, we don't wanna pass in Path in run time because we need to override buildAction method
 * @author Zhen Gou
 *
 */

public class FollowPathFactory extends ActionFactory{
	private Path myPath;
	
	public FollowPathFactory(Path path){
		myPath=path;
		
	}

	@Override
	protected Action buildAction(GameElement elementToMove) {
		return new FollowPath(elementToMove,myPath);
		
	}
	
	
}
