package gameElements;

import java.util.List;

import model.GameMap;


public abstract class Wave {
    private List<Unit> myUnits;
    private GameMap myGameMap;
    private double mySpawnDelay;
    private double myDuration;
    private double myTimeSinceLastSpawn;

    public Wave (GameMap gameMap, List<Unit> units, double spawnDelay,
                 double duration) {
        myUnits = units;
        myGameMap = gameMap;
        mySpawnDelay = spawnDelay;
        myDuration = duration;
        myTimeSinceLastSpawn = 0;
    }

    public void update (double timeElapsed) {
        myTimeSinceLastSpawn += timeElapsed;
        if (myTimeSinceLastSpawn > mySpawnDelay) {
            myGameMap.spawnUnit(getNextUnit());
            myTimeSinceLastSpawn = 0;
        }
    }
    
    public double getDuration() {
        return myDuration;
    }
    
    private Unit getNextUnit() {
        return myUnits.iterator().next();
    }
}
