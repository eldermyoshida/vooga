package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.util.List;
import vooga.towerdefense.action.AbstractAction;
import vooga.towerdefense.attributes.Attributes;
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

    Attributes myAttributes;
    List<AbstractAction> myActions;

    public GameElement (Pixmap image,
                        Location center,
                        Dimension size,
                        Attributes attributes,
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
            a.execute(this, elapsedTime);
        }
    }

    public Attributes getAttributes () {
        return myAttributes;
    }

}
