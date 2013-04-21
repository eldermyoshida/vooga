package arcade.view.forms;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ResourceBundle;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import arcade.exceptions.AgeException;
import arcade.exceptions.InvalidPriceException;
import arcade.model.Model;
import arcade.view.TextKeywords;


/**
 * This view allows a user to publish a new game.
 * 
 * @author Ellango
 * 
 */
@SuppressWarnings({"serial", "unused"})
public class PublishView extends Form {
    private static final int DESCRIPTION_HEIGHT = 300;
    private static final int DESCRIPTION_WIDTH = 280;
    private static final int SINGLEPLAYER_WIDTH = 43;
    private static final int MULTIPLAYER_WIDTH = 54;
    private static final String DEFAULT_IMAGE =
            new File(System.getProperty("user.dir") + "/src/arcade/resources/images/NoImage.jpg")
                    .getPath();

    private JTextField myNameTextField;
    private JTextField myGenreTextField;
    private JTextField myAuthorTextField;
    private JTextField myPriceTextField;
    private JTextField myAgeTextField;
    private JTextArea myDescriptionTextField = new JTextArea();
    private String mySmallImagePath = DEFAULT_IMAGE;
    private String myLargeImagePath = DEFAULT_IMAGE;
    private String mySinglePlayerPath;
    private boolean isSinglePlayer;
    private String myMultiPlayerPath;
    private boolean isMultiPlayer;

