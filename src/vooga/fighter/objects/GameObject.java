package vooga.fighter.objects;

import vooga.fighter.objects.utils.State;
import vooga.fighter.objects.utils.UpdatableLocation;
import java.util.HashMap;
import java.util.Map;


/**
 * Represents a single object in the game.
 * 
 * @author james, alanni, David Le
 * 
 */
public abstract class GameObject {
    
    private long myInstanceId;
    private ObjectLoader myLoader;
    private UpdatableLocation myCenter;
    private State myCurrentState;
    private Map<String,State> myStates;
    private Map<String,Integer> myProperties;

    /**
     * Constructs a new GameObject with the given image, center, and size.
     * 
     * Note: Dayvid, once the loader is fully functional we will modify this to
     * only take in an object ID, and we will load the parameters from the XML.
     */
    public GameObject() {
//        myInstanceId = System.currentTimeMillis();
        myStates = new HashMap<String,State>();
        myProperties = new HashMap<String,Integer>();
        myCurrentState = null;
    }
    
    /**
     * Returns the game object's instance id. This id is unique to this particular
     * instantiation of the object.
     */
    public long getInstanceId() {
        return myInstanceId;
    }

    /**
     * Sets game object's center.
     */
    public void setLocation(UpdatableLocation ul) {
        myCenter = ul;
    }

    /**
     * Returns game object's center.
     */
    public UpdatableLocation getLocation() {
        return myCenter;
    }

    /**
     * Adds a property for this object. Overwrites any existing value.
     */
    public void addProperty(String key, int value) {
        myProperties.put(key, value);
    }

    /**
     * Returns a property for this object. Returns -1 if property does not exist.
     */
    public int getProperty(String key) {
        if (myProperties.containsKey(key)) {
            return myProperties.get(key);
        } else {
            return -1;
        }
    }
    
    /**
     * Clears all properties.
     */
    public void clearProperties() {
        myProperties.clear();
    }
    
    /**
     * Adds a state for this object. Overwrites any existing value.
     */
    public void addState(String key, State value) {
        myStates.put(key, value);
    }
    
    /**
     * Returns a state for this object. Returns null if it doesn't exist.
     */
    public State getState(String key) {
        if (myStates.containsKey(key)) {
            return myStates.get(key);
        } else {
            return null;
        }
    }
    
    /**
     * Sets the current state for this object.
     */
    public void setCurrentState(String key) {
        myCurrentState = getState(key);
    }
    
    /**
     * Gets the current state for this object.
     */
    public State getCurrentState() {
        return myCurrentState;
    }

    /**
     * Clears all states.
     */
    public void clearStates() {
        myStates.clear();
    }
    
    /**
     * Sets the object loader for this object.
     */
    public void setLoader(ObjectLoader loader) {
        myLoader = loader;
    }
    
    /**
     * gets priority of the object
     */
    
    public int getPriority(){
    	return myCurrentState.getPriority(); 
    }
    /**
     * Returns the object loader for this object.
     */
    public ObjectLoader getLoader() {
        return myLoader;
    }
    
    /**
     * Updates the object for the game loop. Should be overriden by subclasses if
     * necessary, but all overrides shuld call superclass method.
     */
    public void update() {
        if (myCenter != null) {
            myCenter.update();
        }
        if (myCurrentState != null) {
            myCurrentState.update();
        }
    }
    
    /**
     * 
     * returns the difference between two game object's priorities   
     */
    public int compare(GameObject o){
    	return this.getPriority()-o.getPriority();
    }
    
    /**
     * 
     */
    
    public abstract void applyCollideEffect(GameObject o);
}
