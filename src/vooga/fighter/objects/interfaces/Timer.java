package vooga.fighter.objects.interfaces;

/**
 * Represents objects that perish over time. The time left until perishing
 * is represented by a counter stored in the object.
 * 
 * @author james, alan
 * 
 */
public interface Timer {

    /**
     * Sets the value of the current object counter.
     */
    public void setCounter(int time);
    
    /**
     * Reduces the counter by one. If the counter is already at zero, the
     * counter remains at zero. Returns true if the counter was decremented.
     */
    public boolean decrementCounter();
    
    /**
     * Returns true if the counter is positive, or false otherwise.
     */
    public boolean hasTimeRemaining();

}
