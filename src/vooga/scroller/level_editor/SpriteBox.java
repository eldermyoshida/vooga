package level_editor;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.Set;
import util.Sprite;
import viewUtil.Renderable;


public class SpriteBox implements Renderable {

    private Sprite mySprite;
    private LEGrid myParent;
    private int mySize;
    private Rectangle myBounds;
    private Set<SpriteBox> myCombinedBoxes;
    private boolean isAvailable;

    public SpriteBox (LEGrid parent, int x, int y) {
        myParent = parent;
        mySize = myParent.getSpriteSize();
        setBounds(x, y);
        setAvailable();
        myCombinedBoxes = new HashSet<SpriteBox>();
    }

    public void addSprite (Sprite spr) {
        mySprite = spr;
        mySprite.setCenter(myBounds.getX() + mySprite.getWidth() / 2,
                           myBounds.getY() + mySprite.getHeight() / 2);
        setUnavailable();
    }

    public void deleteSprite () {
        mySprite = null;
        setAvailable();
        for (SpriteBox box : myCombinedBoxes) {
            box.myCombinedBoxes.remove(this);
            box.deleteSprite();
        }
        myCombinedBoxes = new HashSet<SpriteBox>();
    }

    public Sprite getSprite () {
        return mySprite;
    }

    public void combineWith (SpriteBox nearestBox) {
        myCombinedBoxes.add(nearestBox);
        nearestBox.myCombinedBoxes.add(this);
        nearestBox.setUnavailable();
    }

    @Override
    public Object getState () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void paint (Graphics2D pen) {
        if (mySprite != null) {
            mySprite.paint(pen);
        }
    }

    public Rectangle getBounds () {
        return myBounds;
    }

    public int getX () {
        return myBounds.x;
    }

    public int getY () {
        return myBounds.y;
    }

    public boolean isAvailable () {
        return isAvailable;
    }

    private void setUnavailable () {
        isAvailable = false;
    }

    private void setAvailable () {
        isAvailable = true;
    }

    private void setBounds (int x, int y) {
        myBounds = new Rectangle(x * mySize, y * mySize, mySize, mySize);
    }

}
