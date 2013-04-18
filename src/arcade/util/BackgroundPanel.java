package arcade.util;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * THIS CLASS IS HERE ONLY TEMPORARILY!!!!!!
 * 
 * 
 * Panel containing a background image
 * @author Henrique Moraes, Ellango Jothimurugesan
 *
 */
public class BackgroundPanel extends JPanel{
    /**
     * 
     */
    private static final long serialVersionUID = -4076243754704828822L;
    Image myImage;
    private static final int H_GAP = 0;
    private static final int V_GAP = 0;
    
   /**
    * Constructor
    * @param path image path for the image to set on the background
    */
    public BackgroundPanel(String path) {
        ImageIcon icon = new ImageIcon(this.getClass().getResource(path));
        setBackgroundImage(icon);
        setLayout(new BorderLayout(0, 0));
        defineMargin(H_GAP,V_GAP);
        repaint();            
    }
  
    /**
     * 
     * @param img Image to set on the background
     */
    public void setBackgroundImage(Image img){
        myImage = img;
        repaint();
    }
    
    /**
     * 
     * @param img Image Icon to set on the background
     */
    public void setBackgroundImage(ImageIcon img){
        setBackgroundImage(img.getImage());
    }
    
    /**
     * Defines the margin spacing between this panel and the component inside
     * it
     * @param hgap horizontal gap
     * @param vgap vertical gap
     */
    public void defineMargin(int hgap, int vgap) {
        setBorder(new EmptyBorder(vgap, hgap, vgap, hgap));
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D pen = (Graphics2D) g;
        pen.drawImage(myImage, 0, 0, getWidth(), getHeight(), this);
    }
    
}
