package vooga.towerdefense.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * 
 * @author Leonard K. Ng'eno
 *
 */
public class MapMaker extends JPanel {

    private static final long serialVersionUID = 1L;
    private Dimension mySize;
    private int myTileSize;
    
    public MapMaker (Dimension size, int tileSize){
        myTileSize = tileSize;
        setSize(size);
        setPreferredSize(size);
        mySize = size;
    }
    
    @Override
    public void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        setBackground(Color.CYAN);
        
        paintGrids(pen);
    }

    public void setTileSizes(int size) {
        myTileSize = size;
        repaint();
    }
    
    private void paintGrids (Graphics pen) {
        for (int i = 0; i < mySize.width; i += myTileSize) {
            pen.drawLine(i, 0, i, mySize.height);
        }
        for (int j = 0; j < mySize.height; j += myTileSize) {
            pen.drawLine(0, j, mySize.width, j);
        }        
    }
}
