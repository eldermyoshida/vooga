package vooga.towerdefense.gameElements;

import java.util.List;
import vooga.towerdefense.attributes.Attributes;
import vooga.towerdefense.model.GameMap;


/**
 * A wave of enemy units, allows developer to control the number and types of units as well as the
 * speed at which units are spawned.
 * 
 * @author XuRui
 * 
 */

public abstract class Wave {

    protected List<Unit> myUnits;
    protected Attributes myAttributes;
    protected double myDuration;
    protected double mySpawnDelay;

    public Wave (GameMap gameMap, List<Unit> units, double spawnDelay,
                 double duration) {
        myUnits = units;
        myDuration = duration;
        mySpawnDelay = spawnDelay;

    }

    public void update (double timeElapsed) {

    }

    public double getDuration () {
        return myDuration;
    }

    private Unit getNextUnit () {
        return myUnits.iterator().next();
    }

    private void addUnit (Unit unit) {
        myUnits.add(unit);
    }
}
