package arcade.view.modes;

import java.awt.Dimension;
import java.util.ResourceBundle;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import arcade.controller.Controller;
import arcade.view.AllSnapShots;

/**
 * 
 * The GameCenterPanel is where the user can view SnapShots for all the games
 * s/he has bought.  These SnapShots can be clicked to launch a more detailed
 * view for that game.
 * 
 * @author David Liu, Ellango Jothimurugesan
 *
 */
@SuppressWarnings("serial")
public class GameCenterPanel extends JPanel {

    private static final int PANEL_HEIGHT = 540;
    private static final int PANEL_WIDTH = 590;

    /**
     * Creates the GameCenterPanel with a Controller and ResourceBundle
     */
    public GameCenterPanel (Controller controller, ResourceBundle resources) {
        AllSnapShots allSnapShots = new AllSnapShots(controller, resources, new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        add(new JScrollPane(allSnapShots));
    }
}
