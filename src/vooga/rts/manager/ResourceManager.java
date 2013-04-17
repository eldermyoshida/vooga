package vooga.rts.manager;

import java.util.HashMap;
import java.util.Map;

/**
 * This class stores all the resources that a particular player has.
 * It provides methods to check if the player has enough resources to
 * purchase something and it also provides methods to use a resource
 * and add to a resource.
 * 
 * @author Jonathan Schmidt
 * 
 */
public class ResourceManager {
    
    private Map<String, Integer> myResources;
    
    public ResourceManager() {
        myResources = new HashMap<String, Integer>();        
    }
    
    public int getAmount(String resource) {
        if (myResources.containsKey(resource)){
            return myResources.get(resource);
        }
        return 0;
    }
}
