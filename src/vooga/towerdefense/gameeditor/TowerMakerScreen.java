package vooga.towerdefense.gameeditor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TowerMakerScreen extends JPanel {

    private static final String BUILD_BUTTON_TEXT = "Build this tower";
    private JButton myBuildButton;
    private JComboBox myTowerOptions;
    private JButton myMakeNewTowerButton;
    private MouseAdapter myMouseAdapter;
    private GameEditorController myController;
    
    public TowerMakerScreen(Dimension size, GameEditorController controller) {
        myController = controller;
        setPreferredSize(size);
        setVisible(false);
        makeMouseAdapter();
        getOptions();
        add(myTowerOptions);
        makeButtons();
        add(myBuildButton);
    }
    
    public void display() {
        setVisible(true);        
        repaint();
    }
    
    public void paintComponent(Graphics pen) {
        super.paintComponent(pen);
    }
    
    private void makeButtons() {
        myBuildButton = new JButton(BUILD_BUTTON_TEXT);
        myBuildButton.addMouseListener(myMouseAdapter);
    }
    
    private void makeMouseAdapter() {
        myMouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                if (e.getSource().equals(myBuildButton)) {
                    myController.addTowerToGame();
                }
            }
        };
    }
    
    private void getOptions() {
        //TODO: implement getting the options for default towers
        myTowerOptions.addItem("Arrow Tower");
        myTowerOptions.addItem("Freeze Tower");
    }
}
