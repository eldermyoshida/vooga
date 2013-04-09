package vooga.fighter.objects.utils;

/**
 * Holds a counter which can be used as a timer. The counter can be set to an initial
 * value and decremented as needed.
 * 
 * @author james
 * 
 */
public class Counter {

    /**
     * The count remaining on the Counter object.
     */
    private int myCount;
    
    /**
     * Sets the value of the current object counter. Count must not be negative.
     */
    public void setCounter(int count) {
        if (count < 0) {
            return;
        }
        myCount = count;
    }
    
    /**
     * Reduces the counter by one. If the counter is already at zero, the
     * counter remains at zero.
     */
    public void decrementCounter() {
        if (myCount > 0) {
            myCount--;
        }
    }
    
    /**
     * Returns the value of the counter.
     */
    public int getCount() {
        return myCount;
    }
    
    /**
     * Returns true if the counter is positive, or false otherwise.
     */
    public boolean hasCountRemaining() {
        return (myCount > 0);
    }

}
