package vooga.towerdefense.gameeditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * This class enables map paths building on a tile by tile basis
 * 
 * @author Leonard K. Ng'eno
 *
 */
public class MapMaker extends JPanel {

    private static final long serialVersionUID = 1L;
    private Dimension mySize;
    private int myTileSize;
    private MouseAdapter myMouseListener;
    List<Grid> myGrids;
    private boolean myPaintingMode; 
    private boolean myEraseMode;
    private MapEditorScreen myParent;

    public MapMaker (Dimension size, MapEditorScreen parent){
        myParent = parent;
        setSize(size);
        setPreferredSize(size);
        mySize = size;
        myTileSize = 50;
        myGrids = new ArrayList<Grid>();
        makeListener();
        this.addMouseListener(myMouseListener);
        myPaintingMode = false;
        myEraseMode = false;
    }
    
    @Override
    public void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        setBackground(Color.CYAN);
        paintGridLines(pen);
        paintGrid(pen);
    }

    private void paintGrid (Graphics pen) {
        for (Grid g: myGrids) {
            g.paint((Graphics2D) pen);
        }  
    }

    public void setTileSizes(int size) {
        myTileSize = size;
        repaint();
    }
    
    private void paintGridLines (Graphics pen) {
        myGrids.removeAll(myGrids);
        if (myTileSize > 1 ) {
            for (int i = 0; i < mySize.width; i += myTileSize) {
                for (int j = 0; j < mySize.height; j += myTileSize) {
                    pen.drawLine(i, 0, i, mySize.height);
                    pen.drawLine(0, j, mySize.width, j);
                    Grid rect = new Grid(i,j,myTileSize,myTileSize);
                    myGrids.add(rect);   
                }   
            }
        }
        
    }
    
    private void makeListener() {
        myMouseListener = new MouseAdapter () {
            @Override
            public void mouseClicked (MouseEvent e) {
                setTileClicked(e.getPoint());
            }
        };
    }
    
    private void setTileClicked (Point point){
        for (Grid tile : myGrids) {
            if (tile.contains(point) && myPaintingMode == true) {
                tile.setPath(true);
                resetPaintingMode();
                paintGrid(this.getGraphics());
            }
            else if (tile.contains(point) && myEraseMode == true) {
                tile.setPath(false);
                resetEraseMode();
                paintGrid(this.getGraphics());
            }
        }
    }
    
    public void setPaintingMode (boolean mode) {
        myPaintingMode = mode;
    }
    
    public void setEraseMode (boolean mode) {
        myEraseMode = mode;
    }
    
    private void resetPaintingMode () {
        setPaintingMode(false);
        myParent.setPainterColor(myParent.getTilePainter(), Color.BLUE);
    }
    
    private void resetEraseMode () {
        setEraseMode(false);
        myParent.setPainterColor(myParent.getPathEraser(), Color.RED);
    }
    
}
