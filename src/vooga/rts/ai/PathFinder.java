package vooga.rts.ai;

import vooga.rts.map.NodeMap;
import vooga.rts.map.Node;

/**
 * 
 * @author Challen Herzberg-Brovold
 * 
 */
public interface PathFinder {
    
    public abstract Path calculatePath(Node start, Node finish, 
                                            NodeMap map);
}