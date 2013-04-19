package vooga.towerdefense.gameeditor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartUpScreen extends JPanel {

    private static final String WELCOME_KEYWORD = "WELCOME TO GAME EDITOR";
    private static final String START_KEYWORD = "START";
    private JButton myStartButton;
    private MouseAdapter myMouseAdapter;
    
    public StartUpScreen(Dimension size) {
        setPreferredSize(size);
        setVisible(false);
        makeMouseAdapter();
        add(makeLabel());
        makeButton();
        add(myStartButton);
    }
    
    public void display() {
        setVisible(true);        
        repaint();
    }
    
    public void paintComponent(Graphics pen) {
        super.paintComponent(pen);
    }
    
    private JLabel makeLabel() {
        return new JLabel(WELCOME_KEYWORD);
    }
    
    private void makeButton() {
        myStartButton = new JButton(START_KEYWORD);
        myStartButton.addMouseListener(myMouseAdapter);
    }
    
    private void makeMouseAdapter() {
        myMouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                if (e.getSource().equals(myStartButton)) {
                    
                }
            }
        };
    }
}
