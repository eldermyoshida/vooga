package vooga.towerdefense.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import vooga.towerdefense.gameElements.Tower;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;


/**
 * 
 * @author Leonard K. Ng'eno
 * 
 */
public class ShopScreen extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int XCOORD = 0;
    private static final int YCOORD = 0;
    private Color myBackgroundColor = Color.WHITE;
    private List<GameElement> myShopItems;

    // TODO fix constructor so that it takes in several shop items
    public ShopScreen (Dimension size) {
        setPreferredSize(size);
        setFocusable(true);
        setVisible(true);
        myShopItems = new ArrayList<GameElement> ();
        initShopItems();
    }

    // TODO this is just a place holder! Needs to be fixed later!
    private void initShopItems () {
        Pixmap myImage = new Pixmap("tower.gif");
        Tower tower = new Tower(myImage, new Location(20, 20), new Dimension(50, 50), null, null);
        myShopItems.add(tower);
    }

    @Override
    public void paintComponent (Graphics pen) {
        super.paintComponent(pen);
        pen.setColor(myBackgroundColor);
        pen.fillRect(XCOORD, YCOORD, getSize().width, getSize().height);

        displayShopItems((Graphics2D) pen);
    }
    
    private void displayShopItems (Graphics2D pen) {
        for (GameElement item : myShopItems) {
            item.getPixmap().paint(pen, item.getCenter(), new Dimension((int)item.getWidth(), (int)item.getHeight()));
        }
    }
    
}
