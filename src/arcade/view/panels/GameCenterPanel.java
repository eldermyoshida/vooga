package arcade.view.panels;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import arcade.games.GameInfo;
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

    /**
         * 
         */
    private JList myGameList;
    private DefaultListModel gameListModel;

    /**
     * Constructor
     */
    public GameCenterPanel () {
        GridLayout gamePanelLayout = new GridLayout(0, 2);
        gamePanelLayout.setHgap(HORIZONTAL_GAP);
        gamePanelLayout.setVgap(VERTICAL_GAP);
        setLayout(gamePanelLayout);
        // JList
        createGameJList();
        //

    }

    /**
     * Create the JList for games.
     */
    private void createGameJList () {
        //GameInfo gi = new GameInfo("example");
        //this.add(new SnapShot(gi));

    }

    /**
     * TODO:
     * Return the list of games in the GameList.
     */
    public List gameListContent () {
        return null;
    }

    /**
     * TODO:
     * Update the List of games
     */
    public void updateGameList (List inputList) {

    }
}
