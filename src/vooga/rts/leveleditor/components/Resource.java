package vooga.rts.leveleditor.components;

import java.awt.image.BufferedImage;
import vooga.rts.util.Pixmap;

public class Resource {
    
    private int myID;
    private String myName;
    private BufferedImage myImage;
    
    public Resource(int id, String name, BufferedImage image) {
        
        myID = id;
        myName = name;
        myImage = image;
        
    }
    
    public String getName() {
        return myName;
    }
    
    public int getID() {
        return myID;
    }

    public BufferedImage getImage() {
        return myImage;
    }
}
