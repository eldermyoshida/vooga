package vooga.scroller.sprites.state;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import vooga.scroller.sprites.Sprite;


/**
 * Limitations: can't do the same state multiple times.
 * 
 * @author Scott Valentine
 *
 */
public class SpriteStateManager {

    
    private static final SpriteState DEFAULT_STATE = new DefaultSpriteState();
    
    private Sprite mySprite;
    private Map<Integer, SpriteState> myStates;
    private Collection<SpriteState> myActiveStates;
    private SpriteState myDefaultState;
     
    
    
    /**
     * Initializes a state manager with the default state.
     * 
     * @param sprite is the sprite for which this state manager controls the states.
     */
    public SpriteStateManager(Sprite sprite) {
        myActiveStates = new PriorityQueue<SpriteState>();
        myStates = new HashMap<Integer, SpriteState>();
        myDefaultState = DEFAULT_STATE;     
    }
    
    
    /**
     * Update the active states in this manager.
     * 
     * @param elapsedTime
     * @param bounds
     */
    public void update (double elapsedTime, Dimension bounds) {
        for(SpriteState spState: myActiveStates){
            spState.update(mySprite, elapsedTime, bounds);
        }
        myDefaultState.update(mySprite, elapsedTime, bounds);
    }

    /**
     * Paint the states active in this manager.
     * 
     * @param pen
     */
    public void paint (Graphics2D pen) {
        if(myActiveStates.isEmpty()){     
            myDefaultState.paint(mySprite, pen);
        }
        myActiveStates.iterator().next().paint(mySprite, pen);
    }
    
    /**
     * Activates the specified state.
     * @param stateID
     */
    public void activateState(int stateID){
        myActiveStates.add(myStates.get(stateID));
    }

    /**
     * Deactivates the specified state.
     * @param stateID
     */
    public void deactivateState(int stateID) {
        myActiveStates.remove(myStates.get(stateID));
    }
    
    /**
     * Adds a new possible state to this manager.
     * @param stateID
     * @param state
     */
    public void addState(int stateID, SpriteState state){
        myStates.put(stateID, state);
    }
    
    /**
     * Removes a possible state fromt this manager.
     * 
     * @param stateID
     */
    public void removeState(int stateID){
        myStates.remove(stateID);
    }
}
