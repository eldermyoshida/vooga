package vooga.rts.state;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import vooga.rts.resourcemanager.ResourceManager;

public class LoadingState {
    
    AffineTransform myTransform;
    BufferedImage myBGImage;
    public static final String DEFAULT_BGIMAGE_LOCATION = "images/backgrounds/loading_bg.png";
    
    public LoadingState () {
        myBGImage = ResourceManager.instance().loadFile(DEFAULT_BGIMAGE_LOCATION);
    }
    
    
}
