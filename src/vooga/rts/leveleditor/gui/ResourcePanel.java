package vooga.rts.leveleditor.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import vooga.rts.leveleditor.components.Resource;
import vooga.rts.leveleditor.components.Tile;

/**
 * This Panel holds all the map resources designer can use
 * to create the map
 * 
 * @author Ziqiang Huang
 *
 */

public class ResourcePanel extends JPanel {
    
    private static final String RELATIVE_PATH = "vooga.rts.leveleditor.resource.";
    
    private Canvas myCanvas;
    private JPanel myPanel;
    
    private ResourceBundle myResource;

    /**
     * Constructor for this class
     * @param canvas: the canvas which holds this panel;
     */
    public ResourcePanel(Canvas canvas) {
        myCanvas = canvas;
        myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(0,4));

        add(myPanel, BorderLayout.NORTH);
        myResource = ResourceBundle.getBundle(RELATIVE_PATH+"ResourceIndex");
        addResouceButton();
    }

    /**
     * Initialize the ResourceButton on this panel
     */
    public void addResouceButton() {
        
       
        for(String str : myResource.keySet()) {
            myPanel.add(new ResourceButton(new Resource(Integer.parseInt(str)),this));
        }

    }


    public Canvas getCanvas() {
        return myCanvas;
    }

    /**
     * Set the current resource selected by user
     * @param r
     */
    public void setCurrentSelectResource(Resource r) {
        myCanvas.setCurrentSelectResource(r);
    }



}
