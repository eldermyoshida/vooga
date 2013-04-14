package vooga.towerdefense.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * 
 * @author Leonard K. Ng'eno
 *
 * This class enables having multiple JPanels on the east border of the screen
 * 
 */
public class EastWindow extends JPanel {

    private static final long serialVersionUID = 1L;
    private InfoScreen myStatsWindow;
    private InfoScreen myInformationWindow;
    private static final Dimension STATS_WINDOW_SIZE = new Dimension(200, 300);
    private static final Dimension INFO_WINDOW_SIZE = new Dimension(200, 300);
    
    public EastWindow (Dimension size) {
        setPreferredSize(size);
        setFocusable(true);
        initAndAddWindows();
        
        setVisible(true);
    }
    
    private void initAndAddWindows () {
        myStatsWindow = new InfoScreen("Stats", STATS_WINDOW_SIZE);
        myInformationWindow = new InfoScreen("Info", INFO_WINDOW_SIZE);
        //tests info screen
        myInformationWindow.displayInformation("Stuff about towers\nMore stuff about towers");
        add(myStatsWindow, BorderLayout.NORTH);
        add(myInformationWindow, BorderLayout.SOUTH);
    }
    
    public InfoScreen getTowerScreen() {
        return myInformationWindow;
    }
    
    public InfoScreen getPlayerScreen() {
        return myStatsWindow;
    }
}
