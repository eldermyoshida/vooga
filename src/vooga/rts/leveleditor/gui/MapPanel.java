package vooga.rts.leveleditor.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JViewport;
import vooga.rts.leveleditor.components.EditableMap;
import vooga.rts.leveleditor.components.EditableNode;

public class MapPanel extends JComponent implements MouseListener {
    
    public static final Dimension DEFAULT_MAP_SIZE  = new Dimension (600,600);
    
    private Canvas myCanvas;
    private EditableMap myMap;
    private int myWidth;
    private int myHeight;
    private int myTileWidth;
    private int myTileHeight;
    static JViewport myViewport;
    
    
    public MapPanel(Canvas canvas) {
        myCanvas = canvas;
        myMap = new EditableMap();
        myWidth = 0;
        myHeight = 0;
        myTileWidth = 50;
        myTileHeight = 50;
        setPanelSize();
        this.addMouseListener(this);
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

        //paint Node
        for(int i=0; i<myMap.getWidth(); ++i) {
            for(int j=0; j<myMap.getHeight(); ++j) {
                if(myMap.getMapNode(i, j).getOccupied()) {
                    try {
                        myMap.getMapNode(i, j).paint(g);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        
        
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
    
    public void initializeMap(int w, int h) {
        myMap = new EditableMap(w,h);
        
    }

    public void mapClicked(int x, int y) {
        x=x/myTileWidth;
        y=y/myTileWidth;
        if(x>=0 && x<myWidth && y>=0 && y<myHeight){
            EditableNode n = myMap.getMapNode(x, y);
            n.addFeature(myCanvas.getCurrentSelectResource().getID());
            n.setImage(myCanvas.getCurrentSelectResource().getImage());
            n.setOccupied(true);
            repaint();
        }
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        mapClicked(e.getX(), e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }


    



}
