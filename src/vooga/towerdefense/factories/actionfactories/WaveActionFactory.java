package vooga.towerdefense.factories.actionfactories;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.waveactions.WaveAction;
import vooga.towerdefense.factories.elementfactories.GameElementFactory;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.model.GameMap;

/**
 * This action factory builds a wave action.
 * 
 * @author Zhen Gou
 *
 */
public class WaveActionFactory extends ActionFactory {

	private int myNumUnits;
	private int myCooldown;
	private GameElementFactory myFactory;
	
	//action factory
	public WaveActionFactory(String numUnits, String cooldown, GameElementFactory factory) {
		myNumUnits = Integer.parseInt(numUnits);
		myCooldown = Integer.parseInt(cooldown);
		myFactory = factory;
		
	}
	
	@Override
	protected Action buildAction(GameElement e) {
		return new WaveAction(myNumUnits, myCooldown, myFactory, getMap());
	}
}
