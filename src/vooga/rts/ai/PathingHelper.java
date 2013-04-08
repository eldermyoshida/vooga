package vooga.rts.ai;

import java.util.List;
import java.util.Queue;
import vooga.rts.map.*;
import vooga.rts.util.Location;

public class PathingHelper {
    
    private Pathfinder myFinder;
    private GameMap myMap;
    private Queue<MapNode> myPath;
    
    public PathingHelper () {
        myFinder = new AstarFinder();
    }
    
    public void constructPath (Location current, Location desired) {
        MapNode currentNode = myMap.getNode(current);
        MapNode desiredNode = myMap.getNode(desired);
        myPath = myFinder.findPath(currentNode, desiredNode);
    }
    
    public MapNode getNext (Location current) {
        return null;
    }
}
