package vooga.rts.map;

/**
 * Ramp nodes connect to every node touching them.
 * @author Challen Herzberg-Brovold
 *
 */
public class RampNode extends Node {
    
    
    public RampNode (int x, int y) {
        super(x, y, -1);
    }
    
    @Override
    public boolean connectsTo (Node other) {
        return true;
    }
}
