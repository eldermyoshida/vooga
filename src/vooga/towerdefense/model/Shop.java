package vooga.towerdefense.model;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vooga.towerdefense.gameElements.Tower;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;

/**
 * This is the model class that holds the underlying data that updates the ShopScreen view.
 * It holds the different items that the player might want to buy. It also provides methods
 * for the manipulation of these items.
 * 
 * @author Leonard K. Ng'eno
 *
 */
public class Shop {

    private Map<String, GameElement> myShopItems;
    
    public Shop() {
       myShopItems = new HashMap<String, GameElement> (); 
       initShopItems();
    }
    
    public Collection<GameElement> getShopItems() {
        return myShopItems.values();        
    }
 
    // TODO this is just a place holder! Needs to be fixed later! (read in from file)
    private void initShopItems () {
        Pixmap myImage = new Pixmap("tower.gif");
        System.out.println("created pixmap");
        Tower tower1 =
                new Tower(myImage, new Location(30, 30), new Dimension(50, 50), null, null);
        Tower tower2 =
                new Tower(myImage, new Location(30, 30), new Dimension(50, 50), null, null);
        addShopItem("tower1", tower1);
        addShopItem("tower2", tower2);
    }    
    
    public String getShopItemName (GameElement e) {
        for (Map.Entry<String, GameElement> entry : myShopItems.entrySet()) {
            if (entry.getValue().equals(e)) {
                return entry.getKey();
            }
        }
        return null;
    }
    
    public void addShopItem (String name, GameElement e) {
        myShopItems.put(name, e);
    }
    
    public GameElement getShopItem (String name) {
        return myShopItems.get(name);
    }
    
    public Map<String, GameElement> getAllShopItemIcons () {
       // return myShopItems;
        Map<String, GameElement> items = new HashMap<String, GameElement> (myShopItems); 
        //items.putAll(myShopItems);
//        for (Map.Entry<String, GameElement> entry : myShopItems.entrySet()) {
//            items.put(entry.getKey(), entry.getValue());
//        }
        return items;
    }
}