package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.util.List;
import vooga.towerdefense.action.AbstractAction;
import vooga.towerdefense.attributes.Attacker;
import vooga.towerdefense.attributes.Attributes;
import vooga.towerdefense.attributes.Targetable;
import vooga.towerdefense.attributes.Upgradable;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;


/**
 * Basic tower that is capable of shooting a unit.
 * 
 * @author XuRui
 * 
 */
public class BasicTower extends GameElement implements Attacker {

    List<AbstractAction> myActions;
    Attributes myAttributes;

    public BasicTower (Pixmap image, Location center, Dimension size,
                       Attributes attributes, List<AbstractAction> actions) {
        super(image, center, size, attributes, actions);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double getAttackRadius () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getNumberOfTargets () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getAttackDamage () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Targetable getTarget () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addTarget () {
        // TODO Auto-generated method stub

    }

    @Override
    public Location getAttackCenter () {
        // TODO Auto-generated method stub
        return null;
    }

}
