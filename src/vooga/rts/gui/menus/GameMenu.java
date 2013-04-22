package vooga.rts.gui.menus;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import vooga.rts.gui.Menu;

public class GameMenu extends Menu {

    private static final String DEFAULT_BG_LOCATION = "../../resources/images/gamemenu/menu_bg.png";
    private BufferedImage myBGImage;
    public GameMenu() {
        File imgFile = new File(DEFAULT_BG_LOCATION);
        try {
            myBGImage = ImageIO.read(imgFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        setImage(myBGImage);
    }
}
