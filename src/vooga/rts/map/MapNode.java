package vooga.rts.map;

import java.util.ArrayList;
import java.util.List;

public class MapNode {

    private int myHeight;
    private int myX;
    private int myY;

    public MapNode(int x, int y, int height) {
        myX = x;
        myY = y;
        myHeight = height;
    }
    
    public MapNode(int x, int y) {
        this(y, x, 0);
    }

    public int getX() {
        return myX;
    }

    public int getY() {
        return myY;
    }

    public void addObstruction (IObstruction obstruct) {
       myHeight = obstruct.getHeight();
    }
   
    public double getHeight () {
        return myHeight;
    }
    
    public boolean connectsTo (MapNode other) {
        return getHeight() == other.getHeight() || getHeight() == 0 || 
                other.getHeight() == 0;
    }
}
