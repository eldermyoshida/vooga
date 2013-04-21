package arcade.view;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import arcade.games.GameInfo;
import arcade.model.Model;
import arcade.util.JPicture;
import arcade.util.Pixmap;


/**
 * 
 * @author David Liu
 * 
 */
public class SnapShot extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1859238824934859448L;
    private GameInfo myGameInfo;
    private ResourceBundle myResources;
    private JLabel myTitle;
    private JComponent myThumbnail;
    private JLabel myRating;

    private String gameName;
    private Model myModel;

    public SnapShot (GameInfo info, ResourceBundle resources, Model model) {
        myModel = model;
        myGameInfo = info;
        myResources = resources;

        myTitle = new JLabel("<html><b><font size = 4>" + myGameInfo.getName() +
                             "</font></html></b>");
        Pixmap p = myGameInfo.getThumbnail();
        myThumbnail = new JPicture(p, new Dimension(160, 160));
        myRating = new JLabel(myGameInfo.getRating() + "");

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(myThumbnail);
        add(myTitle);
        add(myRating);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked (MouseEvent arg0) {
                if (arg0.getClickCount() == 2) {
                    System.out.println("Clicked!!");
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
}
