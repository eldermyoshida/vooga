package vooga.rts.leveleditor.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JPanel;
import vooga.rts.leveleditor.components.Terrain;
import vooga.rts.leveleditor.components.Tile;

public class TilePanel extends JPanel {
    
    private Canvas myCanvas;
    private JPanel myPanel;

    public TilePanel(Canvas canvas) {
        myCanvas = canvas;
        myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(0,4));
        add(myPanel, BorderLayout.NORTH);
        addTileButton();   
        
    }

    public void addTileButton() {
        myPanel.add(new TileButton(new Tile(),this));
        myPanel.add(new TileButton(new Tile(),this));
        myPanel.add(new TileButton(new Tile(),this));
        
    }

    public Canvas getCanvas() {
       return myCanvas;
    }

    public void setCurrentSelectTile(Tile t) {
        myCanvas.setCurrentSelectTile(t);        
    }

}
