package map;

public class MapNode {
    
    private static final int DEFAULT_VALUE = 1;
    
    private int myX;
    private int myY;
    private int myTerrain;
    
    public MapNode(int x, int y) {
        myX = x;
        myY = y;
        myTerrain = DEFAULT_VALUE;
    }
    
    public int getX() {
        return myX;
    }
    
    public int getY() {
        return myY;
    }
}
