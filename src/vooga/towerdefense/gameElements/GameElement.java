package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.util.List;
import vooga.towerdefense.action.AbstractAction;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;
import vooga.towerdefense.util.Sprite;


/**
 * Blank tower that holds its attributes and actions that define it
 * 
 * @author Matthew Roy
 * 
 */
public class GameElement extends Sprite {

    AttributeManager myAttributes;
    List<AbstractAction> myActions;

    public GameElement (Pixmap image,
                        Location center,
                        Dimension size,
                        AttributeManager attributes,
                        List<AbstractAction> actions) {
        super(image, center, size);
        myAttributes = attributes;
        myActions = actions;
    }

    public GameElement (Pixmap image, Location center, Dimension size, List<AbstractAction> actions) {
        super(image, center, size);
        myActions = actions;
    }

    public void update (double elapsedTime) {
        for (AbstractAction a : myActions) {
            a.execute(elapsedTime);
        }
    }

    public AttributeManager getAttributes () {
        return myAttributes;
    }
    
    public List<AbstractAction> getActions() {
        return myActions;
    }

}

