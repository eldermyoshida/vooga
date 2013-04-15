package vooga.scroller.statistics;

import java.util.Collection;

/**
 * Statistic that can be collected on a players gameplay.
 * 
 * @author Scott Valentine
 *
 */
public interface Statistic<T> {

    
    public void addValue(T obj);
    
    public void removeValue(T obj);
    
    public Collection<T> getAllValues();
    
    
    
}
