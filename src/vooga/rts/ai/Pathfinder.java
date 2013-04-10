package vooga.rts.ai;

import vooga.rts.map.NodeMap;
import vooga.rts.map.MapNode;

public abstract class Pathfinder {
    
    public abstract Path calculatePath(MapNode current, MapNode destination, 
                                            NodeMap map);
}
