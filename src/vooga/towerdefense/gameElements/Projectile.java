package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import vooga.towerdefense.action.AbstractAction;
import vooga.towerdefense.attributes.Attacker;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.attributes.Targetable;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;
import vooga.towerdefense.gameElements.GameElement;

/**
 * GameElement projectile that can affect other game elements.
 *
 */
public class Projectile extends GameElement implements Attacker {
	private static final AttributeConstants myAttributeConstants=new AttributeConstants();
    private static int DEFAULT_WIDTH;
    private static final Pixmap DEFAULT_IMAGE = new Pixmap("defined by designer");
    private static final Dimension DEFAULT_SIZE = new Dimension(DEFAULT_WIDTH, DEFAULT_WIDTH);
    private static final List<AbstractAction> DEFAULT_ACTIONS = new ArrayList<AbstractAction>();
    private AttributeManager myAttributeManager;

    
    public Projectile (GameElement initiator, Targetable target, List<AbstractAction> actions, AttributeManager attributes) {
        super(DEFAULT_IMAGE, initiator.getCenter(), DEFAULT_SIZE, DEFAULT_ACTIONS);
        myAttributeManager = attributes;

    }
    public Projectile (GameElement initiator, Targetable target, List<AbstractAction> actions) {
        super(DEFAULT_IMAGE, initiator.getCenter(), DEFAULT_SIZE, DEFAULT_ACTIONS);
        myAttributeManager = initiator.getAttributeManager();

    }


    @Override
    public double getAttackRadius () {
        return myAttributeManager.getAttribute(myAttributeConstants.ATTACK_RADIUS).getValue();
    }

    @Override
    public int getNumberOfTargets () {
    	return (int)(myAttributeManager.getAttribute(myAttributeConstants.NUM_OF_TARGETS).getValue());
    }

    @Override
    public double getAttackDamage () {
    	 return myAttributeManager.getAttribute(myAttributeConstants.ATTACK_DAMAGE).getValue();
    }

    @Override
    public Targetable getTarget () {

        return null;
    }

    @Override
    public void addTarget () {

    }

    @Override
    public Location getAttackCenter () {
        return null;
    }

}
