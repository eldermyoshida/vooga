package vooga.rts.map;

import vooga.rts.ai.Path;
import vooga.rts.ai.PathFinder;
import vooga.rts.util.Location;

/**
 * The GameMap will be responsible for taking in the location of
 * @author Challen Herzberg-Brovold
 *
 */
public class GameMap {
    
    private int myNodeSize;
    private NodeMap myMap;
    
    /**
     * calculates how many nodes there are
     * 
     * @param mapSize This is the size of the map in pixels
     */
    public GameMap(int node) {
        NodeFactory factory = new NodeFactory();
        myNodeSize = node;
        myMap = factory.makeMap(myNodeSize);
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