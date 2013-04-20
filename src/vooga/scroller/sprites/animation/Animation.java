package vooga.scroller.sprites.animation;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.util.ArrayList;
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
     * @param sp is the sprite on that this animation animates.
     */
    public Animation (Sprite sp) {
        mySprite = sp;
        myAnimations = new ArrayList<AnimationState>();
    }
    

    /**
     * Gives the current image that this animation should display
     * 
     * @return
     */
    private ISpriteView getStateView() {
        for (AnimationState as: myAnimations) {
            as.update();
        }
        
        for (AnimationState as: myAnimations) {
            if (as.validAnimation(mySprite)) {
                return as.getView();
            }
        }
        return this.getDefaultStateView();
    }
    
    private ISpriteView getDefaultStateView () {
        return myDefaultStateView;
    }

    /**
     * Sets the default view of this animation.
     * 
     * @param defaultImage is the image to display as the default view of this animation.
     */
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
    
    
    /**
     * Adds an animation state to this animation.
     * 
     * @param animation is the animation state to add.
     */
    public void addAnimationState(AnimationState animation) {
        myAnimations.add(animation);
    }
}
