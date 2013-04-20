
package vooga.towerdefense.action;

import java.util.ArrayList;
import java.util.List;


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
    private boolean enabled;
    private boolean complete;
    private List<Action> myFollowUpAction;
    	
    public Action () {
    }

    public void initAction () {
        enabled = true;
        myFollowUpAction = new ArrayList<Action>();
        // initialize resources
    }
    
    /**
     * Executes action after update clears the execute condition.
     */
    public abstract void executeAction (double elapseTime);

    /**
     * Update action status
     * @param elapsedTime
     */
    public abstract void update (double elapsedTime);
    
    
    public void addFollowUpAction(Action action){
    	myFollowUpAction.add(action);
    }
    
    public Action getFollowUpAction(){
    	return myFollowUpAction.get(0);
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
}