    /**
     * Constructs the publish view dialog box with a Model and ResourceBundle.
     * 
     * @param model
     * @param resources
     */
    public PublishView (Model model, ResourceBundle resources) {
        super(model, resources);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Creates the field to enter the name of the game.
     * 
     * @return
     */
    private JComponent createNameField () {
        myNameTextField = new JTextField();
        return createTextPanel(TextKeywords.GAME_NAME, myNameTextField);
    }

    /**
     * Creates the field to enter the genre for the game.
     * 
     * @return
     */
    private JComponent createGenreField () {
        myGenreTextField = new JTextField();
        return createTextPanel(TextKeywords.GENRE, myGenreTextField);
    }

    /**
     * Creates the field to enter the author for the game.
     * 
     * @return
     */
    private JComponent createAuthorField () {
        myAuthorTextField = new JTextField();
        return createTextPanel(TextKeywords.AUTHOR, myAuthorTextField);
    }

    /**
     * Creates the field to enter the price of the game.
     * 
     * @return
     */
    private JComponent createPriceField () {
        myPriceTextField = new JTextField();
        return createTextPanel(TextKeywords.PRICE, myPriceTextField);
    }

    /**
     * Creates the field to enter the age rating for the game.
     * 
     * @return
     */
    private JComponent createAgeTextField () {
        myAgeTextField = new JTextField();
        return createTextPanel(TextKeywords.AGE_RATING, myAgeTextField);
    }

    /**
     * Creates the field to select the game's small picture
     */
    private JComponent createSmallImageSelector () {
        return createImageSelector(TextKeywords.SMALL_PICTURE,
                                   TextKeywords.FILE_SELECT,
                                   new FileChooserAction() {
                                       @Override
                                       public void approve (JFileChooser chooser) {
                                           mySmallImagePath = chooser.getSelectedFile().getPath();
                                       }
                                   });
    }

    /**
     * Creates the field to select the game's large picture
     */
    private JComponent createLargeImageSelector () {
        return createImageSelector(TextKeywords.LARGE_PICTURE,
                                   TextKeywords.FILE_SELECT,
                                   new FileChooserAction() {
                                       @Override
                                       public void approve (JFileChooser chooser) {
                                           myLargeImagePath = chooser.getSelectedFile().getPath();
                                       }
                                   });
    }

    /**
     * Creates the field to check if the game is single player, and if so,
     * select the file that extends Game.
     * 
     * @return
     */
    private JComponent createSinglePlayerCheckBox () {
        return createCheckBox(TextKeywords.SINGLE_PLAYER,
                              TextKeywords.SINGLE_PLAYER_INSTRUCTION,
                              SINGLEPLAYER_WIDTH,
                              new FileChooserAction() {
                                  @Override
                                  public void approve (JFileChooser chooser) {
                                      isSinglePlayer = true;
                                      mySinglePlayerPath = chooser.getSelectedFile().getPath();
                                  }
                              });

    }

    /**
     * Creates the field to check if the game is multiplayer, and if so,
     * select the file that extends MultiPlayerGame.
     * 
     * @return
     */
    private JComponent createMultiPlayerCheckBox () {
        return createCheckBox(TextKeywords.MULTIPLAYER,
                              TextKeywords.MULTIPLAYER_INSTRUCTION,
                              MULTIPLAYER_WIDTH,
                              new FileChooserAction() {
                                  @Override
                                  public void approve (JFileChooser chooser) {
                                      isMultiPlayer = true;
                                      myMultiPlayerPath = chooser.getSelectedFile().getPath();
                                  }
                              });
    }

    /**
     * Creates the button that pops up the description area.
     * 
     * @return
     */
    private JComponent createDescriptionButton () {
        return createButton(TextKeywords.DESCRIPTION_MESSAGE,
                            new ActionListener() {
                                @Override
                                public void actionPerformed (ActionEvent arg0) {
                                    createDescriptionArea();
                                }
                            });
    }

    /**
     * Adds a scrollable description text entry field where the user can enter
     * a description for the game.
     * 
     * Only a single description area can be added to the window.
     */
    private void createDescriptionArea () {
        JPanel mainPanel = (JPanel) getContentPane();
        JPanel backgroundPanel = (JPanel) mainPanel.getComponent(0);
        if (backgroundPanel.getComponentCount() == 1) {
            JPanel descriptionPanel = new JPanel();
            descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));
            descriptionPanel.add(new JLabel(getResources().getString(TextKeywords.DESCRIPTION)));

            myDescriptionTextField.setWrapStyleWord(true);
            myDescriptionTextField.setLineWrap(true);
            JScrollPane scrollPane = new JScrollPane(myDescriptionTextField);
            scrollPane.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setPreferredSize(new Dimension(DESCRIPTION_WIDTH, DESCRIPTION_HEIGHT));
            descriptionPanel.add(scrollPane);

            backgroundPanel.add(descriptionPanel);
            pack();
            setLocationRelativeTo(null);
        }
    }

    /**
     * Creates the button to publish and tell the Model
     * 
     * @return
     */
    private JComponent createPublishButton () {
        return createButton(TextKeywords.PUBLISH, new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                publish();
            }
        });
    }

    /**
     * Try telling model to publish a new game.  Inform the user if invalid 
     * inputs.
     */
    private void publish () {
        try {
            getModel().publish(myNameTextField.getText(),
                               myGenreTextField.getText(),
                               myAuthorTextField.getText(),
                               getPrice(),
                               mySinglePlayerPath,
                               myMultiPlayerPath,
                               getAgeRating(),
                               isSinglePlayer,
                               isMultiPlayer,
                               mySmallImagePath,
                               myLargeImagePath,
                               myDescriptionTextField.getText());
            dispose();
        }
        catch (InvalidPriceException e) {
            sendMessage(getResources().getString(TextKeywords.PRICE_ERROR));
            myPriceTextField.setText("");
        }
        catch (AgeException e) {
            sendMessage(getResources().getString(TextKeywords.AGE_ERROR));
            myAgeTextField.setText("");
        }
    }
    
    /**
     * Gets the price entered by the user.
     * @return
     * @throws InvalidPriceException if not valid.
     */
    private double getPrice() throws InvalidPriceException {
        try {
            double price = Double.parseDouble(myPriceTextField.getText());
            if (price < 0) throw new InvalidPriceException();
            return price;
        }
        catch (NumberFormatException e) {
            throw new InvalidPriceException();
        }
    }
    
    /**
     * Gets the age rating entered by the user. 
     * @return
     * @throws AgeException
     */
    private int getAgeRating() throws AgeException {
        try {
            int age = Integer.parseInt(myAgeTextField.getText());
            if (age < 0) throw new AgeException();
            return age;
        }
        catch (NumberFormatException e) {
            throw new AgeException();
        }
    }
}
