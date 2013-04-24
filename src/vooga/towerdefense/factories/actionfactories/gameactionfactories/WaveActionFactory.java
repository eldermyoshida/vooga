package vooga.towerdefense.factories.actionfactories.gameactionfactories;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.waveactions.WaveAction;
import vooga.towerdefense.factories.GameElementFactory;
import vooga.towerdefense.factories.actionfactories.ActionFactory;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.model.GameMap;

public class WaveActionFactory extends ActionFactory {

	private int myNumUnits;
	private int myCooldown;
	private GameElementFactory myFactory;
	private GameMap myMap;
	
	public WaveActionFactory(int numUnits, int cooldown, GameElementFactory factory, GameMap map) {
		myNumUnits = numUnits;
		myCooldown = cooldown;
		myFactory = factory;
		myMap = map;
		
	}
	@Override
	protected Action buildAction(GameElement e) {
		return new WaveAction(myNumUnits, myCooldown, myFactory, myMap);
	}
}
