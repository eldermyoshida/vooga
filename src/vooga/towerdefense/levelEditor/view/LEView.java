package vooga.towerdefense.levelEditor.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import vooga.towerdefense.levelEditor.controller.LEController;


/**
 * This is the view of the Level Editor for the Tower Defense VOOGA.
 * It allows the user to use a graphical interface to create
 * the main aspects of a Tower Defense game.
 * 
 * @author Yoshida
 * 
 */
public class LEView extends JFrame {
    
    private final static Dimension FRAME_SIZE = new Dimension(1024, 768);
    private final static Dimension WORKSPACE_SIZE =
            new Dimension((int) FRAME_SIZE.getWidth() * 4 / 5, 768);
    /**
     * Value for the borders of the JPanels.
     */
    private static final int BORDER_OFFSET = 5;
    
    private LEController myController;
    
    public LEView (LEController controller, String title) {
        myController = controller;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setPreferredSize(FRAME_SIZE);
        makeWorkspace();
        pack();
    }
    
    private void makeWorkspace () {
        JPanel workspace = new JPanel();
        workspace.setPreferredSize(WORKSPACE_SIZE);
        JMenuBar menuBar = new LEMenuBar();
        JToolBar toolBar = new JToolBar();
        this.add(menuBar);
        this.add(workspace, BorderLayout.CENTER);
    }
    
    /**
     * Creates a default border for most of the panels.
     * 
     * @return border for panels
     */
    private Border makeBorder (String panelName) {
        
        Border border;
        String title = ("".equals(panelName)) ? "" : myController.getWord(panelName);
        TitledBorder titleBorder = BorderFactory.createTitledBorder(title);
        Border emptyBorder = BorderFactory.createEmptyBorder(BORDER_OFFSET, BORDER_OFFSET,
                                                             BORDER_OFFSET, BORDER_OFFSET);
        border = BorderFactory.createCompoundBorder(titleBorder, emptyBorder);
        return border;
    }
}
