package vooga.fighter.objects.utils;

import vooga.fighter.objects.CharacterObject;

/**
 * Represents an effect placed on a character (or several).
 * 
 * @author james
 *
 */
public abstract class Effect {
    
    private Counter myCounter;
    private CharacterObject myTarget;
    private boolean isActive;
    
    public Effect() {
        myCounter = null;
        myTarget = null;
        isActive = false;        
    }
    
    /**
     * Used to designate the target of this effect. Call this method when the effect
     * is actually placed upon a target and activated. Note that this method will
     * activate the effect as well.
     */
    public void addTarget(CharacterObject target) {
        myTarget = target;
        isActive = true;
        //myCounter = new Counter();
        //myCounter.setCounter(count);
    }
    
    /**
     * Returns the target of the effect, or null if none is set.
     */
    public CharacterObject getTarget() {
        return myTarget;
    }
    
    /**
     * Returns the current count on the effect, or -1 if the counter is not yet active.
     */
    public int getCount() {
        return myCounter.getCount();
    }
    
    /**
     * Creates a clone of this effect.
     */
    public abstract Effect getCloneOfEffect();

}
