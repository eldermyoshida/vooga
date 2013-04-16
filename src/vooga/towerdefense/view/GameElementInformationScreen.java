package vooga.towerdefense.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import vooga.towerdefense.controller.Controller;

/**
 * This screen is specifically designed to display game element
 *      information, including an option to upgrade if applicable. 
 *
 * @author Angelica Schwartz
 */
public class GameElementInformationScreen extends InformationScreen {

    //TODO: load from resources
    private static final String UPGRADE_BUTTON_NAME = "Upgrade";
    /**
     * text area for this screen.
     */
    private JTextArea myTextArea;
    /**
     * button to click to upgrade a game element.
     */
    private JButton upgradeButton;
    /**
     * drop down list to show upgrade options.
     */
    private JComboBox upgradeOptionsBox;
    /**
     * holds the upgrade button & options box.
     */
    private JPanel myUpgradeSection;
    /**
     * mouselistener for click on a button.
     */
    private MouseAdapter myMouseAdapter;
    /**
     * controller needed to handle upgrade information.
     */
    private Controller myController;
    
    /**
     * constructor.
     * @param title
     * @param size
     */
    public GameElementInformationScreen (String title, Dimension size, Controller controller) {
        super(title, size);
        myController = controller;
        add(getTextArea(), BorderLayout.CENTER);
        makeMouseAdapter();
        setUpUpgradeSection();
    }

    /**
     * default serialized id.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * displays the upgrade options in a drop down menu
     *          and the upgrade button.
     */
    public void displayUpgradesAndButton(List<String> upgrades) {
        upgradeOptionsBox.removeAllItems();
        for (String upgrade : upgrades) {
            upgradeOptionsBox.addItem(upgrade);
        }
        myUpgradeSection.setVisible(true);
    }
    
    /**
     * Overrides the clear screen to get rid of the
     *  element information, and the upgrade information.
     */
    @Override
    public void clearScreen() {
        super.clearScreen();
        upgradeButton.setVisible(false);
    }
    
    /**
     * helper method to create the mouse listener.
     */
    private void makeMouseAdapter() {
        myMouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                if (e.getSource().equals(upgradeButton) && upgradeButton.isVisible()) {
                    String upgrade = (String) upgradeOptionsBox.getSelectedItem();
                    myController.upgradeSelectedItemTo(upgrade);                    
                }
            }
        };
    }
    
    /**
     * helper method to set up the upgrade button
     *          and drop down box with upgrade options.
     */
    private void setUpUpgradeSection() {
        myUpgradeSection = new JPanel();
        upgradeButton = new JButton(UPGRADE_BUTTON_NAME);
        upgradeButton.addMouseListener(myMouseAdapter);
        upgradeOptionsBox = new JComboBox();
        myUpgradeSection.setLayout(new BorderLayout());
        myUpgradeSection.add(upgradeOptionsBox, BorderLayout.CENTER);
        myUpgradeSection.add(upgradeButton, BorderLayout.SOUTH);
        myUpgradeSection.setVisible(false);
        add(myUpgradeSection, BorderLayout.SOUTH);
    }

}
