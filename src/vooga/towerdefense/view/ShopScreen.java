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
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;


/**
 * This class enables the player to click on items on the ShopScreen section and buy these
 * items and then drag them to the map screen.
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

    private void initShopItems () {
        myShopItems = myController.getShopItemIcons();
    }

    @Override
    public void paintComponent (Graphics pen) {
        super.paintComponent(pen);
        pen.setColor(myBackgroundColor);
        pen.fillRect(XCOORD, YCOORD, getSize().width, getSize().height);

        displayShopItems((Graphics2D) pen);
    }

    private void displayShopItems (Graphics2D pen) {
        int totalX = 30;
        for (Pixmap item : myShopItems.values()) {
            // TODO Deal with the case where there are a lot of items on the screen
            item.paint(pen, new Point(totalX, 30), new Dimension(50, 50));
            totalX += 50;
        }
    }

    private void makeMouseListener () {
        myMouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                checkIfItemClickedOn(e.getPoint());
            }
        };
    }

    private void checkIfItemClickedOn (Point point) {
        for (Pixmap item : myShopItems.values()) {
            Location center = new Location(item.getCenter().getX(), item.getCenter().getY());
            double x = item.getWidth() / 2 - center.x;
            double y = item.getHeight() / 2 - center.y;
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
