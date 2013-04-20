package vooga.scroller.statistics;


/**
 * Statistic that can be collected on a players gameplay.
 * 
 * @author Scott Valentine
 *
 */
public interface Statistic {

    /**
     * Add a value to this statistic.
     * @param val is the value to be added.
     */
    public void addValue(int val);
    
    /**
     * remove a value to this statistic.
     * @param val is the value to be removed.
     */
    public void removeValue(int val);
    
    /**
     * Get the aggregate value of this statistic
     * 
     * @return The aggregate value of all the values added to this statistic.
     */
    public int getAggregateValue();
    
    /**
     * Gives the name of this statistic for display purposes.
     * @return The name of the statistic.
     */
    public String getName();
    
}
