package vooga.rts.networking.client.GUI;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import vooga.rts.networking.communications.Player;

/**
 * Represents the view of the lobby.
 * @author David Winegar
 * @author Sean Wareham
 *
 */
public class LobbyView extends JPanel {

    private static final long serialVersionUID = -3777313562807648414L;
    private static final String NO_PLAYER = "";
    private static final int COLUMN_1 = 0;
    private static final int COLUMN_2 = 1;
    private static final int COLUMN_3 = 2;
    private static final int ROW_1 = 0;
    private int myMaxPlayers;
    JLabel[] myUsernameLabels;
    JComboBox[] myFactionBoxes;
    JComboBox[] myTeamBoxes;
    Player[] myPlayers;

    /**
     * Create the panel.
     */
    public LobbyView (String[] factions, int maxPlayers) {
        // initialize GridBagLayout
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
        gridBagLayout.rowHeights =
                new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights =
                new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                              0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        setLayout(gridBagLayout);

        // initialize state
        myMaxPlayers = maxPlayers;
        myUsernameLabels = new JLabel[myMaxPlayers];
        myTeamBoxes = new JComboBox[myMaxPlayers];
        myFactionBoxes = new JComboBox[myMaxPlayers];
        Integer[] teamNumList = new Integer[myMaxPlayers];
        for (int i = 0; i < myMaxPlayers; i++) {
            teamNumList[i] = i + 1;
        }

        // initialize labels and buttons for player slots
        for (int i = 0; i < myMaxPlayers; i++) {
            myUsernameLabels[i] = createLabel(NO_PLAYER, COLUMN_1, i + 1);
            myTeamBoxes[i] = createComboBox(teamNumList, COLUMN_2, i + 1);
            myFactionBoxes[i] = createComboBox(factions, COLUMN_3, i + 1);
        }

        // initialize title labels
        // TODO resources file
        createLabel("Player Name", COLUMN_1, ROW_1);
        createLabel("Team", COLUMN_2, ROW_1);
        createLabel("Faction", COLUMN_3, ROW_1);

    }

    /**
     * Creates a label and adds it to grid
     */
    private JLabel createLabel (String name, int xposition, int yposition) {
        JLabel label = new JLabel(name);
        label.setOpaque(true);
        GridBagConstraints labelConstraints = new GridBagConstraints();
        addComponentToGrid(xposition, yposition, label, labelConstraints);
        return label;
    }

    /**
     * Creates a combobox and adds it to grid
     */
    private JComboBox createComboBox (Object[] objectArray, int xposition, int yposition) {
        JComboBox box = new JComboBox();
        GridBagConstraints boxConstraints = new GridBagConstraints();
        boxConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponentToGrid(xposition, yposition, box, boxConstraints);
        box.setEnabled(false);
        return box;
    }

    /**
     * adds component to grid at specified place
     */
    private void addComponentToGrid (int xposition,
                                     int yposition,
                                     JComponent component,
                                     GridBagConstraints labelConstraints) {
        labelConstraints.insets = new Insets(0, 5, 5, 5);
        labelConstraints.gridx = xposition;
        labelConstraints.gridy = yposition;
        add(component, labelConstraints);
    }

    public void update (Player[] userControlledPlayers, List<ArrayList<Player>> players) {
        
    }

}
