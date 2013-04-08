package vooga.rts.gui.menus;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import vooga.rts.gui.Menu;

public class MainMenu extends Menu {
    public MainMenu() {
        super();
        try {
            URL f = getClass().getResource("tree.jpg");
            setImage(ImageIO.read(f));
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
