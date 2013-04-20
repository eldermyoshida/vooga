package vooga.scroller.sprites.animation;

import java.util.List;

/**
 * Initiates a list of animations for a sprite to use.
 * 
 * @author Scott Valentine
 *
 */
public interface AnimationFactory {

    /**
     * Generates animation states that can be used by sprites.
     * 
     * @return A List of all possible animation states.
     */
    public List<AnimationState> generateAnimations (); 
        
}
