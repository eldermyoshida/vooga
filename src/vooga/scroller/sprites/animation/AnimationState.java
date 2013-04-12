package vooga.scroller.sprites.animation;

import java.awt.Image;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

public abstract class AnimationState {

    private Pixmap myImage;
    
    public AnimationState(Pixmap image) {
        myImage = image;
    }
    
    public abstract boolean validAnimation(Sprite unit);
        
    
    public Image getImage() {
        return myImage.getImg();
    }
    
}
