package vooga.towerdefense.gameElements;

import java.util.ArrayList;
import java.util.List;
import vooga.towerdefense.model.GameMap;
import vooga.towerdefense.model.Tile;

/**
 * 
 * Example wave. Hardcoded for testing.
 *
 */
public class ExampleWave extends Wave {

    public ExampleWave (GameMap gameMap, List<Unit> units, Tile spawnHere, double spawnDelay,
                        double duration) {
        super(gameMap, units, spawnHere, spawnDelay, duration);

        units = new ArrayList<Unit>();
        mySpawnDelay = 100;
        myDuration = 60000;
        Wave wave = new ExampleWave(gameMap, units, spawnHere, spawnDelay,
                                    duration);
    }

}
