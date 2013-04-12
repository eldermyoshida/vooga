package vooga.scroller.animation;

import java.util.List;
import util.Pixmap;
import util.Sprite;

public class Animation2 extends Pixmap{

    private List<AnimationState> myAnimations;
    
    public Animation2 (String defaultImageFile) {
        super(defaultImageFile);
        initAnimations();
    }
    
    private void initAnimations () {
        AnimationFactory af = new AnimationFactory();
        myAnimations = af.generateAnimations();       
    }

    /**
     * Gives the current image that this animation should display
     * 
     * @return
     */
    public Pixmap getImage(Sprite unit) {
        for(AnimationState as: myAnimations) {
            if(as.validAnimation(unit)) {
                return as.getImage();
            }
        }
        return this;
    }

}
