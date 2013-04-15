package vooga.towerdefense.view;

import javax.swing.JPanel;
import vooga.towerdefense.util.Pixmap;

public class SelectScreen extends JPanel {
    private static final String CHECKED_IMAGE = "checked.gif";
    private String myPrevName = "";

    public SelectScreen () {
        
    }
    
    public void selectedImage (Pixmap myImage) {
        myPrevName = myImage.getFileName();
        myImage.setImage(CHECKED_IMAGE);
        repaint();
    }
    
}
