package vooga.rts.leveleditor.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import vooga.rts.leveleditor.components.Resource;


public class ResourceButton extends JToggleButton implements ActionListener {

    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    
    private Resource myResource;
    private ResourcePanel myOwner;
    private int myIndex;
    private BufferedImage myIcon;
    private int myXPosition;
    private int myYPosition;
    private Dimension mySize;
    //private ResourceBundle myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE+"map");
    
    public ResourceButton (Resource r, ResourcePanel owner) {
        myResource = r;
        myIcon = r.getImage();
        myOwner = owner;
       
        myIcon.getGraphics().drawImage(myIcon, 0, 0, 32, 32, null);
        setToolTipText(r.getName());
        setIcon(new ImageIcon(myIcon));
        setMargin(new Insets(2,2,2,2));
    }
    
//    public ResourceButton(int index, int x, int y){
//        if(myResources.containsKey(index+"")) {
//            String iconName = myResources.getString(index+"");
//            try {
//                myIcon = ImageIO.read(new File(System.getProperty("user.dir")+ "./src/resources/images/" + iconName ));
//            }
//            catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            myXPosition = x;
//            myYPosition = y;
//        }
//    }
    
    public void paint(Graphics pen, int x, int y) {
        pen.drawImage(myIcon, x, y, null);
    }
 
    public boolean judgeInArea(int x , int y) {
        if( x > myXPosition && x < myXPosition + mySize.width && y > myYPosition && x < myYPosition + mySize.height) {
           return true; 
        }
        return false;
    }

    public int getIndex() {
        return myIndex;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        myOwner.setCurrentSelectResource(myResource);
        
    }


}
