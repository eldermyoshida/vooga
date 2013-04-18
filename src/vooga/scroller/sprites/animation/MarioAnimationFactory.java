package vooga.scroller.sprites.animation;

import java.util.ArrayList;
import java.util.List;
import vooga.scroller.sprites.test_sprites.mario.animation_states.LeftStand;
import vooga.scroller.sprites.test_sprites.mario.animation_states.LeftWalk;
import vooga.scroller.sprites.test_sprites.mario.animation_states.RightStand;
import vooga.scroller.sprites.test_sprites.mario.animation_states.RightWalk;
import vooga.scroller.sprites.test_sprites.mario.animation_states.Stand;

public class MarioAnimationFactory implements AnimationFactory {

    @Override
    public List<AnimationState> generateAnimations () {
      List<AnimationState> res = new ArrayList<AnimationState>();
      // TODO find better way to do this (maybe reflection).
      
      AnimationState stand = new Stand();
      AnimationState right = new RightWalk();
      AnimationState left = new LeftWalk();
      AnimationState standRight = new RightStand();
      AnimationState standLeft = new LeftStand();
      
      //res.add(stand);
      res.add(right);
      res.add(left);
      //res.add(standRight);
      //res.add(standLeft);
      
      return res;
    }

}
