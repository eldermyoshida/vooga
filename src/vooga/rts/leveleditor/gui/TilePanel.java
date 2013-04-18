package vooga.rts.leveleditor.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ResourceBundle;
import javax.swing.JPanel;
import vooga.rts.leveleditor.components.Terrain;
import vooga.rts.leveleditor.components.Tile;

public class TilePanel extends JPanel {
    
    private static final String RELATIVE_PATH = "vooga.rts.leveleditor.resource.";
    
    private Canvas myCanvas;
    private JPanel myPanel;
    private ResourceBundle myResource;

    public TilePanel(Canvas canvas) {
        myCanvas = canvas;
        myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(0,4));
        add(myPanel, BorderLayout.NORTH);
        myResource = ResourceBundle.getBundle(RELATIVE_PATH+"TileIndex");
        addTileButton();
    }

    public void addTileButton() {
        for(String str : myResource.keySet()) {
            myPanel.add(new TileButton(new Tile(Integer.parseInt(str)),this));
        }
    }

    public Canvas getCanvas() {
       return myCanvas;
    }

    public void setCurrentSelectTile(Tile t) {
        myCanvas.setCurrentSelectTile(t);        
    }

}
