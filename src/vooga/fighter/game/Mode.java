package vooga.fighter.game;

import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;
import vooga.fighter.controller.ControllerDelegate;
import vooga.fighter.objects.GameObject;

/**
 * Represents a mode in the game. Holds a list of all game objects in the mode,
 * and updates those every update cycle.
 * 
 * @author james
 *
 */
public abstract class Mode {

    private Set<GameObject> myObjects;
    private long myId;
    private ControllerDelegate myControllerDelegate;

    /**
     * Constructs a new Mode.
     */
    public Mode(ControllerDelegate cd) {
        myObjects = new HashSet<GameObject>();
        setControllerDelegate(cd);
    }
    
    /**
     * Sets the controller delegate for this mode.
     */
    public void setControllerDelegate(ControllerDelegate cd) {
        myControllerDelegate = cd;
    }
    
    /**
    * Returns the id of the mode.
    */
    public long getMyId() {
        return myId;
    }

    /**
    * Returns the list of objects for this mode.
    */
    public Set<GameObject> getMyObjects() {
        return myObjects;
    }

    /**
    * Add an object to the list of game objects.
    */
    public void addObject(GameObject object) {
        myObjects.add(object);
    }

    /**
    * Remove an object from the list of game objects.
    */
    public void removeObject(GameObject object) {
        myObjects.remove(object);
    }

    /**
    * Notifies the subcontroller that the mode should terminate. Specific rules
    * for when the mode should be terminated are implemented in subclasses.
    */
    public void signalTermination() {
        myControllerDelegate.notifyEndCondition();
    }
    
    /**
     * Updates the mode for one game loop.
     */
    public void update(double stepTime, Dimension bounds) {
        for (GameObject object : myObjects) {
            object.update();
        }
    }
    
    /**
    * Handles all initialization details when the mode is loaded by the appropriate
    * subcontroller. This method should be called first by the subcontroller.
    */
    public abstract void initializeMode();

}
