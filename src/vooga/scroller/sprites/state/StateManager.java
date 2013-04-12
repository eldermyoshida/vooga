package vooga.scroller.sprites.state;

import java.util.List;

public class StateManager {
    List<State> myStates;    
    private State myCurrentState; 
    
    public StateManager() {
        
    }
    
    public State currentState() {
        return myCurrentState;
    }
}
