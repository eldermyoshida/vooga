package vooga.rts.map;

import java.awt.Dimension;
import vooga.rts.ai.Path;
import vooga.rts.ai.PathFinder;
import vooga.rts.util.Location;

/**
 * The GameMap will be responsible for taking in the location of
 * @author Challen Herzberg-Brovold
 *
 */

// Still need to figure how to read in terrain. Also need to figure out how to 
// add obstructions to the nodes. Possibly use the GameMap to implement vision. 
public class GameMap {
    
    private int myNodeSize;
    private NodeMap myMap;
    
    /**
     * calculates how many nodes there are
     * 
     * @param mapSize This is the size of the map in pixels
     */
    public GameMap(int node, Dimension size) {
        NodeFactory factory = new NodeFactory();
        myNodeSize = node;
        myMap = factory.makeMap(myNodeSize, size);
    }    
    
    public Node getNode (Location location) {
        int x = (int) location.x/myNodeSize;
        int y = (int) location.y/myNodeSize;
        return myMap.get(x, y);
    }
    
    public Path getPath (PathFinder finder, Location start, Location finish) {
        return finder.calculatePath(getNode(start), getNode(finish), myMap);
    }
    
    public NodeMap getMap () {
        return myMap;
    }
}