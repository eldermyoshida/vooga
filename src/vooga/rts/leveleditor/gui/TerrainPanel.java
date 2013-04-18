package vooga.rts.leveleditor.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ResourceBundle;
import javax.swing.JPanel;
import vooga.rts.leveleditor.components.Resource;
import vooga.rts.leveleditor.components.Terrain;

public class TerrainPanel extends JPanel {
    
    private static final String RELATIVE_PATH = "vooga.rts.leveleditor.resource.";
    
    private Canvas myCanvas;
    private JPanel myPanel;
    
    private ResourceBundle myResource;


    public TerrainPanel(Canvas canvas) {
        myCanvas = canvas;
        myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(0,4));
        add(myPanel, BorderLayout.NORTH);
        myResource = ResourceBundle.getBundle(RELATIVE_PATH+"TerrainIndex");
        addTerrainButton();   
        
    }

    public void addTerrainButton() {
        
        for(String str : myResource.keySet()) {
            myPanel.add(new TerrainButton(new Terrain(Integer.parseInt(str)),this));
        } 
    }

    public Canvas getCanvas() {
        return myCanvas;
    }

    public void setCurrentSelectTerrain(Terrain t) {
        myCanvas.setCurrentSelectTerrain(t);
        
    }

}
