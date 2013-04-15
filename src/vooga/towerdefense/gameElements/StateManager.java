package vooga.towerdefense.gameElements;

import java.awt.Graphics2D;
import java.util.List;


/**
 * manages states of a unit, need to be subclassed
 * 
 * @author gouzhen-1
 * 
 */

public abstract class StateManager {
    private Unit myUnit;

    public StateManager (Unit unit) {
        myUnit = unit;
    }

    public abstract void updateAndPaint (Graphics2D pen);

    public Unit getUnit () {
        return myUnit;
    }

}
