package vooga.rts.ai;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import vooga.rts.map.GameMap;
import vooga.rts.map.MapNode;


public class AstarFinder extends Pathfinder {
    
    @Override
    public List<MapNode> findPath (MapNode start, MapNode destination, GameMap map) {
        List<MapNode> result = null;
        List<MapNode> closed = new ArrayList<MapNode>();
        List<MapNode> open = new ArrayList<MapNode>();
        open.add(start);
        Map<MapNode, MapNode> comesFrom = new HashMap<MapNode, MapNode>();
        Map<MapNode, Double> gScore = new HashMap<MapNode, Double>();
        Map<MapNode, Double> fScore = new HashMap<MapNode, Double>();
        gScore.put(start, 0.0);
        fScore.put(start, calculateHeuristic(start, destination));
        double fMax = 0;
        double gMax = 0;
        while (open.size() > 0) {  
            MapNode current = getLowest(fScore, open);
          
            if (current.equals(destination)) {
                fMax = getMin(fScore);
                gMax = getMin(gScore);
                return constructPath(comesFrom, destination);
            }
            open.remove(current);
            closed.add(current);
            List<MapNode> neighbors = map.getNeighbors(current);
            for (MapNode neighbor: neighbors) {
                if (neighbor == null) {
                    continue;
                }
                double newGScore = gScore.get(current) + current.getDistance();
                if (closed.contains(neighbor) && newGScore >= gScore.get(neighbor)) {
                    continue;
                }
                if (!open.contains(neighbor) || newGScore < gScore.get(neighbor)) {
                    comesFrom.put(neighbor, current);
                    gScore.put(neighbor, newGScore);
                    fScore.put(neighbor, gScore.get(neighbor) 
                               + calculateHeuristic(neighbor, destination));
                    if(!open.contains(neighbor) ){
                        if(!(neighbor.getHeight() > 0)) {
                            open.add(neighbor);
                        }   
                    }
                }

            }
        }
        return result;
    }

    private double getMin(Map<MapNode, Double> f) {
        double min = 0;
        for(MapNode key: f.keySet()){
            if (f.get(key) < min) {
                min = f.get(key);
            }
        }
        return min;
    }

    private double calculateHeuristic (MapNode start, MapNode destination) {
        int dx = Math.abs(destination.getX() - start.getX());
        int dy = Math.abs(destination.getY() - start.getY());
        return start.getDistance() * (dx + dy);
    }

    private List<MapNode> constructPath(Map<MapNode, MapNode> comesFrom, MapNode destination) {
        List<MapNode> path = new LinkedList<MapNode>();
        if (comesFrom.containsKey(destination)) {
            path.addAll(constructPath(comesFrom, comesFrom.get(destination)));
            path.add(destination);
        }
        else {
            path.add(destination);
        }
        return path;
    }
    
    private MapNode getLowest(Map<MapNode, Double> fScore, List<MapNode> from) {
        MapNode minNode = from.get(0);
        double minF = fScore.get(minNode);
        for (int i = 1; i < from.size(); i++) {
            MapNode current = from.get(i);
            double f = fScore.get(current);
            if (f < minF) {
                minNode = current;
                minF = f;
            }
        }
        return minNode;
    }
   
}

