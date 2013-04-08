package vooga.rts.gui.menus;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import vooga.rts.gui.Menu;
import vooga.rts.resourcemanager.ResourceManager;

public class MainMenu extends Menu {
    public MainMenu() {
        super();
        setImage(ResourceManager.instance().loadFile("tree.jpg"));
    }
}
