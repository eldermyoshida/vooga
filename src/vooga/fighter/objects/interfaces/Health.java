package vooga.fighter.objects.interfaces;

/**
 * Represents objects that have health and can be damaged.
 * 
 * @author james, alan
 * 
 */
public interface Health {

    /**
     * Returns the current value of the object's health.
     * @return
     */
    public int getHealth();

    /**
     * Modifies the object's health by a certain amount. Positive values
     * increase health, and negative values decrease health. Does not check
     * for negative health values.
     * @param amount
     * @return the amount of health remaining after the change
     */
    public int changeHealth(int amount);

    /**
     * Returns true if the object has any remaining health.
     * @return
     */
    public boolean isAlive();
    
}
