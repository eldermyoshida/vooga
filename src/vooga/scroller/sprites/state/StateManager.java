package vooga.scroller.sprites.state;

import java.awt.Dimension;
import java.util.Map;
import vooga.scroller.util.Sprite;

/**
 * Manages various states 
 * 
 * @author Scott Valentine
 *
 */
public class StateManager {
    
    /** ID for the default state of a sprite*/
    public static final int DEFAULT_ID = 0;
    private Map<Integer, State> myStates;    
    private State myCurrentState;
    //private List<Integer> myActiveState; 
    
    public StateManager(Sprite sprite) {
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
        if(stateID != DEFAULT_ID){
            myCurrentState = myStates.get(stateID);
            myCurrentState.activate();
        }
        else{
            myCurrentState.deactivate();
        }
    }
    
    public void undoState(){
        
    }
}
