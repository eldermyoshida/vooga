package arcade.view.panels;

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
public class GameCenterPanel extends JPanel {

    /**
     * Constants
     */
    private static final long serialVersionUID = -3450136718366927535L;
    private static final int WIDTH = 550;
    private static final int HEIGHT = 600;
    private static final int HORIZONTAL_GAP = 5;
    private static final int VERTICAL_GAP = 5;
    private Model myModel;
    private ResourceBundle myResources;

    /**
     * 
     */
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

        createGameJList();
    }

    /**
     * Create the JList for games.
     * Fixed so that it tiles dynamically as games are added instead of repeating instances of games
     * @author Josh Waldman
     */
    private void createGameJList () {

        for (GameInfo info : myUpperLevel.getGameList()) {
            SnapShot temp = new SnapShot(info, myUpperLevel.getResources(), myModel);
            add(temp);
            
        }
    }
}
