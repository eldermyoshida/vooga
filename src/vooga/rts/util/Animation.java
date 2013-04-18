package vooga.rts.util;

import java.awt.image.BufferedImage;
import vooga.rts.resourcemanager.ResourceManager;


/**
 * This class handles with the animation of images either through a sprite sheet or some other file format
 * 
 * @author junho oh
 *
 */
public class Animation {
    private Pixmap mySheet;
    private String myFileName;
    public Animation (String fileName) {
        myFileName = fileName;
        loadFile(myFileName);
    }
    
    private void loadFile(String fileName) {
        mySheet = new Pixmap(ResourceManager.getInstance()
                            .<BufferedImage> getFile("fileName", BufferedImage.class));
        //mySheet.pa
        
        
        
    }

}
