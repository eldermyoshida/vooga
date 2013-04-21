package arcade.view.forms;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import arcade.model.Model;
import arcade.view.TextKeywords;


@SuppressWarnings("serial")
public class PublishView extends Form {
    private static final int CHECKBOX_TRAILING_WIDTH = 35;
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

    @Override
    protected List<JComponent> makeComponents () {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(createNameField());
        components.add(createGenreField());
        components.add(createAuthorField());
        components.add(createPriceField());
        components.add(createAgeTextField());
        components.add(createSmallImageSelector());
        components.add(createLargePictureSelector());
        components.add(createPlayerCheckBox(TextKeywords.SINGLE_PLAYER, TextKeywords.SINGLE_PLAYER_INSTRUCTION, SINGLEPLAYER_WIDTH));
        components.add(createPlayerCheckBox(TextKeywords.MULTIPLAYER, TextKeywords.MULTIPLAYER_INSTRUCTION, MULTIPLAYER_WIDTH));
        components.add(createDescriptionButton());
        components.add(createPublishButton());
        return components;
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
     * Creates the checkbox for the user to enter if the checkBoxMessage is true,
     * and if so, pops up a file chooser to select what is specified by 
     * instructionKeyword.  
     * 
     * There is the specified width between the checkbox and the checkbox message.
     * @return
     */
    private JComponent createPlayerCheckBox(String checkBoxMessageKeyword, 
                                            final String instructionKeyword,
                                            int width) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        JLabel label = new JLabel(getResources().getString(checkBoxMessageKeyword));
        panel.add(label);
        
        panel.add(Box.createHorizontalStrut(width));
        
        JCheckBox box = new JCheckBox();
        box.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed (ActionEvent arg0) {
                JOptionPane.showMessageDialog(null, 
                                              getResources().getString(instructionKeyword),
                                              getResources().getString(TextKeywords.POPUP_TITLE),
                                              JOptionPane.INFORMATION_MESSAGE);
                JFileChooser chooser = new JFileChooser();
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    isSinglePlayer = true;
                    mySinglePlayerPath = chooser.getSelectedFile().getPath();
                }
            }
        });
        box.setOpaque(false);
        panel.add(box);
        
        panel.add(Box.createHorizontalStrut(CHECKBOX_TRAILING_WIDTH));
        
        return panel;
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
    private JComponent createLargePictureSelector () {
        return createImageSelector(TextKeywords.LARGE_PICTURE,
                                   TextKeywords.FILE_SELECT,
                                   new FileChooserAction() {
                                       @Override
                                       public void approve (JFileChooser chooser) {
                                           myLargeImagePath = chooser.getSelectedFile().getPath();
                                       }
                                   });
    }

    private JComponent createDescriptionButton () {
        JPanel panel = new JPanel();
        JButton button = new JButton(getResources().getString(TextKeywords.DESCRIPTION_MESSAGE));
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent arg0) {
                createDescriptionArea();
            }
        });
        panel.add(button);
        return panel;
    }

    /**
     * Creates the button to publish and tell the Model
     * 
     * @return
     */
    private JComponent createPublishButton () {
        JPanel panel = new JPanel();
        JButton publish = new JButton(getResources().getString(TextKeywords.PUBLISH));
        publish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                getModel().publish(myNameTextField.getText(),
                                   myGenreTextField.getText());

                dispose();
            }
        });
        panel.add(publish);
        return panel;
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

    public static void main (String[] args) {
        new PublishView(null, ResourceBundle.getBundle("arcade.resources.English"));
    }
}
