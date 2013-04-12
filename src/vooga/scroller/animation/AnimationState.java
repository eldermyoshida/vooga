package vooga.scroller.animation;

import util.Pixmap;
import util.Sprite;

public abstract class AnimationState {

    private Pixmap myImage;
    
    public AnimationState(Pixmap image) {
        myImage = image;
    }
    
    public abstract boolean validAnimation(Sprite unit);
        
    
    public Pixmap getImage() {
        return myImage;
    }
    
}
