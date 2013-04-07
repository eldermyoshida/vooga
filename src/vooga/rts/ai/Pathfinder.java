package ai;

import java.util.List;
import map.MapNode;

public abstract class Pathfinder {
    
    public abstract List<MapNode> findPath(MapNode current, MapNode destination);
}
