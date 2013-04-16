package vooga.towerdefense.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import vooga.towerdefense.controller.Controller;


/**
 * 
 * @author Leonard K. Ng'eno
 * 
 *         This class enables having multiple JPanels on the east border of the screen
 * 
 */
public class EastWindow extends JPanel {

    private static final long serialVersionUID = 1L;
    private InformationScreen myStatsWindow;
    private GameElementInformationScreen myInformationWindow;
    private Controller myController;
    private static final Dimension STATS_WINDOW_SIZE = new Dimension(200, 300);
    private static final Dimension INFO_WINDOW_SIZE = new Dimension(200, 300);

    public EastWindow (Dimension size, Controller controller) {
        setPreferredSize(size);
        setFocusable(true);
        myController = controller;
        initAndAddWindows();

        setVisible(true);
    }

    private void initAndAddWindows () {
        myStatsWindow = new InformationScreen("Stats", STATS_WINDOW_SIZE);
        myInformationWindow = new GameElementInformationScreen("Info", INFO_WINDOW_SIZE, myController);
        // tests info screen
        //myInformationWindow.displayInformation("Stuff about towers\nMore stuff about towers");
        add(myStatsWindow, BorderLayout.NORTH);
        add(myInformationWindow, BorderLayout.SOUTH);
    }

    public GameElementInformationScreen getTowerScreen () {
        return myInformationWindow;
    }

    public InformationScreen getPlayerScreen () {
        return myStatsWindow;
    }
}
