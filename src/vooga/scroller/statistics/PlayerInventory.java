package vooga.scroller.statistics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerInventory implements Statistic<Item> {

    private List<Item> myItems;
    
    
    public PlayerInventory() {
        myItems = new ArrayList<Item>();
    }
    
    @Override
    public void addValue (Item obj) {
        myItems.add(obj);       
    }

    @Override
    public void removeValue (Item obj) {
        for(int i = 0; i < myItems.size(); ++i) {
            Item item = myItems.get(i);
            if(item.equals(obj)){
                myItems.remove(i);
            }
        }        
    }

    @Override
    public Collection<Item> getAllValues () {       
        return myItems;
    }

}
