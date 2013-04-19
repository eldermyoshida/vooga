package arcade.view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import arcade.games.GameInfo;
import arcade.model.Model;
import arcade.view.MainView;
import arcade.view.SnapShot;


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

    /**
     * 
     */
    private MainView myUpperLevel;

    /**
     * Constructor
     */
    public GameCenterPanel (MainView mv, Model m) {
        myUpperLevel = mv;
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
     */
    private void createGameJList () {
            for (GameInfo info : myUpperLevel.getGameList()) {
                SnapShot temp = new SnapShot(info, myUpperLevel.getResources(), myModel);
                add(temp);
            }
    }
}
