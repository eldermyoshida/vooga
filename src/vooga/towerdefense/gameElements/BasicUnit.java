package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.util.List;
import vooga.towerdefense.action.AbstractAction;
import vooga.towerdefense.action.ComboAttackAction;
import vooga.towerdefense.attributes.Targetable;
import vooga.towerdefense.attributes.TargetableAttributes;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;
import vooga.towerdefense.util.Vector;


/**
 * Basic unit to help test Basic tower.
 * 
 * @author XuRui
 * 
 */
public class BasicUnit extends Unit implements Targetable {

    public BasicUnit (Location destination, Pixmap image, Location center,
                      Dimension size, Vector velocity, TargetableAttributes attributes,
                      List<AbstractAction> actions) {
        super(destination, image, center, size, velocity, attributes, actions);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void takeDamage (double attack) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isAlive () {
        // TODO Auto-generated method stub
        return false;
    }

}
