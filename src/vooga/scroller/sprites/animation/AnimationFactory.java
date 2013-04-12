package vooga.scroller.sprites.animation;

import java.util.ArrayList;
import java.util.List;
import vooga.scroller.sprites.test_sprites.mario.animation_states.LeftWalk;
import vooga.scroller.sprites.test_sprites.mario.animation_states.RightWalk;
import vooga.scroller.sprites.test_sprites.mario.animation_states.Stand;

public class AnimationFactory {

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

}
