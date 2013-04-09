package vooga.fighter.objects.utils;

/**
 * Represents an object that maintains a wieldable item slot
 * and can wield ItemObjects in that slot.
 * 
 * To be added in future updates.
 * 
 * @author james
 * 
 */
public interface WeaponSlot {

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
