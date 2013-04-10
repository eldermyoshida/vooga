package vooga.rts.leveleditor.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import vooga.rts.leveleditor.components.Resource;

public class ResourcePanel extends JPanel {
    
    public static final String IMAGE_PATH = "/vooga/rts/leveleditor/resource/tree1.jpg";
    
    private Canvas myCanvas;
    private JPanel myPanel;
    private BufferedImage myImage;
    
    public ResourcePanel(Canvas canvas) {
        myCanvas = canvas;
        myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(0,5));
        
        add(myPanel, BorderLayout.NORTH);
        addResouceButton();
    }

    private void addResouceButton() {
        setImageRelative(IMAGE_PATH);
        Resource r = new Resource(1,"Tree",myImage);
        for(int i=0; i<10; ++i) {
            ResourceButton b = new ResourceButton(r,this);
            myPanel.add(b);
        }

        
    }
    
    private void setImageRelative (String path) {
        try {
            myImage = ImageIO.read(this.getClass().getResource(path));
        }
        catch (Exception e) {
            
        }
    }
    
    public void setCurrentSelectResource(Resource r) {
        myCanvas.setCurrentSelectResource(r);
    }



}
