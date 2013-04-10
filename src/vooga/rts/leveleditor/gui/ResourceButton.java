package vooga.rts.leveleditor.gui;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import vooga.rts.leveleditor.components.Resource;

/**
 * This class represents the resource button on Resource Panel
 * User can click and add the resource onto the map
 *
 * @author Ziqiang Huang
 *
 */

public class ResourceButton extends JToggleButton implements ActionListener {

    private Resource myResource;
    private ResourcePanel myOwner;
    private BufferedImage myIcon;
    
    /**
     * Constructor for this class
     * 
     * @param r : the Resource which the button represents
     * @param owner : the ResourcePanel which holds this button;
     */
    public ResourceButton (Resource r, ResourcePanel owner) {
        myResource = r;
        myIcon = r.getImage();
        myOwner = owner;
       
        myIcon.getGraphics().drawImage(myIcon, 0, 0, 32, 32, null);
        setToolTipText(r.getName());
        setIcon(new ImageIcon(myIcon));
        setMargin(new Insets(2,2,2,2));
        this.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        myOwner.getCanvas().remove(false);
        myOwner.setCurrentSelectResource(myResource);
    }


}
