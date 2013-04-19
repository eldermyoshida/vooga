package vooga.towerdefense.gameeditor;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class GameEditor extends JFrame {

    private Dimension mySize;
    private MouseAdapter myMouseAdapter;
    
    public GameEditor(Dimension size) {
        mySize = size;
        setSize(mySize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addMouseListener(myMouseAdapter);
        createGUI();
    }
    
    public void createGUI() {
        StartUpScreen screen = new StartUpScreen(mySize);
        add(screen);
        screen.display();
    }
}
