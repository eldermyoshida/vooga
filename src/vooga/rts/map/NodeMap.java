package vooga.rts.map;

import java.util.ArrayList;
import java.util.List;

// This class might extend sprite at some point to make it paintable/gameloop.
public class NodeMap {
    
    private MapNode[][] myMap;
    
    public NodeMap (List<MapNode> myNodeList, int width, int height) {
        myMap = new MapNode[width][height];
    }
    
    public List<MapNode> getNeighbors (MapNode current) {
        List<MapNode> neighbors = new ArrayList<MapNode>();
        int x = current.getX();
        int y = current.getY();
        for (int i = -1; i < 2; i += 2) {
            neighbors.add(get(x + i, y));
            neighbors.add(get(x, y + i));
        }
        return neighbors;
    }
    
    public MapNode get (int x, int y) {
        return myMap[x][y];
    }
}
