
package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import vooga.towerdefense.action.Action;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;
import vooga.towerdefense.util.Sprite;


/**
 * Blank tower that holds its attributes and actions that define it
 * 
 * @author Matthew Roy
 * @author Xu Rui
 * 
 */
public class GameElement extends Sprite {

    protected AttributeManager myAttributeManager;
    protected List<Action> myActions;

    public GameElement (Pixmap image,
                        Location center,
                        Dimension size,
                        AttributeManager attributes,
                        List<Action> actions) {
        super(image, center, size);
        myAttributeManager = attributes;
        myActions = actions;
    }

    public GameElement (Pixmap image, Location center, Dimension size, List<Action> actions) {
        super(image, center, size);
        myActions = actions;
        myAttributeManager = new AttributeManager();
    }
    
    public GameElement (Pixmap image, Location center, Dimension size, AttributeManager am) {
        super(image, center, size);
        myActions = new ArrayList<Action>();
        myAttributeManager = am;
    }

    public GameElement (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
        myActions = new ArrayList<Action>();
        myAttributeManager = new AttributeManager();
    }

    public void update (double elapsedTime) {
        /*
         * for (Action a : myActions) {
         * a.update(elapsedTime, event);
         * }
         */
    }
    
    public void addActions(List<Action> actions) {
        myActions.addAll(actions);
    }

    public AttributeManager getAttributeManager () {
        return myAttributeManager;
    }

    public List<Action> getActions () {
        return myActions;
    }

}
