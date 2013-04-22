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
 * @author David Liu, Ellango Jothimurugesan
 *
 */
@SuppressWarnings("serial")
public class GameCenterPanel extends JPanel {

    private static final int PANEL_HEIGHT = 530;
    private static final int PANEL_WIDTH = 590;

    /**
     * 
     */
    public GameCenterPanel (Model model, ResourceBundle resources) {      
        setBackground(Color.WHITE);
        AllSnapShots allSnapShots = new AllSnapShots(model, resources, new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        add(new JScrollPane(allSnapShots));
    }
}
