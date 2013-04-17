
package vooga.towerdefense.action;

import java.util.List;
import vooga.towerdefense.event.Event;
import vooga.towerdefense.event.evented;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.util.CoolDownManager;


/**
 * An AbstractAction is superclassed to define specific Actions that can be taken by game elements.
 * This includes attacks, upgrades, path creation and anything the developer may wish to implement.
 * 
 * @author Matthew Roy
 * @author XuRui
 * 
 */

public class Action {
    private Event myTriggerEvent;
    private GameElement myInitiator;
    private boolean enabled;
    private boolean complete;

    public Action (GameElement initiator) {
        myInitiator = initiator;
    }

    public void initAction () {
        enabled = true;
        // initialize resources
    }

    /**
     * executes action
     */
    public void executeAction () {
        initAction();
        // execute action
    }

    public boolean isComplete () {
        enabled = false;
        return complete;
    }

    public void markComplete () {
        complete = true;
    }

    public boolean isEnabled () {
        return enabled;
    }

    public void setEnabled (boolean isEnabled) {
        enabled = isEnabled;
    }

    // @Override
    public boolean eventTriggered (Event event) {
        return (event == myTriggerEvent);

    }

    public void update (double elapsedTime) {

    }

    // @Override
    public void update (double elapsedTime, Event e) {
        if (eventTriggered(e)) {
            executeAction();
        }
    }
}




