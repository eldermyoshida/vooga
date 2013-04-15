package vooga.towerdefense.view;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
     * button to click to upgrade a game element.
     */
    private JButton upgradeButton;
    /**
     * drop down list to show upgrade options.
     */
    private JComboBox upgradeOptionsBox;
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
        upgradeButton = new JButton(UPGRADE_BUTTON_NAME);
        upgradeButton.setVisible(false);
        makeMouseAdapter();
        upgradeButton.addMouseListener(myMouseAdapter);
        add(upgradeButton);
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
        upgradeButton.setVisible(true);
        upgradeOptionsBox = new JComboBox(upgrades.toArray());
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

}
