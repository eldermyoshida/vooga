package vooga.rts.leveleditor.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import vooga.rts.leveleditor.components.Resource;

/**
 * This Panel holds all the map resources designer can use
 * to create the map
 * 
 * @author Ziqiang Huang
 *
 */

public class ResourcePanel extends JPanel {
    
    private Canvas myCanvas;
    private JPanel myPanel;

    /**
     * Constructor for this class
     * @param canvas: the canvas which holds this panel;
     */
    public ResourcePanel(Canvas canvas) {
        myCanvas = canvas;
        myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(0,4));

        add(myPanel, BorderLayout.NORTH);
        addResouceButton();
    }

    /**
     * Initialize the ResourceButton on this panel
     */
    public void addResouceButton() {
        
        myPanel.add(new ResourceButton(new Resource(1),this));
        myPanel.add(new ResourceButton(new Resource(2),this));
        myPanel.add(new ResourceButton(new Resource(3),this));

    }

    /**
     * Set the image of resource according to the path
     * @param path
     */
    public void setImageRelative (String path) {
        try {
            myImage = ImageIO.read(this.getClass().getResource(path));
        }
        catch (Exception e) {

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
