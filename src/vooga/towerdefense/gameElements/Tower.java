package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import vooga.towerdefense.action.AbstractAction;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;

/**
 * Baseline Tower class. Has no special functionality.
 * @author Matthew Roy
 *
 */
public class Tower extends GameElement {

    /**
     * @param image
     * @param center
     * @param size
     * @param actions
     */
    public Tower (Pixmap image, Location center, Dimension size, AttributeManager attributes, List<AbstractAction> actions) {
        super(image, center, size, attributes, actions);
    }
    
    /**
     * returns list of the tower's available upgrades.
     * @return a list of strings
     */
    public List<String> getUpgrades() {
        //TODO: implement get upgrade in tower
        ArrayList<String> testing = new ArrayList<String>();
        testing.add("Red Tower");
        testing.add("Blue Tower");
        testing.add("Green Tower");
        return testing;
    }
    
    /**
     * upgrades this tower to the given upgrade name type.
     * @param upgradeName
     */
    public void upgrade(String upgradeName) {
        //TODO: implement upgrade in tower
        System.out.println("Tower upgraded");
    }

}
