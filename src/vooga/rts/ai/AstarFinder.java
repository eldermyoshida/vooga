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
import vooga.rts.map.NodeMap;

/**
 * 
 * @author Challen Herzberg-Brovold, Jonno Schmidt
 *
 */
public class AstarFinder extends Pathfinder {
    
    @Override
    public Path calculatePath (MapNode start, MapNode finish, NodeMap map) {
        Path result = null;
        List<MapNode> close = new ArrayList<MapNode>();
        List<MapNode> open = new ArrayList<MapNode>();
        open.add(start);
        Map<MapNode, MapNode> comesFrom = new HashMap<MapNode, MapNode>();
        Map<MapNode, Double> gScore = new HashMap<MapNode, Double>();
        Map<MapNode, Double> fScore = new HashMap<MapNode, Double>();
        gScore.put(start, 0.0);
        fScore.put(start, calculateHeuristic(start, finish));
        double fMax = 0;
        double gMax = 0;
        while (open.size() > 0) {
            MapNode current = getLowest(fScore, open);
            if (current.equals(finish)) {
                result  =  new Path(constructPath(comesFrom, finish));
                break;
            }
            open.remove(current);
            close.add(current);
            for (MapNode neighbor: map.getNeighbors(current)) {
                if (neighbor == null) {
                    continue;
                }
                double newGscore = gScore.get(current) + 1;
                if (close.contains(neighbor) && newGscore >= gScore.get(neighbor)) {
                    continue;
                }
                if (!open.contains(neighbor) || newGscore < gScore.get(neighbor)) {
                    comesFrom.put(neighbor, current);
                    gScore.put(neighbor, newGscore);
                    fScore.put(neighbor, gScore.get(neighbor) +
                               calculateHeuristic(neighbor, finish));
                    if (!open.contains(neighbor)) {
                        if (!(neighbor.getHeight() > 0)) {
                            open.add(neighbor);
                        }
                    }
                }
            }
        }       
        return result; //At some point, there will be a catch so it just returns to the closest node to the desired one.
    }

    private double calculateHeuristic (MapNode start, MapNode finish) {
        int dx = Math.abs(finish.getX() - start.getX());
        int dy = Math.abs(finish.getY() - start.getY());
        return dx + dy;
    }

    private Queue<MapNode> constructPath(Map<MapNode, MapNode> comesFrom, MapNode finish) {
        Queue<MapNode> path = new LinkedList<MapNode>();
        if (comesFrom.containsKey(finish)) {
            path.addAll(constructPath(comesFrom, comesFrom.get(finish)));
            path.add(finish);
        }
        else {
            path.add(finish);
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

