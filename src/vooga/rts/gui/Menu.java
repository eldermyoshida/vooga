package vooga.rts.gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import vooga.rts.IGameLoop;


public abstract class Menu extends Observable implements IGameLoop, Observer{

    private List<Button> myButtons;
    private Image myImage;
    private AffineTransform myTransform;

    public Menu () {
        myButtons = new ArrayList<Button>();
    }    

    @Override
    public void update (double elapsedTime) {
        
    }

    @Override
    public void paint (Graphics2D pen) {
        if (myImage != null) {
            if (myTransform == null) {
                myTransform = new AffineTransform();
                double sx = pen.getDeviceConfiguration().getBounds().getWidth();
                sx /= myImage.getWidth(null);
                double sy = pen.getDeviceConfiguration().getBounds().getHeight();
                sy /= myImage.getHeight(null);
                myTransform.scale(sx, sy);
            }
            pen.drawImage(myImage, myTransform, null);
        }

        for (Button b : myButtons) {
            b.paint(pen);
        }
    }

    public void setImage (Image i) {
        myImage = i;
        myTransform = null;
    }

    public void addButton (Button b) {
        myButtons.add(b);
        b.addObserver(this);
    }
    
    public void handleClick(int x, int y) {
        for (Button b: myButtons) {
            if (b.checkClick(x, y)) {
                b.update(0);
            }
        }
    }
    
    @Override
    public void update (Observable o, Object arg) {
        setChanged();
        notifyObservers(arg);        
    }

}
