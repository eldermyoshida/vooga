package vooga.scroller.sprites.animation;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.util.List;
import vooga.scroller.util.ISpriteView;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

/**
 * Represents an animation that depends on different movements of a sprite.
 * 
 * @author Scott Valentine
 *
 */

public class Animation implements ISpriteView {

    private List<AnimationState> myAnimations;
    private Sprite mySprite;
    private Pixmap myDefaultStateView;

    /**
     * Creates a new animation that acts on a sprite.
     * 
     * @param defaultImageFile is the file path of the default image for this animation.
     * @param sp is the sprite on that this animation animates.
     */
    public Animation (Sprite sp) {
        mySprite = sp;
        initAnimations();
    }
    
    /**
     * Initiates all of the animationStates used in this animation.
     */
    private void initAnimations () {
        AnimationFactory af = new AnimationFactory();
        myAnimations = af.generateAnimations();
        myDefaultStateView = af.getDefaultImage();
    }

    /**
     * Gives the current image that this animation should display
     * 
     * @return
     */
    private Pixmap getStateView() {
        for (AnimationState as: myAnimations) {
            if (as.validAnimation(mySprite)) {
                return as.getImage();
            }
        }
        return this.getDefaultStateView();
    }
    
    private Pixmap getDefaultStateView () {
        // TODO Auto-generated method stub
        return myDefaultStateView;
    }

    /**
     * Gives the default image of this animation.
     * 
     * @return The default image of this animation.
     */
    public Image getDefaultImg () {
        return getDefaultStateView().getDefaultImg();
    }

    @Override
    public void paint (Graphics2D pen, Point2D center, Dimension size, double angle) {
        Pixmap currView = getStateView();
//        setImg(image);
        currView.paint(pen, center, size, angle);
        
    }

    @Override
    public ISpriteView reset () {
        // TODO Need to think a bit more about this.
        return myDefaultStateView.reset();
    }

    @Override
    public void paint (Graphics2D pen, Point2D myCenter, Dimension mySize) {
        // TODO Auto-generated method stub
        Pixmap currView = getStateView();
//      setImg(image);
      currView.paint(pen, myCenter, mySize);
    }
}
