package vooga.rts.leveleditor.components;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
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
    private static final String IMAGE_PATH = "./src/vooga/rts/leveleditor/resource/";
    
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
        try {
            myImage = ImageIO.read(new File(System.getProperty("user.dir") + IMAGE_PATH + myName));
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public Resource(int x , int y, int id ) {
        this( new Location(x,y), id);
    }
    
    public Resource(int id) {
        this(0,0,id);
    }
    
    public Resource (int ID, String name, BufferedImage image) {
        myID = ID;
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
