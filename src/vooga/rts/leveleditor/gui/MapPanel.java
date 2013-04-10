package vooga.rts.leveleditor.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MapPanel extends JPanel {
    
    public static final Dimension DEFAULT_MAP_SIZE  = new Dimension (600,600);
    public static final String IMAGE_PATH = "/vooga/rts/leveleditor/resource/BlankGrid.png";
    
    private BufferedImage myBackgroundImage;
    
    public MapPanel() {
        //setSize(DEFAULT_MAP_SIZE);
        setImageRelative(IMAGE_PATH);
    }
    
    @Override
    public void paintComponent (Graphics g) {
        
        g.drawImage(myBackgroundImage, 0, 0, getWidth(), getHeight(), this);
        
    }
    
    private void setImageRelative (String path) {
        try {
            myBackgroundImage = ImageIO.read(this.getClass().getResource(path));
        }
        catch (Exception e) {
            
        }
    }

}
