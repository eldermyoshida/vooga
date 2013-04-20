package vooga.scroller.example.statistics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import vooga.scroller.statistics.Statistic;

/**
 * Example class that shows how a developer could use the 
 * statistics interface to implement an inventory of items.
 * 
 * @author Scott Valentine
 *
 */
public class Inventory implements Statistic {

    private static final String DEFAULT_NAME = "INVENTORY";
    private Collection<Item> myItems;
    private Map<Integer, Item> myItemLookUpTable;
    
    public Inventory (){
        myItems = new ArrayList<Item>();
        initItemMap();
    }
    
    
    
    private void initItemMap () {
        myItemLookUpTable = new HashMap<Integer, Item>();
        
    }



    @Override
    public void addValue (int val) {
        myItems.add(myItemLookUpTable.get(val));
    }

    @Override
    public void removeValue (int val) {
        myItems.remove(myItemLookUpTable.get(val));
    }

    @Override
    public int getAggregateValue () {
        return myItems.size();
    }

    @Override
    public String getName () {
        return DEFAULT_NAME;
    }

}
