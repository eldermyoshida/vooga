
package vooga.towerdefense.action;

import java.util.ArrayList;
import java.util.List;
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
    private boolean enabled;
    private boolean complete;
    private List<Action> myFollowUpActions;
    private List<GameElement> myTargets;
    	
    public Action () {
        myFollowUpActions = new ArrayList<Action>();
        myTargets = new ArrayList<GameElement>();
        enabled = true;
    }

    public void initAction () {
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
    
    public void setTargets(List<GameElement> targets) {
        myTargets = targets;
    }
    
    
    public void addFollowUpAction(Action action){
    	myFollowUpActions.add(action);
    }
    
    public void addFollowUpActions(List<Action> action){
        myFollowUpActions.addAll(action);
    }
    
    public List<Action> getFollowUpAction(){
    	return myFollowUpActions;
    }
    public boolean isComplete () {
        enabled = false;
        return complete;
    }

    public void markComplete () {
        complete = true;
    }
    
    public boolean toggleEnabled () {
        enabled = !enabled;
        return enabled;
    }


    public boolean isEnabled () {
        return enabled;
    }

    public void setEnabled (boolean isEnabled) {
        enabled = isEnabled;
    }
}




