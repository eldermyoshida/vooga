
package vooga.rts.map;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

// This class might extend sprite at some point to make it gameloop so that it can 
// be updated.
public class NodeMap {
    
    private int myWidth;
    private int myHeight;
    private Node[][] myMap;
    
    public NodeMap (int width, int height) {
        myMap = new Node[width][height];
        myWidth = width;
        myHeight = height;
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
    
    public int getWidth () {
        return myWidth;
    }
    
    public int getHeight () {
        return myHeight;
    }
    
    public void put (Node node, int x, int y) {
        myMap[x][y] = node;
    }
}
