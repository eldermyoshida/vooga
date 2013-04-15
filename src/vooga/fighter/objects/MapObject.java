package vooga.fighter.objects;

import vooga.fighter.objects.utils.State;
import vooga.fighter.objects.utils.UpdatableLocation;
import vooga.fighter.util.*;
import java.util.*;


/**
 * Map class to contain, update, and manipulate all environmental objects in a
 * particular map. Also contains the background image, music, and player start
 * locations.
 * 
 * @author james, mp
 * 
 */

public class MapObject {

    private List<EnvironmentObject> myEnviroObjects;
    private List<UpdatableLocation> myStartingPositions;
    private Map<String,State> myStates;
    private Map<String,Sound> mySounds;
    private State myCurrentState;   
    private Sound myCurrentSound;

    /**
     * Constructor for a new Map object.
     */
    public MapObject(int mapId) {
        myEnviroObjects = new ArrayList<EnvironmentObject>();
        myStartingPositions = new ArrayList<UpdatableLocation>();
        myStates = new HashMap<String,State>();
        mySounds = new HashMap<String,Sound>();
        myCurrentState = null;
        myCurrentSound = null;
        
    }

    /**
     * Adds an environment object to the map object.
     */
    public void addEnviroObject(EnvironmentObject object) {
        myEnviroObjects.add(object);
    }

    /**
     * Returns the list of environment objects in the map object.
     */
    public List<EnvironmentObject> getEnviroObjects() {
        return myEnviroObjects;
    }

    /**
     * Clears all environment objects from the map object.
     */
    public void clearEnviroObjects() {
        myEnviroObjects.clear();
    }
    
    /**
     * Adds a starting position to the map object.
     */
    public void addStartPosition(UpdatableLocation position) {
        myStartingPositions.add(position);
    }
    
    /**
     * Returns the list of starting positions from the map object.
     */
    public List<UpdatableLocation> getStartPositions() {
        return myStartingPositions;
    }
    
    /**
     * Adds a state to the map object. Overwrites any existing value.
     */
    public void addState(String key, State state) {
        myStates.put(key, state);
    }
    
    /**
     * Clears all states from the map object.
     */
    public void clearStates() {
        myStates.clear();
    }
    
    /**
     * Sets the current state of the map object. Does nothing if the given key is
     * not found in the map.
     */
    public void setCurrentState(String key) {
        if (myStates.containsKey(key)) {
            myCurrentState = myStates.get(key);
        }
    }
    
    /**
     * Returns the current state of the map object.
     */
    public State getCurrentState() {
        return myCurrentState;
    }
    
    /**
     * Adds a sound to the map object. Overwrites any existing value.
     */
    public void addSound(String key, Sound sound) {
        mySounds.put(key, sound);
    }
    
    /**
     * Clears all sounds from the map object.
     */
    public void clearSounds() {
        mySounds.clear();
    }
    
    /**
     * Sets the current sound of the map object. Does nothing if the given key is
     * not found in the map.
     */
    public void setCurrentSound(String key) {
        if (mySounds.containsKey(key)) {
            myCurrentSound = mySounds.get(key);
        }
    }
    
    /**
     * Returns the current sound of the map object.
     */
    public Sound getCurrentSound() {
        return myCurrentSound;
    }
    
    /**
     * Begins playing the current sound.
     */
    public void playCurrentSound() {
        myCurrentSound.play();
    }

    /**
     * Updates all environmental objects in the map object.
     */
    public void update() {
        for (EnvironmentObject object : myEnviroObjects) {
             object.update();
        }
        if (myCurrentState != null) {
            myCurrentState.update();
        }
        if (myCurrentSound != null) {

        }
    }
    
}
