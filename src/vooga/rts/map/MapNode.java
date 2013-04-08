package vooga.rts.map;

import java.util.ArrayList;
import java.util.List;
import vooga.rts.gamedesign.sprite.map.Terrain;
import vooga.rts.util.Location;

public class MapNode {

    private double myDistance = 10;
    private List<Terrain> myTerrain;
    private int myHeight;
    /* X and Y are relative to the width of the map as defined by the number of 
     * nodes.
     */
    private Location myLocation;
    private int myX;
    private int myY;

    public MapNode(int x, int y, int size, int height) {
        myLocation = new Location(x,y);
        myDistance = size;
        myHeight = height;
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
    
    public Location getLocation () {
        return myLocation;
    }
    
    public double getDistance () {
        return myDistance;
    }
   
    public double getHeight () {
        return myHeight;
    }
    public boolean connectsTo (MapNode other) {
        return getHeight() == other.getHeight() || getHeight() == 0 || 
                other.getHeight() == 0;
    }
}
