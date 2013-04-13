package vooga.rts.leveleditor.components;

import java.awt.image.BufferedImage;
/**
 * This class represents the available resource types the designer can choose from
 * 
 * @author Ziqiang Huang
 *
 */

public class Resource {
    
    private int myID;
    private String myName;
    private BufferedImage myImage;
    
    /**
     * Constructor for this class
     * 
     * @param id
     * @param name
     * @param image
     */
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
