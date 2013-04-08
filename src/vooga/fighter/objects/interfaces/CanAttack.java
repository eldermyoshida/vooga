package vooga.fighter.objects.interfaces;

import vooga.fighter.objects.AttackObject;

/**
 * Represents an object that can create AttackObjects.
 * @author james, alan
 *
 */
public interface CanAttack {
    
    /**
     * Creates an AttackObject and returns it. Overriding methods will
     * create the appropriate type of AttackObject when calling this method.
     */
    public AttackObject createAttack();

}
