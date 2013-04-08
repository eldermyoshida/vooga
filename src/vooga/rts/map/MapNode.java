package vooga.rts.map;

import java.util.ArrayList;
import java.util.List;
import vooga.rts.gamedesign.sprite.map.Terrain;

public class MapNode {
    
    private List<Terrain> myTerrain;
    private int myHeight;
    /* X and Y are relative to the width of the map as defined by the number of 
     * nodes.
     */
    private int myX;
    private int myY;
    
    public MapNode(int x, int y) {
        myX = x;
        myY = y;
        myHeight = 0;
        myTerrain = new ArrayList<Terrain>();
    }
    
    public int getX() {
        return myX;
    }
    
    public int getY() {
        return myY;
    }
    
    /**
     * Adds terrain to this map node for the purposes of pathing
     * @param terrain
     */
    public void add (Terrain terrain) {
        myTerrain.add(terrain);
        if (terrain.getLevel() > myHeight) {
            myHeight = terrain.getLevel();
        }
    }
    
    
}
