package vooga.rts.map;

/**
 * This class will be used to calculate pathing for multiple story maps.
 * It will keep track of which nodes are passable at a given level, simplifying
 * the path finding to 1's (passable) and 0's (unpassable). In this case, the
 * given level refers to a unit's specific height above the ground (eg. ground
 * units vs. flying units).
 * Essentially, this class will convert the map into layers of arrays which 
 * represent the passability of mapnodes at a given height
 * This will most likely take the place of the NodeMap in the PathFinder.
 * 
 * @author Challen Herzberg-Brovold
 *
 */
public class GridManager {

    
}
