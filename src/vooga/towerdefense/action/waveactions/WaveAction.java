package vooga.towerdefense.action.waveactions;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.actionlist.Move;
import vooga.towerdefense.factories.elementfactories.GameElementFactory;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.model.GameMap;

public class WaveAction extends Action {

	private int myUnitsRemaining;
	private int myCooldown;
	private GameElementFactory myFactory;
	private int myClock;
	private GameMap myMap;
	
	public WaveAction(int numUnits, int cooldown, GameElementFactory factory, GameMap gameMap) {
	        System.out.println(numUnits);
		myUnitsRemaining = numUnits;
		myCooldown = cooldown;
		myFactory = factory;
		myClock = 0;
		myMap = gameMap;
	}
	@Override
	public void executeAction(double elapsedTime) {
	        if (myUnitsRemaining == 0) {
		    setEnabled(false);
		} else if(myClock > myCooldown) {
			spawnUnit();
			myClock = 0;
		        
		}
	        myClock += elapsedTime;
	}
	
	private void spawnUnit() {
		GameElement unit = myFactory.createElement(myMap.getSpawnLocation());
		Move moveAction = (Move) (unit.getActions().get(1));
//		System.out.println(moveAction.isEnabled());
//		System.out.println(unit.getActions());
		System.out.println("spawning unit " + unit);
		myMap.addGameElement(unit);
		--myUnitsRemaining;
	}

}
