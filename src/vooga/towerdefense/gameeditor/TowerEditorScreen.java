package vooga.towerdefense.gameeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
     * constant for text area width.
     */
    private static final int TEXT_AREA_WIDTH = 10;
    /**
     * constant for text area height.
     */
    private static final int TEXT_AREA_HEIGHT = 25;
    /**
     * class path for the attribute constants interface.
     */
    private static final String ATTRIBUTES_CLASS_PATH = "vooga.towerdefense.attributes.AttributeConstants";
    /**
     * package path for actions package.
     */
    private static final String ACTION_PACKAGE_PATH = "vooga.towerdefense.action";
    /**
     * constant for the attribute selector button.
     */
    private static final String ATTRIBUTES_ADD_BUTTON_TEXT = "Add attribute";
    /**
     * constant for the action selector button.
     */
    private static final String ACTION_ADD_BUTTON_TEXT = "Add action";
    /**
     * constant for the action delete button.
     */
    private static final String ACTION_DELETE_BUTTON_TEXT = "Clear selected action";
    /**
     * constant for the attributes delete button.
     */
    private static final String ATTRIBUTE_DELETE_BUTTON_TEXT = "Clear selected action";
    /**
     * constant for the action section title.
     */
    private static final String ACTION_TITLE = "Actions";
    /**
     * constant for the attribute section title.
     */
    private static final String ATTRIBUTE_TITLE = "Attributes";
    /**
     * string ending that indicates this file is a class.
     */
    private static final String CLASS_INDICATOR_STRING = ".class";
    /**
     * title constant.
     */
    private static final String TITLE_NAME = "TOWER ";
    /**
     * constant for the image selector button.
     */
    private static final String IMAGE_SELECTOR_KEYWORD = "Select Image From File";
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
     * button to delete attributes from this tower.
     */
    private JButton myDeleteAttributeButton;
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
     * drop down menu with the actions available.
     */
    private JComboBox myActionsBox;
    /**
     * button to add actions to this tower.
     */
    private JButton myAddActionButton;
    /**
     * button to delete actions from this tower.
     */
    private JButton myDeleteActionButton;
    /**
     * area where actions the user has selected are displayed.
     */
    private JTextArea myActionsSelected;
    
    /**
     * Constructor.
     * @param size
     * @param controller
     */
    public TowerEditorScreen(Dimension size, GameEditorController controller) {
        super(size, controller, TITLE_NAME, NEXT_SCREEN_NAME);
        myFileChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));
        myMouseAdapter = makeSpecificMouseAdapter();
        makeScreen();
    }
    
    /**
     * helper method to create all the parts of
     *          the TowerEditorScreen.
     */
    private void makeScreen() {   
        addCharacteristicsPanel();
        try {
            JPanel attributes = makeAttributesSection();
            JPanel actions = makeActionsSection();
            JPanel bottomScreen = new JPanel(new BorderLayout());
            bottomScreen.add(attributes, BorderLayout.NORTH);
            bottomScreen.add(actions, BorderLayout.SOUTH);
            add(bottomScreen, BorderLayout.SOUTH);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
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
     * clears all fields in the TowerEditorScreen.
     */
    public void clearScreen() {
        myNameBox.setText("");
        myImageBox.setText("");
        myAttributesSelected.setText("");
        myActionsSelected.setText("");
    }

    /**
     * helper method to make the text boxes for
     *          name and image + image button.
     */
    private void addCharacteristicsPanel() {
        JPanel characteristicsPanel = new JPanel();
        myNameBox = new JTextField(TEXT_AREA_WIDTH);
        myImageBox = new JTextField(TEXT_AREA_WIDTH);
        myImageSelector = new JButton(IMAGE_SELECTOR_KEYWORD);
        myImageSelector.addMouseListener(myMouseAdapter);
        characteristicsPanel.add(new JLabel("Name: "));
        characteristicsPanel.add(myNameBox);
        characteristicsPanel.add(new JLabel("Image: "));
        characteristicsPanel.add(myImageBox);
        characteristicsPanel.add(myImageSelector);
        add(characteristicsPanel, BorderLayout.NORTH); 
    }
    
    /**
     * helper method to make the actions section of this screen.
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    private JPanel makeActionsSection() throws ClassNotFoundException, IOException {
        JPanel actionSection = new JPanel(new BorderLayout());
        JPanel westSide = new JPanel(new BorderLayout());
        westSide.add(new JLabel(ACTION_TITLE), BorderLayout.NORTH);
        myActionsBox = new JComboBox();
        List<String> actions = getAvailableActions(ACTION_PACKAGE_PATH); 
        for (String s : actions) {
            myActionsBox.addItem(s);
        }
        westSide.add(myActionsBox, BorderLayout.CENTER);
        actionSection.add(westSide, BorderLayout.WEST);
        myActionsSelected = new JTextArea(TEXT_AREA_WIDTH, TEXT_AREA_HEIGHT);
        actionSection.add(new JScrollPane(myActionsSelected), BorderLayout.CENTER);
        myAddActionButton = new JButton(ACTION_ADD_BUTTON_TEXT);
        myAddActionButton.addMouseListener(myMouseAdapter);
        JPanel optionsSubPanel = new JPanel(new BorderLayout());
        optionsSubPanel.add(myAddActionButton, BorderLayout.NORTH);
        myDeleteActionButton = new JButton(ACTION_DELETE_BUTTON_TEXT);
        myDeleteActionButton.addMouseListener(myMouseAdapter);
        optionsSubPanel.add(myDeleteActionButton, BorderLayout.SOUTH);
        JPanel eastSide = new JPanel(new BorderLayout());
        eastSide.add(optionsSubPanel, BorderLayout.NORTH);
        actionSection.add(eastSide, BorderLayout.EAST);
        return actionSection;
    }
    
    /**
     * helper method to make the attributes drop down box,
     *          button, and text field.
     * @throws ClassNotFoundException 
     */
    private JPanel makeAttributesSection() throws ClassNotFoundException {
        JPanel attributesSection = new JPanel(new BorderLayout());
        JPanel optionsSubPanel1 = new JPanel(new BorderLayout());
        optionsSubPanel1.add(new JLabel(ATTRIBUTE_TITLE), BorderLayout.NORTH);
        myAttributesBox = new JComboBox();
        Class attributesClass = Class.forName(ATTRIBUTES_CLASS_PATH);
        Field fieldList[] = attributesClass.getDeclaredFields();
        for (Field field : fieldList) {
            myAttributesBox.addItem(field.getName());
        }
        optionsSubPanel1.add(myAttributesBox, BorderLayout.CENTER);
        myAttributeValue = new JTextField();
        optionsSubPanel1.add(myAttributeValue, BorderLayout.SOUTH);
        attributesSection.add(optionsSubPanel1, BorderLayout.WEST);
        myAttributesSelected = new JTextArea(TEXT_AREA_WIDTH, TEXT_AREA_HEIGHT);
        attributesSection.add(new JScrollPane(myAttributesSelected), BorderLayout.CENTER);
        JPanel optionsSubPanel2 = new JPanel(new BorderLayout());
        myAddAttributeButton = new JButton(ATTRIBUTES_ADD_BUTTON_TEXT);
        myAddAttributeButton.addMouseListener(myMouseAdapter);
        optionsSubPanel2.add(myAddAttributeButton, BorderLayout.NORTH);
        myDeleteAttributeButton = new JButton(ATTRIBUTE_DELETE_BUTTON_TEXT);
        myDeleteAttributeButton.addMouseListener(myMouseAdapter);
        optionsSubPanel2.add(myDeleteAttributeButton, BorderLayout.SOUTH);
        JPanel eastSide = new JPanel(new BorderLayout());
        eastSide.add(optionsSubPanel2, BorderLayout.NORTH);
        attributesSection.add(eastSide, BorderLayout.EAST);
        return attributesSection;
    }

    /**
     * helper method to get the classes in this package.
     * @param packageName
     * @return list of classes in the package
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    @SuppressWarnings("rawtypes")
    private List<String> getAvailableActions(String packageName) throws IOException, ClassNotFoundException {
        List<String> classNames = new ArrayList<String>();
        List<Class> classes = new ArrayList<Class>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".", "/");
        URL resource = classLoader.getResource(path);
        File directory = new File(resource.getFile());
        if (directory.exists()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.getName().endsWith(CLASS_INDICATOR_STRING)) {
                    classes.add(Class.forName(packageName + "." +
                            file.getName().subSequence(0, file.getName().length()
                                 - CLASS_INDICATOR_STRING.length())));
                }
            }
        }
        for (Class c : classes) {
            classNames.add(c.getName().substring(packageName.length()+1, c.getName().length()));
        }
        if (classNames.contains("Action")) {
            classNames.remove("Action");
        }
        return classNames;
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
                else if (e.getSource().equals(myAddActionButton)) {
                    myActionsSelected.setText(myActionsSelected.getText() + "\n"
                            + myActionsBox.getSelectedItem().toString());   
                }
                else if (e.getSource().equals(myDeleteAttributeButton)) {
                    myAttributesSelected.replaceSelection("");
                }
                else if (e.getSource().equals(myDeleteActionButton)) {
                    myActionsSelected.replaceSelection("");
                }
            }
        };
        return mouseAdapter;
    }
}
