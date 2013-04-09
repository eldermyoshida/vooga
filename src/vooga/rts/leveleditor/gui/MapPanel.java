package vooga.rts.leveleditor.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;
import vooga.rts.leveleditor.components.EditableMap;

public class MapPanel extends JComponent implements Observer {
    
    public static final Dimension DEFAULT_MAP_SIZE  = new Dimension (600,600);
    
    private EditableMap myMap;
    private int myWidth;
    private int myHeight;
    private int myTileWidth;
    private int myTileHeight;
    
    
    public MapPanel() {
        myMap = new EditableMap();
        myWidth = 0;
        myHeight = 0;
        myTileWidth = 32;
        myTileHeight = 32;
        setPanelSize();
        
    }
    
    private void setPanelSize() {
        setPreferredSize(new Dimension(myTileWidth*myWidth, myTileHeight*myHeight));       
    }

    @Override
    public void paintComponent (Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,myWidth*myTileWidth, myHeight*myTileHeight);

        g.setColor(Color.gray);
        for(int i=0; i<myWidth; i++) {
            g.drawLine(i*myTileWidth, 0, i*myTileWidth, myHeight*myTileHeight);
        }

        for(int j=0; j<myHeight; j++) {
            g.drawLine(0,j*myTileHeight, myWidth*myTileWidth, j*myTileHeight);
        }

        ((Graphics2D)g).setStroke(new BasicStroke(2));
        g.setColor(Color.black);
        g.drawLine(0, 0, myWidth * myTileWidth, 0);
        g.drawLine(0, 0, 0, myHeight * myTileHeight);
        g.drawLine(myWidth * myTileWidth, 0, myWidth * myTileWidth, myHeight * myTileHeight);
        g.drawLine(0, myHeight * myTileHeight, myWidth * myTileWidth, myHeight * myTileHeight);

        
    }
    
    public void setWidth(int w) {
        myWidth = w;
        setPanelSize();
        repaint();
    }
    
    public void setHeight(int h) {
        myHeight = h;
        setPanelSize();
        repaint();
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        repaint();
        
    }
    

    

}
