package vooga.towerdefense.gameElements;

import java.util.HashSet;
import java.util.List;

import vooga.towerdefense.model.GameMap;

/**
 *  A wave of enemy units, allows developer to control the number and types of units as well as the speed at which units are spawned.
 *   
 * @author XuRui
 *
 */

public abstract class Wave{
    
	private List<Unit> myUnits;
    private Attributes myAttributes;
    private int myDuration;
    
    public Wave (GameMap gameMap, List<Unit> units, double spawnDelay,
                 double duration) {
        myUnits = units;

    }

    public void update (double timeElapsed) {

    }
    
    public int getDuration () {
    	return myDuration;
    }
    
    private Unit getNextUnit() {
        return myUnits.iterator().next();
    }
    
    
    private void addUnit(Unit unit){
    	myUnits.add(unit);
    }
}
