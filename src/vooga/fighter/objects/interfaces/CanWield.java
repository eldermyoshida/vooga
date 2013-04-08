package vooga.fighter.objects.interfaces;

/**
 * Represents an object that maintains a wieldable item slot
 * and can wield ItemObjects in that slot.
 * 
 * Not currently implemented.
 * 
 * @author james, alan
 * 
 */
public interface CanWield {

    /**
     * Returns the object that is currently wielded, or null if there is none.
     */
    public Wieldable getMyWieldedObject();    

    /**
     * Wields a wieldable object.
     */
    public void wield(Wieldable w);
    
    /**
     * Unwields the currently wielded object.
     */
    public void unwield();

}
