package vooga.scroller.level_editor.library;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class BackgroundLib implements IBackgroundLibrary {

    private static final String BACKGROUND_LOCATION ="src/vooga/scroller/images/backgrounds/";
    private Map<Integer, Image> myBackgrounds;

    public BackgroundLib (String[] fileNames) {
        int i = 0;
        myBackgrounds = new HashMap<Integer, Image>();
        for (String fn : fileNames) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File(BACKGROUND_LOCATION+fn));
                myBackgrounds.put(i, img);
                i++;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            
        }
    }

    @Override
    public Map<Integer, Image> getBackgrounds () {
        return myBackgrounds;
    }

}
