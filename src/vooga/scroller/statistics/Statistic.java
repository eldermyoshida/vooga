package vooga.scroller.statistics;

import java.util.Collection;

/**
 * Statistic that can be collected on a players gameplay.
 * 
 * @author Scott Valentine
 *
 */
public interface Statistic {

    
    public void addValue(int val);
    
    public void removeValue(int val);
    
    public int getAggregateValue();
    
    public String getName();
    
}
