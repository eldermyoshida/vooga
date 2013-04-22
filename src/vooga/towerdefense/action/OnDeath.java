package vooga.towerdefense.action;

import java.util.List;
import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.gameElements.GameElement;

/**
 * 
 * Defines how something acts on death
 * @author Matthew Roy
 *
 */
public class OnDeath extends Action {

    Attribute myHealth;
    List<Action> myActions;
    /**
     * @param initiator
     */
    public OnDeath (Attribute health, List<Action> actionsToDo) {
        myHealth = health;
        myActions = actionsToDo;
    }

    /**
     * Overrides from superclasses
     * @param elapseTime 
     */
    @Override
    public void executeAction (double elapseTime) {
        if (myHealth.getValue() <= 0)
            execute();
    }
    
    public void execute() {
        for (Action a : myActions) {
            a.executeAction(2);
        }
    }

    /**
     * Overrides from superclasses
     * @param elapsedTime 
     */
    @Override
    public void update (double elapsedTime) {
        // TODO Auto-generated method stub
        
    }
}
