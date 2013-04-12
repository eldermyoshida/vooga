package vooga.scroller.sprites.animation;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.util.List;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

/**
 * Represents an animation that depends on different movements of a sprite.
 * 
 * @author Scott Valentine
 *
 */
public class Animation extends Pixmap {

    private List<AnimationState> myAnimations;
    private Sprite mySprite;
    private Image myDefaultImage;

    /**
     * Creates a new animation that acts on a sprite.
     * 
     * @param defaultImageFile is the file path of the default image for this animation.
     * @param sp is the sprite on that this animation animates.
     */
    public Animation (String defaultImageFile, Sprite sp) {
        super(defaultImageFile);
        myDefaultImage = super.getImg();
        mySprite = sp;
        initAnimations();
    }
    
    /**
     * Initiates all of the animationStates used in this animation.
     */
    private void initAnimations () {
        AnimationFactory af = new AnimationFactory();
        myAnimations = af.generateAnimations();       
    }

    /**
     * Gives the current image that this animation should display
     * 
     * @return
     */
    private Image getImage() {
        for (AnimationState as: myAnimations) {
            if (as.validAnimation(mySprite)) {
                return as.getImage();
            }
        }
        return this.getDefaultImg();
    }
    
    /**
     * Gives the default image of this animation.
     * 
     * @return The default image of this animation.
     */
    private Image getDefaultImg () {
        return myDefaultImage;
    }

    @Override
    public void paint (Graphics2D pen, Point2D center, Dimension size, double angle) {
        Image image = getImage();
        setImg(image);
        super.paint(pen, center, size, angle);
        
    }
}
