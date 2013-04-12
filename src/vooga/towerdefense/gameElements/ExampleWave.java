package vooga.towerdefense.gameElements;

import java.util.ArrayList;
import java.util.List;

import vooga.towerdefense.model.GameMap;

public class ExampleWave extends Wave {

	public ExampleWave(GameMap gameMap, List<Unit> units, double spawnDelay,
			double duration) {
		super(gameMap, units, spawnDelay, duration);

		List<Unit> units = new ArrayList<Unit>();
		mySpawnDelay = 100;
		myDuration = 60000;
		Wave wave = new ExampleWave(myModel.getMap(), units, spawnDelay,
				duration);
	}

}
