package vooga.rts.leveleditor.components;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;

public class Tile {
    
    private static final String RELATIVE_PATH = "vooga.rts.leveleditor.resource.";
    private static final String IMAGE_PATH = "./src/vooga/rts/leveleditor/resource/";
    
    private int myID;
    private String myName;
    private BufferedImage myImage;
    private ResourceBundle myResource;
    
    public Tile() {
        myResource = ResourceBundle.getBundle(RELATIVE_PATH + "TileIndex");
    }
    
    public void refreshTile() throws IOException {
        if(myResource.containsKey(myID+"")) {
            myName = myResource.getString(myID+"");
            myImage = ImageIO.read(new File(System.getProperty("user.dir") + IMAGE_PATH + myName));            
        }
    }
    
    public void setTile(int id) throws IOException {
        myID = id;
        refreshTile();
    }

    public int getMyID () {
        return myID;
    }

    public String getMyName () {
        return myName;
    }

    public BufferedImage getMyImage () {
        return myImage;
    }
    
    
}
