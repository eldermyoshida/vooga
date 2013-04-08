/**
 * 
 */
package vooga.rts.resourcemanager;

/**
 * 
 * 
 * @author Jonathan Schmidt
 *
 */
public class ResourceManager {
    
    private static ResourceManager myInstance;

    /**
     * 
     */
    private ResourceManager () {
        
    }
    
    
    int count = 0;
    public boolean isLoading() {
        count++;
        return count < 500;
    }
    
    public static ResourceManager instance() {
        if (myInstance == null) {
            myInstance = new ResourceManager();
        }
        return myInstance;
    }

}
