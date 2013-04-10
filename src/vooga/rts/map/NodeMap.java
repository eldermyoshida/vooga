package vooga.rts.map;

import java.util.List;
import vooga.rts.ai.Path;
import vooga.rts.ai.Pathfinder;

public class NodeMap {
    
    private MapNode[][] myMap;
    
    public NodeMap (List<MapNode> myNodeList, int width, int height) {
        myMap = new MapNode[width][height];
    }
    
    /**
     * This function creates a path for an object to follow. 
     * 
     * @param finder
     * @param start
     * @param end
     * @return
     */
    public Path calculatePath (Pathfinder finder, MapNode start, MapNode end) {
        return finder.calculatePath(start, end, this);
    }
    
    public MapNode get (int x, int y) {
        return myMap[x][y];
    }
}
