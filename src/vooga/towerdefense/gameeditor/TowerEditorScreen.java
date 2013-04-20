package vooga.towerdefense.gameeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.lang.reflect.Field;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Attributes;

/**
 * TowerEditorScreen is responsible for helping
 *      the game developer make towers.
 *
 * @author Angelica Schwartz
 */
public class TowerEditorScreen extends GameEditorScreen {

    /**
     * default serialized id.
     */
    private static final long serialVersionUID = 1L;
    /**
     * specifies user directory.
     */
    private static final String USER_DIR = "user.dir";
    /**
     * next screen constant.
     */
    private static final String NEXT_SCREEN_NAME = "UnitEditorScreen";
    /**
     * class path for the attribute constants interface.
     */
    private static final String ATTRIBUTES_CLASS_PATH = "vooga.towerdefense.attributes.AttributeConstants";
    /**
     * constant for the attribute selector button
     */
    private static final String ATTRIBUTES_ADD_BUTTON_TEXT = "Add attribute";
    /**
     * title constant.
     */
    private static final String TITLE_NAME = "TOWER ";
    /**
     * constant for the image selector button
     */
    private static final String IMAGE_SELECTOR_KEYWORD = "Select Image From File";
    /**
     * constant for text field height.
     */
    private static final int TEXT_FIELD_HEIGHT = 15;
    /**
     * constant for text area height.
     */
    private static final int TEXT_AREA_HEIGHT = 25;
    /**
     * constant for text field & area width.
     */
    private static final int TEXT_WIDTH = 25;
    /**
     * used to choose file in the directory.
     */
    private JFileChooser myFileChooser;
    /**
     * mouse listener for this screen.
     */
    private MouseAdapter myMouseAdapter;
    /**
     * box to enter the name of the tower.
     */
    private JTextField myNameBox;
    /**
     * box to enter the image of the tower.
     */
    private JTextField myImageBox;
    /**
     * button to get the image of the tower from the file system.
     */
    private JButton myImageSelector;
    /**
     * drop down menu with the attributes available.
     */
    private JComboBox myAttributesBox;
    /**
     * button to add attributes to this tower.
     */
    private JButton myAddAttributeButton;
    /**
     * area where attributes the user has selected are displayed.
     */
    private JTextArea myAttributesSelected;
    /**
     * area where the game developer can enter the
     *          attributes value.
     */
    private JTextField myAttributeValue;
    
    /**
     * Constructor.
     * @param size
     * @param controller
     */
    public TowerEditorScreen(Dimension size, GameEditorController controller) {
        super(size, controller, TITLE_NAME, NEXT_SCREEN_NAME);
        myFileChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));
        myMouseAdapter = makeSpecificMouseAdapter();
        addCharacteristicsPanel();
        try {
            addAttributesSection();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * adds this level to the game.
     */
    @Override
    public void addElementToGame () {
        // TODO Auto-generated method stub
        getController().addTowerToGame();
    }
    
    /**
     * helper method to make the actions drop down box.
     * @throws ClassNotFoundException 
     */
    private void addAttributesSection() throws ClassNotFoundException {
        JPanel attributesSection = new JPanel();
        myAttributesBox = new JComboBox();
        Class attributesClass = Class.forName(ATTRIBUTES_CLASS_PATH);
        Field fieldList[] = attributesClass.getDeclaredFields();
        for (Field field : fieldList) {
            myAttributesBox.addItem(field.getName());
        }
        attributesSection.add(myAttributesBox);
        myAttributeValue = new JTextField();
        attributesSection.add(myAttributeValue);
        myAttributesSelected = new JTextArea(TEXT_WIDTH, TEXT_AREA_HEIGHT);
        attributesSection.add(new JScrollPane(myAttributesSelected));
        myAddAttributeButton = new JButton(ATTRIBUTES_ADD_BUTTON_TEXT);
        myAddAttributeButton.addMouseListener(myMouseAdapter);
        attributesSection.add(myAddAttributeButton);
        add(attributesSection);
    }
    
    /**
     * helper method to make the text boxes
     *          and image button.
     */
    private void addCharacteristicsPanel() {
        JPanel characteristicsPanel = new JPanel(new BorderLayout());
        myNameBox = new JTextField();
        myImageBox = new JTextField();
        myImageSelector = new JButton(IMAGE_SELECTOR_KEYWORD);
        myImageSelector.addMouseListener(myMouseAdapter);
        characteristicsPanel.add(myNameBox, BorderLayout.NORTH);
        characteristicsPanel.add(myImageBox, BorderLayout.CENTER);
        characteristicsPanel.add(myImageSelector, BorderLayout.SOUTH);
        add(characteristicsPanel, BorderLayout.NORTH); 
    }
    
    /**
     * clears all fields in the TowerEditorScreen.
     */
    public void clearScreen() {
        myNameBox.setText("");
        myImageBox.setText("");
        myAttributesSelected.setText("");
    }
    
    /**
     * helper method to create the mouse listener.
     * @return mouse adapter
     */
    private MouseAdapter makeSpecificMouseAdapter() {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                if (e.getSource().equals(myImageSelector)) {
                    int response = myFileChooser.showOpenDialog(null);
                    if (response == JFileChooser.APPROVE_OPTION) {
                        File file =  myFileChooser.getSelectedFile();
                        String path = file.getPath().replace("%20", " ");
                        myImageBox.setText(path);
                    }
                }
                else if (e.getSource().equals(myAddAttributeButton)) {
                    myAttributesSelected.setText(myAttributesSelected.getText() + "\n"
                                                 + myAttributesBox.getSelectedItem().toString()
                                                 + " = " + myAttributeValue.getText());
                }
            }
        };
        return mouseAdapter;
    }
}