package vooga.rts.leveleditor.components;

import java.awt.image.BufferedImage;
import java.util.ResourceBundle;
import vooga.rts.util.Location;
/**
 * This class represents the available resource types the designer can choose from
 * 
 * @author Ziqiang Huang
 * @author Yang Yang
 *
 */

public class Resource {
    
    private static final String BUNDLE_RELATIVE_PATH = "vooga.rts.leveleditor.resource.";
    
    private Location myLocation;
    
    private int myID;
    private String myName;
    private BufferedImage myImage;
    
    private ResourceBundle myResources;
    
    /**
     * Constructor for this class
     * 
     * @param id
     * @param name
     * @param image
     */
    public Resource(Location loc, int id) {
        myResources = ResourceBundle.getBundle(BUNDLE_RELATIVE_PATH + "ResourceIndex");
        myID = id;
        myName = myResources.getString(myID+"");
        myLocation = loc;
    }
    
    public Resource(int x , int y, int id ) {
        this( new Location(x,y), id);
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
    
    public int getMyX() {
        return (int)myLocation.getX();
    }
    
    public int getMyY() {
        return (int)myLocation.getY();
    }
    
    public Location getMyLocation() {
        return myLocation;
    }
}
