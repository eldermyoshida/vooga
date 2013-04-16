package vooga.towerdefense.gameElements;

import java.awt.Dimension;
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
public class GameElement extends Sprite{

    AttributeManager myAttributeManager;
    List<Action> myActions;
    

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
    }

    public void update (double elapsedTime) {
       /* for (Action a : myActions) {
            a.update(elapsedTime, event);
        }*/
    }

    public AttributeManager getAttributeManager () {
        return myAttributeManager;
    }
    
    public List<Action> getActions() {
        return myActions;
    }

}

