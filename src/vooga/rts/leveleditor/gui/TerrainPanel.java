package vooga.rts.leveleditor.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JPanel;
import vooga.rts.leveleditor.components.Resource;
import vooga.rts.leveleditor.components.Terrain;

public class TerrainPanel extends JPanel {
    
    private Canvas myCanvas;
    private JPanel myPanel;

    public TerrainPanel(Canvas canvas) {
        myCanvas = canvas;
        myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(0,4));
        add(myPanel, BorderLayout.NORTH);
        addTerrainButton();
        
    }

    public void addTerrainButton() {
        
        myPanel.add(new TerrainButton(new Terrain(1),this));
        myPanel.add(new TerrainButton(new Terrain(2),this));
        myPanel.add(new TerrainButton(new Terrain(3),this));
        
    }

    public Canvas getCanvas() {
        return myCanvas;
    }

    public void setCurrentSelectTerrain(Terrain t) {
        myCanvas.setCurrentSelectTerrain(t);
        
    }

}
