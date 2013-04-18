package vooga.towerdefense.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import vooga.towerdefense.controller.Controller;
import vooga.towerdefense.util.Pixmap;


/**
 * This class enables the player to click on items
 *              on the ShopScreen section, buy these
 *              items, and then place them on the map screen.
 * 
 * @author Leonard K. Ng'eno
 * 
 */
public class ShopScreen extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int XCOORD = 0;
    private static final int YCOORD = 0;
    private Color myBackgroundColor = Color.WHITE;
    private MouseAdapter myMouseListener;
    private Controller myController;
    private Map<String, Pixmap> myShopItems;

    /**
     * constructor.
     * @param size
     * @param controller
     */
    public ShopScreen (Dimension size, Controller controller) {
        setPreferredSize(size);
        setFocusable(true);
        myController = controller;
        makeMouseListener();
        addMouseListener(myMouseListener);
        setVisible(true);
        myShopItems = new HashMap<String, Pixmap>();
        initShopItems();
    }

    /**
     * initializes the icons that will display
     *          in the ShopScreen.
     */
    private void initShopItems () {
        myShopItems = myController.getShopItemIcons();
    }

    /**
     * paints the ShopScreen.
     * @param pen
     */
    @Override
    public void paintComponent (Graphics pen) {
        super.paintComponent(pen);
        pen.setColor(myBackgroundColor);
        pen.fillRect(XCOORD, YCOORD, getSize().width, getSize().height);
        displayShopItems((Graphics2D) pen);
    }

    /**
     * helper method to display the shop items
     *          in the shop. 
     * @param pen
     */
    private void displayShopItems (Graphics2D pen) {
        int totalX = 30;
        int totalY = 30;
        for (Pixmap item : myShopItems.values()) {
            // TODO Deal with the case where there are a lot of items on the screen
            if(item.getCenter().getX() == 0.0) {
                item.paint(pen, new Point(totalX, totalY), new Dimension(50, 50));
            }
            else {
                item.paint(pen, item.getCenter(), new Dimension(50, 50));
            }
        }
    }

    /**
     * helper method to make the mouse listener.
     */
    private void makeMouseListener() {
        myMouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                handleClick(e.getPoint());
            }
        };
    }

    /**
     * helper method to determine if the mouse click was
     *          on an item.
     * @param point
     */
    private void handleClick(Point point) {
        for (Pixmap item : myShopItems.values()) {
            double x = item.getCenter().getX() - (double)(item.getWidth()/2); 
            double y = item.getCenter().getY() - (double)(item.getHeight()/2); 
            Rectangle rect =
                    new Rectangle((int) x, (int) y, item.getWidth(), item.getHeight());
            if (rect.contains(point)) {
                for (Map.Entry<String, Pixmap> entry : myShopItems.entrySet()) {
                    if (entry.getValue().equals(item)) {
                        myController.handleShopClickOnItem(entry.getKey());
                    }
                }
            }
        }
    }

}
