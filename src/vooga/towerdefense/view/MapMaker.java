package vooga.towerdefense.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import vooga.towerdefense.gameeditor.GameEditorController;
import vooga.towerdefense.gameeditor.GameEditorScreen;
import vooga.towerdefense.gameeditor.MapEditorScreen;

/**
 * 
 * @author Leonard K. Ng'eno
 *
 */
public class MapMaker extends JPanel {

    private static final long serialVersionUID = 1L;
    private Dimension mySize;
    private int myTileSize;
    private MouseAdapter myMouseListener;
    List<Rectangle> myGrids;
    private boolean myPaintingMode; 
    private MapEditorScreen myParent;

    public MapMaker (Dimension size, MapEditorScreen parent){
        myParent = parent;
        setSize(size);
        setPreferredSize(size);
        mySize = size;
        myTileSize = 0;
        myGrids = new ArrayList<Rectangle>();
        makeListener();
        this.addMouseListener(myMouseListener);
        myPaintingMode = false;
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
        myGrids.removeAll(myGrids);
        if (myTileSize != 0 ) {
            for (int i = 0; i < mySize.width; i += myTileSize) {
                for (int j = 0; j < mySize.height; j += myTileSize) {
                    pen.drawLine(i, 0, i, mySize.height);
                    pen.drawLine(0, j, mySize.width, j);
                    Rectangle rect = new Rectangle(i,j,myTileSize,myTileSize);
                    myGrids.add(rect);
                }   
            }
        }
    }
    
    private void makeListener() {
        myMouseListener = new MouseAdapter () {
            @Override
            public void mouseClicked (MouseEvent e) {
                System.out.println("Map clicked");
                paintTileClicked(e.getPoint());
            }
        };
    }
    
    private void paintTileClicked (Point point){
        for (Rectangle tile : myGrids) {
            if (tile.contains(point) && myPaintingMode == true) {
                getGraphics().fillRect(tile.x, tile.y, tile.width, tile.height);
                setPaintingMode(false);
                myParent.setTilePainterColor(Color.BLUE);
            }
        }
    }
    
    public void setPaintingMode (boolean mode) {
        myPaintingMode = mode;
    }
    
}
