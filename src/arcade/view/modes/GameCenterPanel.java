package arcade.view.modes;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ResourceBundle;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import arcade.model.Model;
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
     * Creates the GameCenterPanel with a Model and ResourceBundle
     */
    public GameCenterPanel (Model model, ResourceBundle resources) {      
        setBackground(Color.WHITE);
        AllSnapShots allSnapShots = new AllSnapShots(model, resources, new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        add(new JScrollPane(allSnapShots));
    }
}
