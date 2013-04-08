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
    public Queue<MapNode> findPath (MapNode start, MapNode destination, GameMap map) {
        Queue<MapNode> result;
        List<MapNode> closed = new ArrayList<MapNode>();
        List<MapNode> open = new ArrayList<MapNode>();
        open.add(start);
        Map<MapNode, MapNode> comesFrom = new HashMap<MapNode, MapNode>();
        Map<MapNode, Double> gScore = new HashMap<MapNode, Double>();
        Map<MapNode, Double> fScore = new HashMap<MapNode, Double>();
        gScore.put(start, 0.0);
        fScore.put(start, calculateHeuristic(start, destination));
        double fMax;
        double gMax;
        while (open.size() > 0) {
            MapNode current = getLowest(fScore, open);
            if (current.equals(destination)) {
                fMax = getMin(fScore);
                gMax = getMin(gScore);
                result = constructPath(comesFrom, destination);
            }
            else {
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
                    if (!current.connectsTo(neighbor)) {
                        continue;
                    }
                    if (!open.contains(neighbor) || newGScore < gScore.get(neighbor)) {
                        comesFrom.put(neighbor, current);
                        gScore.put(neighbor, newGScore);
                        fScore.put(neighbor, gScore.get(neighbor) 
                                   + calculateHeuristic(neighbor, destination));
                        if(!open.contains(neighbor)) {
                            open.add(neighbor);
                        }
                    }
                }
            }
        }
        return null;
    }

    private double getMin(Map<MapNode, Double> f) {    
        double max = Collections.max(f.values(), new Comparator<Double>(){
            @Override
            public int compare (Double o1, Double o2) {
                if (o1 > 1000000) {
                    return -1;
                }
                if (o2 > 1000000) {
                    return 1;
                }
                return o1.compareTo(o2);
            }            
        });
        return max;
    }

    private double calculateHeuristic (MapNode start, MapNode destination) {
        int dx = Math.abs(destination.getX() - start.getX());
        int dy = Math.abs(destination.getY() - start.getY());
        return start.getDistance() * (dx + dy);
    }

    private Queue<MapNode> constructPath(Map<MapNode, MapNode> comesFrom, MapNode destination) {
        Queue<MapNode> path = new LinkedList<MapNode>();
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

