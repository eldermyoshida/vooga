package arcade.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import arcade.model.Model;
import arcade.view.modes.GameCenterPanel;
import arcade.view.modes.SocialCenterPanel;
import arcade.view.modes.StorePanel;


/**
 * 
 * The panel where the buttons are placed to switch between Arcade Modes.
 * 
 * @author David Liu, Ellango Jothimurugesan, Henrique Moraes
 * 
 */
@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {
    private static final String IMAGES_DIRECTORY = System.getProperty("user.dir") +
                                                   "/src/arcade/resources/images/";
    private static final String GAME_CENTER_PICTURE_NAME = "GameCenterIcon.jpg";
    private static final String SOCIAL_CENTER_PICTURE_NAME = "SocialCenterIcon.jpg";
    private static final String GAME_STORE_PICTURE_NAME = "StoreIcon.jpg";
    private static final int BUTTON_SIZE = 140;

    private MainView myMainView;
    private Model myModel;
    private ResourceBundle myResources;
    private JToolBar myToolbar;

    /**
     * Creates a ButtonPanel with the mainView that it can manipulate by changing
     * which mode is showing, and a ResourceBundle
     * 
     * @param mainView
     * @param resources
     */
    public ButtonPanel (MainView mainView, Model model, ResourceBundle resources) {
        myMainView = mainView;
        myModel = model;
        myResources = resources;
        setBackground(Color.lightGray);

        myToolbar = new JToolBar(JToolBar.VERTICAL);
        myToolbar.setOpaque(false);
        myToolbar.setFloatable(false);
        fillToolbar();
        add(myToolbar);
    }

    /**
     * Creates the buttons in the toolbar.
     */
    private void fillToolbar () {
        makeButton(GAME_CENTER_PICTURE_NAME,
                   TextKeywords.GAME_CENTER,
                   new ActionListener() {
                       @Override
                       public void actionPerformed (ActionEvent arg0) {
                           myMainView.changeViewPanel(new GameCenterPanel(myModel, myResources));
                       }
                   });
        makeButton(SOCIAL_CENTER_PICTURE_NAME,
                   TextKeywords.SOCIAL_CENTER,
                   new ActionListener() {
                       @Override
                       public void actionPerformed (ActionEvent arg0) {
                           myMainView.changeViewPanel(new SocialCenterPanel());
                       }
                   });
        makeButton(GAME_STORE_PICTURE_NAME,
                   TextKeywords.GAME_STORE,
                   new ActionListener() {
                       @Override
                       public void actionPerformed (ActionEvent arg0) {
                           myMainView.changeViewPanel(new StorePanel(myModel, myResources));
                       }
                   });
    }

    /**
     * Makes a single button with the filename of the image to place on the button,
     * and the ArcadeMode that it changes the MainView to. The button is labeled
     * with the description.
     * 
     * @param imageFilename
     * @param mode
     * @return
     */
    private void makeButton (String imageFilename, String descriptionKey, ActionListener action) {
        JButton button = new JButton(createScaledIcon(imageFilename, BUTTON_SIZE));
        button.addActionListener(action);
        button.setOpaque(false);
        myToolbar.add(button);
        myToolbar.add(new JLabel("<html><b><font size = 5><font face = champion>"
                                 + myResources.getString(descriptionKey)));
    }

    /**
     * A small utility method used to create an image icon from the provided
     * filepath, scaled to the desired size.
     * 
     * @param imageFilename
     * @param size
     * @return
     */
    private ImageIcon createScaledIcon (String imageFilename, int size) {
        Image image = new ImageIcon(IMAGES_DIRECTORY + imageFilename).getImage();
        BufferedImage buffer = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = buffer.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image, 0, 0, size, size, null);
        g2.dispose();
        return new ImageIcon(buffer);
    }
}
