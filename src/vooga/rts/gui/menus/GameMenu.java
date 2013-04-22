package vooga.rts.gui.menus;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import javax.imageio.ImageIO;
import vooga.rts.commands.Command;
import vooga.rts.commands.PositionCommand;
import vooga.rts.gui.Button;
import vooga.rts.gui.Menu;
import vooga.rts.gui.buttons.ImageButton;
import vooga.rts.gui.buttons.ScreenButton;
import vooga.rts.resourcemanager.ResourceManager;
import vooga.rts.util.Location;


public class GameMenu extends Menu {

    private static final String BG_IMAGE_LOCATION =
            "images/gamemenu/menu_bg.png";
    private static final String EXIT_IMAGE_LOCATION =
            "images/gamemenu/menu_button.png";
    private BufferedImage myBGImage;
    private static final Dimension EXIT_BUTTON_DIMENSION = new Dimension(200, 40);
    private static final Location EXIT_BUTTON_LOCATION = new Location(150, 0);
    private Button myExitButton;

    public GameMenu () {
        File bgImage = new File(BG_IMAGE_LOCATION);

        myBGImage = ResourceManager.getInstance().<BufferedImage>getFile(BG_IMAGE_LOCATION, BufferedImage.class);
        setBGImage(myBGImage);

        myExitButton = new ImageButton(EXIT_IMAGE_LOCATION, EXIT_BUTTON_DIMENSION, EXIT_BUTTON_LOCATION);
        addButton(myExitButton);
    }

    public void setMiniMap () {

    }

    public void setResources () {

    }

    public void setSelected () {

    }

    @Override
    protected void paintBG (Graphics2D pen) {
        int x = 0;
        int y = (int) pen.getDeviceConfiguration().getBounds().getHeight() - myBGImage.getHeight();
        pen.drawImage(myImage, x, y, null);
    }
    
    @Override
    public void update (Observable o, Object arg) {
        if (o.equals(myExitButton)) {
            System.exit(0);
        }
        
        setChanged();
        notifyObservers(arg);
    }

    public void receiveCommand (Command command) {
        if (!(command instanceof PositionCommand)) return;
        
        PositionCommand p = (PositionCommand) command;
        handleMouseDown(p.getPosition());
        handleMouseMovement(p.getPosition());

        
    }
}
