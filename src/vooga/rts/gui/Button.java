package vooga.rts.gui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;
import vooga.rts.util.Location;
import vooga.rts.IGameLoop;
import vooga.rts.resourcemanager.ResourceManager;

public abstract class Button extends Observable implements IGameLoop {

    private BufferedImage myImage;
    protected Dimension mySize;
    protected Location myPos;
    
    public Button (String image, Dimension size, Location pos) {
        if (image != null) {
            myImage = ResourceManager.instance().loadFile(image);
        }
        mySize = size;
        myPos = pos;
    }

    @Override
    public abstract void update (double elapsedTime);

    @Override
    public void paint (Graphics2D pen) {
        if (myImage != null) {
            pen.drawImage(myImage, (int)myPos.x, (int)myPos.y, mySize.width, mySize.height, null);
        }
    }
    
    public boolean checkClick(int x, int y) {
        return (x > myPos.x && y > myPos.y && x < (myPos.x + mySize.width) && y < (myPos.y + mySize.height));
    }
    
    public Dimension getSize () {
    	return mySize;
    }
    
    public void setSize (Dimension s) {
    	mySize = s;
    }
    
    public Location getPos () {
    	return myPos;
    }

    public void setPos (Location l) {
    	myPos = l;
    }
}
