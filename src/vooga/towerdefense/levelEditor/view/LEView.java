package vooga.towerdefense.levelEditor.view;

import javax.swing.JFrame;
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
    /**
     * Default serial.
     */
    private static final long serialVersionUID = 1L;
    private LEController myController;
    
    public LEView (LEController controller) {
        myController = controller;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    
}
