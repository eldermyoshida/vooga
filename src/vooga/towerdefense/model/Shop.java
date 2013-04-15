package vooga.towerdefense.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vooga.towerdefense.gameElements.GameElement;

/**
 * 
 * @author Leonard K. Ng'eno
 *
 */
public class Shop {

    private Map<String, GameElement> myShopItems;
    
    public Shop() {
       myShopItems = new HashMap<String, GameElement> (); 
    }
    
    public List<GameElement> getShopItems() {
        return (List<GameElement>) myShopItems.values();
    }
    
    public void addShopItem (String name, GameElement e) {
        myShopItems.put(name, e);
    }
    
    public GameElement getShopItem (String name) {
        return myShopItems.get(name);
    }
    
}
