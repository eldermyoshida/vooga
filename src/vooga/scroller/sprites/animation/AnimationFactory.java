package vooga.scroller.sprites.animation;

import java.util.ArrayList;
import java.util.List;
import vooga.scroller.sprites.test_sprites.mario.animation_states.LeftWalk;
import vooga.scroller.sprites.test_sprites.mario.animation_states.RightWalk;
import vooga.scroller.sprites.test_sprites.mario.animation_states.Stand;
import vooga.scroller.util.Pixmap;

/**
 * Initiates a list of animations for a sprite to use.
 * 
 * @author Scott Valentine
 *
 */
public class AnimationFactory {

    /**
     * Generates animation states that can be used by sprites.
     * 
     * @return A List of all possible animation states.
     */
    public List<AnimationState> generateAnimations () {
        
        List<AnimationState> res = new ArrayList<AnimationState>();
        // TODO find better way to do this (maybe reflection).
        
        AnimationState stand = new Stand();
        AnimationState right = new RightWalk();
        AnimationState left = new LeftWalk();
        
        res.add(stand);
        res.add(right);
        res.add(left);
        
        return res;
    }

    public Pixmap getDefaultImage () {
        // TODO: see above. need better way (reflection)
        return new Pixmap("mario_stand.png");
    }

}
