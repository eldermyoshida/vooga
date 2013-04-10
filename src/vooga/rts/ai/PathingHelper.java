package vooga.rts.ai;

import java.util.List;
import vooga.rts.map.*;
import vooga.rts.util.Location;

public class PathingHelper {
    
    private Pathfinder myFinder;
    private GameMap myMap;
    private List<MapNode> myPath;
    private MapNode myNext;
    
    public PathingHelper (GameMap map) {
        myFinder = new AstarFinder();
        myMap = map;
    }
    
    public void constructPath (Location start, Location desired) {
        MapNode startNode = myMap.getNode(start);
        MapNode desiredNode = myMap.getNode(desired);
        constructPath(startNode, desiredNode);
    }
    
    public void constructPath (MapNode startNode, MapNode endNode) {
        myPath = myFinder.findPath(startNode, endNode, myMap);
        myNext = myPath.get(0);
        myPath.remove(0);
    }
    
    public Location getNext(Location current) {
        MapNode currentNode = myMap.getNode(current);
        return getNext(currentNode);
    }
    
    public MapNode getNext(MapNode currentNode) {
        myNext = myPath.get(0);
        myPath.remove(0);
        return myNext;
    }

    public int size () {
        return myPath.size();
    }
}
