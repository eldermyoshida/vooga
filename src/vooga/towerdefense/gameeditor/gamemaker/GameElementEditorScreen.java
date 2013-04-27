package vooga.towerdefense.gameeditor.gamemaker;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * GameElementEditorScreen is responsible for helping
 * the game developer make game elements.
 * 
 * @author Angelica Schwartz
 */
public class GameElementEditorScreen extends ElementWithActionEditorScreen {

    /**
     * default serialized id.
     */
    private static final long serialVersionUID = 1L;
    /**
     * next screen constant.
     */
    private static final String NEXT_SCREEN_NAME = "RuleEditorScreen";
    /**
     * package for the action factories.
     */
    private static final String ACTION_PACKAGE_PATH = "vooga.towerdefense.factories.actionfactories";
    /**
     * package for the images.
     */
    private static final String IMAGE_PACKAGE_PATH = "vooga.towerdefense.images";
    /**
     * package for the attributes.
     */
    private static final String ATTRIBUTE_CLASS_PATH = "vooga.towerdefense.attributes.AttributeConstants";
    /**
     * text on button to add a new type.
     */
    private static final String ADD_NEW_TYPE_TEXT = "Add new type";
    /**
     * title constant.
     */
    private static final String TITLE_NAME = "GAME ELEMENT ";
    /**
     * keyword for units.
     */
    private static final String UNIT_TYPE = "Unit";
    /**
     * keyword for towers.
     */
    private static final String TOWER_TYPE = "Tower";
    /**
     * keyword for projectiles.
     */
    private static final String PROJECTILE_TYPE = "Projectile";
    /**
     * arraylist with the default available types.
     */
    private List<String> myAvailableTypes;
    /**
     * box to enter the type of the game element.
     */
    private JComboBox myTypeBox;
    /**
     * box to enter the image of the game element.
     */
    private JComboBox myImageBox;
    /**
     * box to enter the dimension of the game element.
     */
    private JTextField myDimensionBox;
    /**
     * button add a new type of game element.
     */
    private JButton myAddTypeButton;
    /**
     * attributes section for this game element screen.
     */
    private JPanel myAttributesSection;

    /**
     * Constructor.
     * 
     * @param size
     * @param controller
     * @throws ClassNotFoundException 
     * @throws IOException 
     */
    public GameElementEditorScreen (Dimension size, GameEditorController controller) throws ClassNotFoundException, IOException {
        super(size, controller, TITLE_NAME, NEXT_SCREEN_NAME);
        myAvailableTypes = new ArrayList<String>();
        myAvailableTypes.add(UNIT_TYPE);
        myAvailableTypes.add(TOWER_TYPE);
        myAvailableTypes.add(PROJECTILE_TYPE);
        setActionPath(ACTION_PACKAGE_PATH);
        myAttributesSection = makeAttributesSection(getController().getAttributes(ATTRIBUTE_CLASS_PATH));
        makeActionsSection(ACTION_PACKAGE_PATH);
        makeScreen();
    }
    
    /**
     * makes the game element editor screen.
     */
    @Override
    public void makeScreen() {
        super.makeScreen();
        JPanel dimensionPanel = new JPanel(new BorderLayout());
        dimensionPanel.add(new JLabel("Dimension: "), BorderLayout.WEST);
        myDimensionBox = new JTextField(TEXT_AREA_WIDTH);
        dimensionPanel.add(myDimensionBox, BorderLayout.EAST);
        add(dimensionPanel, BorderLayout.NORTH);
        add(myAttributesSection, BorderLayout.NORTH);
        JPanel typePanel = new JPanel(new BorderLayout());
        typePanel.add(new JLabel("Type: "), BorderLayout.NORTH);
        myAddTypeButton = new JButton(ADD_NEW_TYPE_TEXT);
        myAddTypeButton.addMouseListener(getMouseAdapter());
        typePanel.add(myAddTypeButton, BorderLayout.SOUTH);
        myTypeBox = new JComboBox();
        for (String type : myAvailableTypes) {
            myTypeBox.addItem(type);
        }
        typePanel.add(myTypeBox, BorderLayout.CENTER);
        add(typePanel, BorderLayout.NORTH);
        
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.add(new JLabel("Image: "), BorderLayout.NORTH);
        myImageBox = new JComboBox();
        List<String> images;
        images = getController().getFiles(IMAGE_PACKAGE_PATH);
        for (String imageName: images) {
            myImageBox.addItem(imageName);
        }
        imagePanel.add(myImageBox, BorderLayout.CENTER);
        add(imagePanel, BorderLayout.NORTH);
    }
    
    /**
     * clears the screen.
     */
    @Override
    public void clearScreen() {
        super.clearScreen();
        myDimensionBox.setText("");
        getAttributesSection().setText("");
    }

    /**
     * adds this game element to the game.
     */
    public void addElementToGame() {
        getController().addGameElementToGame(myTypeBox.getSelectedItem().toString(), getName(),
                                         myImageBox.getSelectedItem().toString(), myDimensionBox.getText(),
                                         getAttributes(),
                                         getActions());
    }

    /**
     * adds additional mouse behavior specific
     * to the GameElementEditorScreen.
     * 
     * @param e is the MouseEvent
     */
    @Override
    public void addAdditionalMouseBehavior (MouseEvent e) {
        super.addAdditionalMouseBehavior(e);
        if (e.getSource().equals(myAddTypeButton)) {
            String newType = JOptionPane.showInputDialog("Enter your new type");
            myTypeBox.addItem(newType);
            myTypeBox.setSelectedItem(newType);
        }
    }
}
