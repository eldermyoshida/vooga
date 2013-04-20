package vooga.towerdefense.shop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;


public class ShopItem extends Rectangle {
    private static final long serialVersionUID = 1L;
    public static final Dimension SHOP_ITEM_DIMENSIONS = new Dimension(50, 50);
    private Location myLocation;

    public ShopItem (Location location) {
        myLocation = location;
    }

    public void paint (Graphics2D pen) {
        pen.setColor(new Color(0, 100, 0));
        Pixmap image = new Pixmap("tower.gif");
        pen.drawImage(image.getImage(), (int) myLocation.getX(), (int) myLocation.getY(),
                      (int) SHOP_ITEM_DIMENSIONS.getWidth(), (int) SHOP_ITEM_DIMENSIONS.getHeight(), null);

//        pen.fillRect((int) myLocation.getX(), (int) myLocation.getY(),
//                     (int) SHOP_ITEM_DIMENSIONS.getWidth(), (int) SHOP_ITEM_DIMENSIONS.getHeight());
    }
}
