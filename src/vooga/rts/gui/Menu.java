package vooga.rts.gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import vooga.rts.IGameLoop;

public abstract class Menu implements IGameLoop{

    private List<Button> myButtons;
    private Image myImage;
    
    public Menu () {
        myButtons = new ArrayList<Button>();
    }

    @Override
    public void update (double elapsedTime) {        
        for (Button b : myButtons) {
            b.update(elapsedTime);
        }
    }

    @Override
    public void paint (Graphics2D pen) { 
        for (Button b : myButtons) {
            b.paint(pen);
        }       
        if (myImage != null) {
            pen.drawImage(myImage, 0, 0, myImage.getWidth(null), myImage.getHeight(null), null);
        }
    }
    
    public void setImage(Image i) {
        myImage = i;
    }
    
    public void addButton(Button b) {
        myButtons.add(b);
    }

}
