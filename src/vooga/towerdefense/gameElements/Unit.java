package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.util.List;
import vooga.towerdefense.action.Action;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;

/**
 * 
 * unit game element that is used to create waves etc
 * 
 * @author Matthew Roy
 * @author gouzhen-1
 *
 */
public class Unit extends GameElement {

    /**
     * @param image
     * @param center
     * @param size
     * @param attributes
     * @param actions
     */
    public Unit (Pixmap image,
                 Location center,
                 Dimension size,
                 AttributeManager attributes,
                 List<Action> actions) {
        super(image, center, size, attributes, actions);
    }

    /**
     * @param image
     * @param center
     * @param size
     * @param actions
     */
    public Unit (Pixmap image, Location center, Dimension size, List<Action> actions) {
        super(image, center, size, actions);
    }
    
    /**
     * @param image
     * @param center
     * @param size
     */
    public Unit (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
    }

}
