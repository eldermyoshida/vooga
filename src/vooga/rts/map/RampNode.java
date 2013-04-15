package vooga.rts.map;

import vooga.rts.util.Location;
/**
 * Ramp nodes connect to every node touching them.
 * @author Challen Herzberg-Brovold
 *
 */
public class RampNode extends Node {
    
    
    public RampNode (int x, int y, Location center) {
        super(x, y, -1, center);
    }
    
    @Override
    public boolean connectsTo (Node other) {
        return true;
    }
}
