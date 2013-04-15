package vooga.towerdefense.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class SplashScreen extends JPanel {

    private static final String RESOURCE = "/vooga/towerdefense/images/";
    private static final long serialVersionUID = 1L;
    private static final int XCOORD = 0;
    private static final int YCOORD = 0;
    private Color myBackgroundColor = Color.WHITE;
    private TDView myView;
    private java.awt.Image myBackgroundImage;

    public SplashScreen (Dimension size, TDView view) {
        setPreferredSize(size);
        myView = view;
        myBackgroundImage =
                new ImageIcon(getClass().getResource(RESOURCE + "splashscreen.gif")).getImage();
    }

    @Override
    public void paintComponent (Graphics pen) {
        super.paintComponent(pen);
        if (myBackgroundImage != null) {
            pen.drawImage(myBackgroundImage, 0, 0, this.getSize().width, this.getSize().height,
                          null);
        }
        // pen.setColor(myBackgroundColor);
        // pen.fillRect(XCOORD, YCOORD, getSize().width, getSize().height);

    }

}
