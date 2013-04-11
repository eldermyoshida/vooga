package vooga.rts.map;

import java.util.ArrayList;
import java.util.List;

// This class might extend sprite at some point to make it gameloop so that it can 
// be updated.
public class NodeMap {
    
    private Node[][] myMap;
    
    public NodeMap (List<Node> myNodeList, int width, int height) {
        myMap = new Node[width][height];
    }
    
    public List<Node> getNeighbors (Node current) {
        List<Node> neighbors = new ArrayList<Node>();
        int x = current.getX();
        int y = current.getY();
        for (int i = -1; i < 2; i += 2) {
            neighbors.add(get(x + i, y));
            neighbors.add(get(x, y + i));
        }
        return neighbors;
    }
    
    public Node get (int x, int y) {
        return myMap[x][y];
    }
}
