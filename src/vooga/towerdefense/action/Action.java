
package vooga.towerdefense.action;

import vooga.towerdefense.event.Event;
import vooga.towerdefense.gameElements.GameElement;


/**
 * An AbstractAction is superclassed to define specific Actions that can be taken by game elements.
 * This includes attacks, upgrades, path creation and anything the developer may wish to implement.
 * 
 * @author Matthew Roy
 * @author XuRui
 * @author Zhen Gou
 * 
 */

public abstract class Action {
    private Event myTriggerEvent;
    protected GameElement myInitiator;
    private boolean enabled;
    private boolean complete;

    public Action (GameElement initiator) {
        myInitiator = initiator;
    }

    public void initAction () {
        enabled = true;
        // initialize resources
    }

    public GameElement getInitiator() {
        return myInitiator;
    }


    /**
     * executes action
     */
    public abstract void executeAction (double elapseTime);

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
    
   
    // @Override
    public void update (double elapsedTime, Event e) {
        if (eventTriggered(e)) {
            executeAction(elapsedTime);
        }
    }
}




