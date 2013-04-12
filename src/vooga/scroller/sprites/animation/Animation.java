package vooga.scroller.sprites.animation;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.util.List;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;


public class Animation extends Pixmap{

    private List<AnimationState> myAnimations;
    private Sprite mySprite;
    
    public Animation (String defaultImageFile, Sprite sp) {
        super(defaultImageFile);
        mySprite = sp;
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
    private Image getImage() {
        for(AnimationState as: myAnimations) {
            if(as.validAnimation(mySprite)) {
                return as.getImage();
            }
        }
        return mySprite.getDefaultImg();
    }
    
    @Override
    public void paint (Graphics2D pen, Point2D center, Dimension size, double angle) {
        Image image = getImage();
        setImg(image);
        super.paint(pen, center, size, angle);
        
    }


}
