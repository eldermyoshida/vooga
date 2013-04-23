package arcade.view;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import util.ImageHelper;
import arcade.games.GameInfo;
import arcade.model.Model;


/**
 * A SnapShot is a small clickable panel that represents a Game in the GameCenter
 * and Store. Clicking a SnapShot opens up a more detailed view.
 * 
 * @author David Liu, Ellango Jothimurugesan
 * 
 */
@SuppressWarnings("serial")
public class SnapShot extends JPanel {

    public static final int THUMBNAIL_SIZE = 190;
    private static final String IMAGES_LOCATION = System.getProperty("user.dir")
                                                  + "/src/arcade/resources/images/";
    private static final String IMAGES_NAME = "Stars.gif";
    private GameInfo myGameInfo;
    private ResourceBundle myResources;
    private Model myModel;
    private ImageIcon[] myRatingIcons;

    public SnapShot (GameInfo info, ResourceBundle resources, Model model) {
        myModel = model;
        myGameInfo = info;
        myResources = resources;
        myRatingIcons = initializeRatingIcons();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(createThumbnail());
        add(createTitle());
        add(createRating());

        this.addMouseListener(createListener());
    }

    private ImageIcon[] initializeRatingIcons() {
        ImageIcon[] icons = new ImageIcon[6];
        for (int i = 0; i <= 5; i++) {
            icons[i] = new ImageIcon(IMAGES_LOCATION + i + IMAGES_NAME);
        }
        return icons;
    }

    /**
     * Creates the thumbnail to be displayed in the SnapShot
     * 
     * @return
     */
    private Component createThumbnail () {
        ImageIcon icon = myGameInfo.getThumbnail();
        Image scaledImage = ImageHelper.getScaledImage(icon, THUMBNAIL_SIZE); 
        return new JLabel(new ImageIcon(scaledImage));
    }

    /**
     * Creates the title to be displayed. The title is the game's name.
     * 
     * @return
     */
    private Component createTitle () {
        JLabel label = new JLabel("<html><b><font size = 4>" + myGameInfo.getName());
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
        
    }

    /**
     * Creates the label for the rating of the game.
     * 
     * @return
     */
    private Component createRating () {
        int rating = (int) myGameInfo.getRating();
        JLabel label = new JLabel(myRatingIcons[rating]);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    /**
     * Creates a mouse listener so that upon double clicking a SnapShot, the
     * DetailView is launched.
     * 
     * @return
     */
    private MouseListener createListener () {
        return new MouseListener() {
            @Override
            public void mouseClicked (MouseEvent arg0) {
                if (arg0.getClickCount() == 2) {
                    new DetailView(myGameInfo, myResources, myModel);
                }
            }

            // these actions don't trigger any events.
            @Override
            public void mouseReleased (MouseEvent arg0) {
            }

            @Override
            public void mousePressed (MouseEvent arg0) {
            }

            @Override
            public void mouseExited (MouseEvent arg0) {
            }

            @Override
            public void mouseEntered (MouseEvent arg0) {
            }

        };
    }
}
