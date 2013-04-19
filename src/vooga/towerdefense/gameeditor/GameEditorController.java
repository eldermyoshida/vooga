package vooga.towerdefense.gameeditor;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class GameEditorController extends JFrame {

    private Dimension mySize;
    
    public GameEditorController(Dimension size) {
        mySize = size;
        setSize(mySize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        initializeGUI();
    }
    
    public void initializeGUI() {
        StartUpScreen screen = new StartUpScreen(mySize);
        add(screen);
        screen.display();
    }
    
    public void addTowerToGame() {
        //TODO: implement
        System.out.println("add tower to game");
    }
}
