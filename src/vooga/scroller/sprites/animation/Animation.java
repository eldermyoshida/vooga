package vooga.scroller.sprites.animation;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.util.List;
import vooga.scroller.util.ISpriteView;
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
    private ISpriteView myDefaultStateView;

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
        AnimationFactory af = new MarioAnimationFactory();
        myAnimations = af.generateAnimations();
        myDefaultStateView = mySprite.getView();
    }

    /**
     * Gives the current image that this animation should display
     * 
     * @return
     */
    private ISpriteView getStateView() {
        for (AnimationState as: myAnimations) {
            if (as.validAnimation(mySprite)) {
                return as.getImage();
            }
        }
        return this.getDefaultStateView();
    }
    
    private ISpriteView getDefaultStateView () {
        return myDefaultStateView;
    }

    public void setDefaultView (ISpriteView defaultImage) {
        myDefaultStateView = defaultImage;
    }
    
    @Override
    public void paint (Graphics2D pen, Point2D center, Dimension size, double angle) {
        ISpriteView currView = getStateView();
        currView.paint(pen, center, size, angle);
        
    }

    @Override
    public ISpriteView reset () {
        return myDefaultStateView.reset();
    }

    @Override
    public void paint (Graphics2D pen, Point2D myCenter, Dimension mySize) {
      ISpriteView currView = getStateView();
      currView.paint(pen, myCenter, mySize);
    }

    @Override
    public Image getDefaultImg () {
        
        return myDefaultStateView.getDefaultImg();
    }
}
