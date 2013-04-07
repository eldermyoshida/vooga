package vooga.rts.map;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private List<MapNode> myMap;
    
    // Eventually, this will ideally read in a map file of sort to create the map.
    // Currently just makes a square map of nodes from 
    public GameMap(int height, int width) { 
       myMap = new ArrayList<MapNode>();
       for (int i = 0; i < width; i++) {
           for (int j = 0; j < height; j++) {
               myMap.add(new MapNode(i, j));
           }
       }
    }    
}
