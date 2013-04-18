package vooga.towerdefense.gameElements;

import java.util.List;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.model.GameMap;
import vooga.towerdefense.model.Tile;


/**
 * A wave of enemy units, allows developer to control the number and types of units as well as the
 * speed at which units are spawned.
 * 
 * @author XuRui
 * @author Matthew Roy
 * 
 */

public abstract class Wave {

    protected List<Unit> myUnits;
    protected AttributeManager myAttributes;
    protected double myDuration;
    protected double mySpawnDelay;
    protected GameMap myMap;
    private double myTimer;
    private double myLastSpawnTime;
    private Tile mySpawnLocation;

    public Wave (GameMap gameMap, List<Unit> units, Tile spawnLocation, double spawnDelay,
                 double duration) {
        myUnits = units;
        myDuration = duration;
        mySpawnDelay = spawnDelay;
        myMap = gameMap;
        mySpawnLocation = spawnLocation;
        myTimer = 0;
        myLastSpawnTime = 0;
    }

    public void update (double timeElapsed) {
        if(canSpawn()) {
            Unit unit = generateUnit(getNextUnit());
            myMap.addToMap(unit, mySpawnLocation);
            myLastSpawnTime = myTimer;
        }
        myTimer += timeElapsed;
    }

    /**
     * Creates a unit based on given type and location using the wave attributes
     * @return unit created
     */
    private Unit generateUnit(Unit u) {
        //TODO: should really be a unit generator class given, not an actual unit
        return u;
    }

    public double getDuration () {
        return myDuration;
    }

    private Unit getNextUnit () {
        return myUnits.iterator().next();
    }
    
    /**
     * 
     * @return true at start of wave or if its been longer than spawn delay since last spawn
     */
    private boolean canSpawn() {
        return myTimer == 0 || (myTimer-myLastSpawnTime) > mySpawnDelay;
    }

    private void addUnit (Unit unit) {
        myUnits.add(unit);
    }
}
