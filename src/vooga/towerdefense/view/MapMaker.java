package vooga.towerdefense.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MapMaker extends JPanel {

    private static final long serialVersionUID = 1L;
    private Dimension mySize;
    
    public MapMaker (Dimension size){
        setPreferredSize(size);
        mySize = size;
    }
    
    @Override
    public void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        setBackground(Color.CYAN);
        
        paintGrids(pen);
    }

    private void paintGrids (Graphics pen) {
        for (int i = 0; i < mySize.width; i += 25) {
            pen.drawLine(i, 0, i, mySize.height);
        }
        for (int j = 0; j < mySize.height; j += 25) {
            pen.drawLine(0, j, mySize.width, j);
        }        
    }
}
