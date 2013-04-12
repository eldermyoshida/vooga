package vooga.rts.ai;


import java.util.Queue;
import vooga.rts.map.*;
import vooga.rts.util.Location;

/**
 * 
 * @author Challen Herzberg-Brovold
 *
 * The path class stores a path for now.
 * It will be used to get the next node in the sequence 
 * 
 */ 
public class Path {
    
    private Queue<Node> myPath;
    
    public Path (Queue<Node> path) {
        myPath = path;
    }
    
    /**
     * 
     * @return This methods will return the next node to go
     */
    public Location getNext() { 
        return myPath.poll().getCenter();
    }
    
    public int size () {
        return myPath.size();
    }
    
}
