package vooga.rts.gui.menus;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import vooga.rts.gui.Menu;


public class GameMenu extends Menu {

    private static final String DEFAULT_BG_LOCATION = "src/vooga/rts/resources/images/gamemenu/menu_bg.png";
    private BufferedImage myBGImage;

    public GameMenu () {
        File imgFile = new File(DEFAULT_BG_LOCATION);
        try {
            myBGImage = ImageIO.read(imgFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        setImage(myBGImage);
    }

    @Override
    protected void paintBG (Graphics2D pen) {
        int x = 0;
        int y = (int) pen.getDeviceConfiguration().getBounds().getHeight() - myBGImage.getHeight();
        pen.drawImage(myImage, x, y, null);
    }
}
