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
 
    // TODO this is just a place holder! Needs to be fixed later!
    private void initShopItems () {
        Pixmap myImage = new Pixmap("tower.gif");
        Tower tower =
                new Tower(myImage, new Location(20, 20), new Dimension(50, 50), null, null);
        addShopItem("tower", tower); 
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
    
}
