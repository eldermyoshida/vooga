package vooga.towerdefense.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import vooga.towerdefense.controller.Controller;
import vooga.towerdefense.gameElements.BasicTower;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.model.Shop;
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
    private MouseAdapter myMouseListener;
    private Controller myController;
    private Shop myShop;

    // TODO fix constructor so that it takes in several shop items
    public ShopScreen (Dimension size, Controller controller) {
        setPreferredSize(size);
        setFocusable(true);
        myController = controller;
        makeMouseListener();
        addMouseListener(myMouseListener);
        setVisible(true);
        myShop = new Shop();    // TODO fix how ShopScreen gets the Shop instance
        initShopItems();
    }

    // TODO this is just a place holder! Needs to be fixed later!
    private void initShopItems () {
        Pixmap myImage = new Pixmap("tower.gif");
        BasicTower tower =
                new BasicTower(myImage, new Location(20, 20), new Dimension(50, 50), null, null);
        myShop.addShopItem("tower", tower);
    }

    @Override
    public void paintComponent (Graphics pen) {
        super.paintComponent(pen);
        pen.setColor(myBackgroundColor);
        pen.fillRect(XCOORD, YCOORD, getSize().width, getSize().height);

        displayShopItems((Graphics2D) pen);
    }

    private void displayShopItems (Graphics2D pen) {
        for (GameElement item : myShop.getShopItems()) {
            item.getPixmap().paint(pen, item.getCenter(),
                                   new Dimension((int) item.getWidth(), (int) item.getHeight()));
        }
    }

    private void makeMouseListener () {
        myMouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                // myController.handleShopClick(e.getPoint());
                checkIfItemClickedOn(e.getPoint());
            }
        };
    }

    protected void checkIfItemClickedOn (Point point) {
        for (GameElement item : myShop.getShopItems()) {
            Location center = item.getCenter();
            double x = item.getWidth() / 2 - center.x;
            double y = item.getHeight() / 2 - center.y;
            Rectangle rect =
                    new Rectangle((int) x, (int) y, (int) item.getWidth(), (int) item.getHeight());
            if (rect.contains(point)) {
                System.out.println("clicked on");
                myController.handleShopClickOnItem(myShop.getShopItemName(item));
            }
        }
    }

}
