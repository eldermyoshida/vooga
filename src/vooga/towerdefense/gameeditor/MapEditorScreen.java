package vooga.towerdefense.gameeditor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapEditorScreen extends JPanel {

    private static final String START_KEYWORD = "START";
    private JButton myMapChooserButton;
    private MouseAdapter myMouseAdapter;
    private GameEditorController myController;
    
    public MapEditorScreen(Dimension size, GameEditorController controller) {
        setPreferredSize(size);
        setVisible(false);
        makeMouseAdapter();
        makeButton();
        add(myMapChooserButton);
    }
    
    public void display() {
        setVisible(true);        
        repaint();
    }
    
    public void paintComponent(Graphics pen) {
        super.paintComponent(pen);
    }
    
    private void makeButton() {
        myMapChooserButton = new JButton(START_KEYWORD);
        myMapChooserButton.addMouseListener(myMouseAdapter);
    }
    
    private void makeMouseAdapter() {
        myMouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                if (e.getSource().equals(myMapChooserButton)) {

                }
            }
        };
    }
}
