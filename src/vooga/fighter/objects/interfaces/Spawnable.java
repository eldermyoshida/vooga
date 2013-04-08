package vooga.fighter.objects.interfaces;

import vooga.fighter.util.Location;

/**
 * Represents objects that can be spawned.
 * @author james, alan
 *
 */
public interface Spawnable {

    /**
     * Spawns the object at a certain location.
     * @param l
     */
    public void spawn(Location l);

}
