package arcade.view;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ResourceBundle;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import arcade.games.GameInfo;
import arcade.model.Model;


/**
 * 
 * @author David Liu
 * 
 */
@SuppressWarnings("serial")
public class SnapShot extends JPanel {

    private static final int THUMBNAIL_SIZE = 160;
    private GameInfo myGameInfo;
    private ResourceBundle myResources;
    private Model myModel;

    public SnapShot (GameInfo info, ResourceBundle resources, Model model) {
        myModel = model;
        myGameInfo = info;
        myResources = resources;
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        ImageIcon icon = myGameInfo.getThumbnail();
        ImageIcon scaledIcon = createScaledIcon(icon, THUMBNAIL_SIZE);
        JLabel thumbnail = new JLabel(scaledIcon);
        JLabel title = new JLabel("<html><b><font size = 4>" + myGameInfo.getName());
        JLabel rating = new JLabel(myGameInfo.getRating() + "");

        add(thumbnail);
        add(title);
        add(rating);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked (MouseEvent arg0) {
                if (arg0.getClickCount() == 2) {
                    new DetailView(myGameInfo, myResources, myModel);
                }
            }

            // these actions don't trigger any events.
            @Override
            public void mouseReleased (MouseEvent arg0) {}
            @Override
            public void mousePressed (MouseEvent arg0) {}
            @Override
            public void mouseExited (MouseEvent arg0) {}
            @Override
            public void mouseEntered (MouseEvent arg0) {}

        });
    }
    
    /**
     * TODO: REMOVE THE DUPLICATED CODE FROM HERE AND ButtonPanel
     * @param icon
     * @param size
     * @return
     */
    private ImageIcon createScaledIcon(ImageIcon icon, int size){
        Image image = icon.getImage();
        BufferedImage buffer = new BufferedImage(size,size,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = buffer.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image, 0, 0, size, size, null);
        g2.dispose();
        return new ImageIcon(buffer);
    }
}
