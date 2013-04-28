package vooga.towerdefense.factories.actionfactories;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.gameelements.GameElement;

public class AreaOfEffectPackageFactory extends ActionFactory{
	
	   
    private FindTargetsFactory myFinder;
    private FilterTargetsFactory myFilter;

	@Override
	protected Action buildAction(GameElement e) {
		
		return null;
	}
	

}
