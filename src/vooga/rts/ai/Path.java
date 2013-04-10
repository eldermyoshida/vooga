package vooga.rts.ai;


import java.util.Queue;
import vooga.rts.map.*;

/**
 * 
 * @author Challen Herzberg-Brovold
 *
 * The path class stores a path for now.
 * It will be used to get the next node in the sequence 
 * 
 */ 
public class Path {
    
    private Queue<MapNode> myPath;
    
    public Path (Queue<MapNode> path) {
        myPath = path;
    }
    
    /**
     * 
     * @return This methods will return the next node to go
     */
    public MapNode getNext() { // Still need to decide what to pass in here
        return myPath.poll();
    }
    
    
}
