package arcade.view.modes;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ResourceBundle;
import javax.swing.JPanel;
import arcade.games.GameInfo;
import arcade.model.Model;
import arcade.view.MainView;
import arcade.view.SnapShot;

/**
 * 
 * @author David Liu
 *
 */
@SuppressWarnings("serial")
public class GameCenterPanel extends JPanel {

    private static final int HORIZONTAL_GAP = 5;
    private static final int VERTICAL_GAP = 5;
    private Model myModel;
    private ResourceBundle myResources;
    private MainView myUpperLevel;

    /**
     * Constructor
     */
    public GameCenterPanel (MainView mv, Model m, ResourceBundle resources) {
        myUpperLevel = mv;
        myResources = resources;
        myModel = m;
        setBackground(Color.WHITE);
        GridLayout gamePanelLayout = new GridLayout(0, 2);
        gamePanelLayout.setHgap(HORIZONTAL_GAP);
        gamePanelLayout.setVgap(VERTICAL_GAP);
        setLayout(gamePanelLayout);

        createSnapShots();
    }

    /**
     * Create the snapshots for the games
     * Fixed so that it tiles dynamically as games are added instead of repeating instances of games
     * @author Josh Waldman
     */
    private void createSnapShots () {
        for (GameInfo info : myUpperLevel.getGameList()) {
            SnapShot temp = new SnapShot(info, myResources, myModel);
            add(temp);
        }
    }
}
