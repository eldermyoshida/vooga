package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.util.List;
import vooga.towerdefense.action.Action;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;


/**
 * Basic tower that is capable of shooting a unit.
 * 
 * @author XuRui
 * 
 */
public class AttackingTower extends GameElement{

    List<Action> myActions;
    AttributeManager myAttributes;

    public AttackingTower (Pixmap image, Location center, Dimension size,
                       AttributeManager attributes, List<Action> actions) {
        super(image, center, size, attributes, actions);
        // TODO Auto-generated constructor stub
    }



}
