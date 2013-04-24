package vooga.scroller.sprites.state;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;
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
    private Collection<State> myCurrentStates;
    
    public StateManager(Sprite sprite) {
        StateFactory sf = new StateFactory(sprite);
        myStates = sf.createStateMap();
        myCurrentStates = new ArrayList<State>();
    }
    
    public void update(double elapsedTime, Dimension bounds){       
        for(State s: myCurrentStates){
            s.update(elapsedTime, bounds);
        }
    }
    
    
    public void addActiveState(int stateID){
        myCurrentStates.add(myStates.get(stateID));
    }
    
    public void removeActiveState(int stateID) {
        myCurrentStates.remove(myStates.get(stateID));
    }
    
    
    public void addState(int stateID, State state) {
        myStates.put(stateID, state);
    }

    public void paint (Graphics2D pen) {
        for(State s: myCurrentStates){
            s.paint(pen);
        }
    }
}
