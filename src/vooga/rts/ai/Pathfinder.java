package vooga.rts.ai;

import java.util.Queue;
import vooga.rts.map.GameMap;
import vooga.rts.map.MapNode;

public abstract class Pathfinder {
    
    public abstract Queue<MapNode> findPath(MapNode current, MapNode destination, 
                                            GameMap map);
}
