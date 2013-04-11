package vooga.fighter.objects.utils;

import java.util.ArrayList;
import java.util.List;
import vooga.fighter.objects.CharacterObject;
import vooga.fighter.objects.Player;

/**
 * Represents an effect placed on a character (or several).
 * 
 * @author james, alanni
 *
 */
public abstract class Effect {
    
    private Counter myCounter;
    private List<CharacterObject> myTargets;
    private boolean isActive;
    
    public Effect() {
        myCounter = null;
        myTargets = new ArrayList<CharacterObject>();
        isActive = false;        
    }
    
    /**
     * Used to designate the target of this effect. Call this method when the effect
     * is actually placed upon a target and activated. Note that this method will
     * activate the effect as well.
     */
    public void addTarget(CharacterObject target) {
        myTargets.add(target);
        isActive = true;
        //myCounter = new Counter();
        //myCounter.setCounter(count);
    }
    
    /**
     * Returns the targets of the effect in a list.
     */
    public List<CharacterObject> getTarget() {
        return myTargets;
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
    
    /**
     * Adds the effect to a certain player's list of effects.
     */
    public void addEffectToPlayer(Player player) {
        
    }
    
    /**
     * Applies effect to target
     */
    public abstract void applyEffect();

}
