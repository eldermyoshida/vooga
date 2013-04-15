package vooga.towerdefense.view;

import java.awt.Dimension;
import javax.swing.JButton;

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
     * constructor.
     * @param title
     * @param size
     */
    public GameElementInformationScreen (String title, Dimension size) {
        super(title, size);
        upgradeButton = new JButton(UPGRADE_BUTTON_NAME);
        upgradeButton.setVisible(false);
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
    public void displayUpgradesAndButton() {
        upgradeButton.setVisible(true);
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

}
