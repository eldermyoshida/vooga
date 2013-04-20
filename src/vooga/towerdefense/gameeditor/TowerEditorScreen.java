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
     * title constant.
     */
    private static final String TITLE_NAME = "TOWER ";
    /**
     * constant for the image selector button
     */
    private static final String IMAGE_SELECTOR_KEYWORD = "Select Image From File";
    /**
     * constant for text field width.
     */
    private static final int TEXT_FIELD_WIDTH = 50;
    /**
     * constant for text field height.
     */
    private static final int TEXT_AREA_HEIGHT = 15;
    /**
     * constant for text field width.
     */
    private static final int TEXT_AREA_WIDTH = 50;
    /**
     * constant for text field height.
     */
    private static final int TEXT_FIELD_HEIGHT = 50;
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
     * area where attributes the user has selected are displayed.
     */
    private JTextArea myAttributesSelected;
    
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
        JPanel attributesSection = new JPanel(new BorderLayout());
        myAttributesBox = new JComboBox();
        Class attributesClass = Class.forName(ATTRIBUTES_CLASS_PATH);
        Field fieldList[] = attributesClass.getDeclaredFields();
        for (Field field : fieldList) {
            myAttributesBox.addItem(field.getName());
        }
        attributesSection.add(myAttributesBox, BorderLayout.NORTH);
        myAttributesSelected = new JTextArea();
        attributesSection.add(new JScrollPane(myAttributesSelected), BorderLayout.WEST);
        add(attributesSection, BorderLayout.SOUTH);
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
        add(characteristicsPanel, BorderLayout.CENTER); 
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
            }
        };
        return mouseAdapter;
    }
}
