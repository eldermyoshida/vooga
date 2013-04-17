package vooga.rts.gamedesign.sprite;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import vooga.rts.gamedesign.sprite.Sprite;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;

public abstract class GameSprite extends Sprite {
    // canonical directions for a collision
    public static final int RIGHT_DIRECTION = 0;
    public static final int UP_DIRECTION =  270;
    public static final int LEFT_DIRECTION = 180;
    public static final int DOWN_DIRECTION = 90;

    //private ThreeDimension mySize;
    private Dimension mySize;
    //store myWorldLocation 

    //private ThreeDimension myOriginalSize;
    private Dimension myOriginalSize;

    public GameSprite (Pixmap image, Location center, Dimension size) {
        super(image, center);
        mySize = size;
        myOriginalSize = size;
        resetBounds();
    }
    /**
     * Returns shape's left-most coordinate in pixels.
     */
    public double getLeft () {
        return getCenter().getX() - mySize.width / 2;
    }

    /**
     * Returns shape's up-most coordinate in pixels.
     */
    public double getUp () {
        return getCenter().getY() - mySize.height / 2;
    }

    /**
     * Returns shape's right-most coordinate in pixels.
     */
    public double getRight () {
        return getCenter().getX() + mySize.width / 2;
    }

    /**
     * Returns shape's bottom-most coordinate in pixels.
     */
    public double getBottom () {
        return getCenter().getY() + mySize.height / 2;
    }

    /**
     * Returns shape's x-axis length in pixels.
     */
    public double getWidth () {
        return mySize.getWidth();
    }

    /**
     * Returns shape's y-axis length in pixels.
     */
    public double getDepth () {
        return mySize.getHeight();
    }
    
    /**
     * Return shape's z-axis length in pixels.
     * need to implement! 
     */
    public double getHeight() {
    	return 0;
    }
    
    /**
     * Resets shape's size.
     */
    public void setSize (int width, int height) {
        mySize.setSize(width, height);
        resetBounds();
    }
    /**
     * Returns shape's size.
     */
    public Dimension getSize () {
        return mySize;
    }
    /**
     * Scales shape's size by the given factors.
     */
    public void scale (double widthFactor, double heightFactor) {
        mySize.setSize(mySize.width * widthFactor, mySize.height * heightFactor);
        resetBounds();
    }

    /**
     * Reset shape back to its original values.
     */
    @Override
    public void reset () {
        super.reset();
        mySize = myOriginalSize;
    }
    
    /**
     * Display this shape on the screen.
     */
    @Override
    public void paint (Graphics2D pen)
    {   
    	if(!isVisible()) return;
        //System.out.println(getCenter().x + " " + getCenter().y + " " + mySize.height + " " + mySize.width);
        getView().paint(pen, getCenter(), mySize);
    }
    
    
    /**
     * Returns rectangle that encloses this shape.
     */
    protected void resetBounds () {
        setBounds(new Rectangle((int)getLeft(), (int)getUp(), mySize.width, mySize.height));
    }

    /**
     * This would determine if two RTSprites collide.
     * @param gameEntity is an RTSprite that is being checked to see if it 
     * collides with the current RTSprite
     * @return true if the two RTsprites collided and false if the RTSprites
     * did not collide.
     */
    public boolean collidesWith(GameEntity gameEntity) {
        return getBounds().intersects(gameEntity.getBounds());
    }

}