package vooga.rts.ai;

import java.util.List;
import vooga.rts.map.GameMap;
import vooga.rts.map.MapNode;

public abstract class Pathfinder {
    
    public abstract List<MapNode> findPath(MapNode current, MapNode destination, 
                                            GameMap map);
}
