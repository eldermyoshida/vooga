package vooga.scroller.sprites.state;

import java.awt.Dimension;
import java.util.Map;
import vooga.scroller.util.Sprite;

/**
 * Manages State for sprites
 * 
 * @author Scott Valentine
 *
 */
public class StateManager {
    //private static final State DEFAULT_STATE = null;
    Map<Integer, State> myStates;    
    private State myCurrentState; 
    //private Sprite mySprite;
    
    public StateManager(Sprite sprite) {
        //mySprite = sprite;
        StateFactory sf = new StateFactory(sprite);
        myStates = sf.createStateMap();
    }
    
    public State currentState() {
        return myCurrentState;
    }
    
    public void update(double elapsedTime, Dimension bounds){
        
        if(myCurrentState != null){
            myCurrentState.update(elapsedTime, bounds);
        }

    }
    
    public void changeState(int stateID){
        myCurrentState = myStates.get(stateID);
        myCurrentState.activate();
    }
}
