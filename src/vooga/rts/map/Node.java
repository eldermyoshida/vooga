package vooga.rts.map;

/**
 * For now, height can either be one or zero. Eventually, there will be more
 * instance variables that describe how high it is off the ground for the sake 
 * of Pathfinding for multiple levels (flying, walking, underground, etc)l
 * 
 * @author Challen Herzberg-Brovold
 *
 */
public class Node {

    private int myHeight;
    private int myTier;
    private int myX;
    private int myY;

    public Node(int x, int y, int tier) {
        myX = x;
        myY = y;
        myTier = tier;
    }
    
    public Node(int x, int y) {
        this(y, x, 0);
    }

    public int getX() {
        return myX;
    }

    public int getY() {
        return myY;
    }

//    public void addObstruction (IObstruction obstruct) {
//       myHeight = obstruct.getHeight();
//    }
   
    public double getTier () {
        return myTier;
    }
    
    // This return statement could potentially be cleaned up, but still will wait for patter to clear  up.
    public boolean connectsTo (Node other) {
        return getTier() == other.getTier() || other.getTier() < 0;
    }
    
    public int getHeight () {
        return myHeight;
    }
}
