package view;

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
    private GameStatisticsWindow myStatsWindow;
    private InfoWindow myInformationWindow;
    private static final Dimension STATS_WINDOW_SIZE = new Dimension(200, 300);
    private static final Dimension INFO_WINDOW_SIZE = new Dimension(200, 300);
    
    public EastWindow (Dimension size) {
        setPreferredSize(size);
        setFocusable(true);
        initAndAddWindows();
        
        setVisible(true);
    }
    
    private void initAndAddWindows () {
        myStatsWindow = new GameStatisticsWindow(STATS_WINDOW_SIZE);
        myInformationWindow = new InfoWindow(INFO_WINDOW_SIZE);
        add(myStatsWindow, BorderLayout.NORTH);
        add(myInformationWindow, BorderLayout.SOUTH);
    }
}
