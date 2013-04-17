package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import vooga.towerdefense.action.Action;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;
import vooga.towerdefense.gameElements.GameElement;

/**
 * GameElement projectile that can affect other game elements.
 *
 */
public class Projectile extends GameElement {
	private static final AttributeConstants myAttributeConstants=new AttributeConstants();
    private static int DEFAULT_WIDTH;
    private static final Pixmap DEFAULT_IMAGE = new Pixmap("defined by designer");
    private static final Dimension DEFAULT_SIZE = new Dimension(DEFAULT_WIDTH, DEFAULT_WIDTH);
    private static final List<Action> DEFAULT_ACTIONS = new ArrayList<Action>();
    private AttributeManager myAttributeManager;

    
    public Projectile (GameElement initiator, GameElement target, List<Action> actions, AttributeManager attributes) {
        super(DEFAULT_IMAGE, initiator.getCenter(), DEFAULT_SIZE, DEFAULT_ACTIONS);
        myAttributeManager = attributes;

    }
    public Projectile (GameElement initiator, GameElement target, List<Action> actions) {
        super(DEFAULT_IMAGE, initiator.getCenter(), DEFAULT_SIZE, DEFAULT_ACTIONS);
        myAttributeManager = initiator.getAttributeManager();

    }
    
    public Projectile(Location spawn,GameElement target){
    	super(DEFAULT_IMAGE,spawn,DEFAULT_SIZE,DEFAULT_ACTIONS);
    }


    
    public double getAttackRadius () {
        return myAttributeManager.getAttribute(myAttributeConstants.ATTACK_RADIUS).getValue();
    }

    
    public int getNumberOfTargets () {
    	return (int)(myAttributeManager.getAttribute(myAttributeConstants.NUM_OF_TARGETS).getValue());
    }

    
    public double getAttackDamage () {
    	 return myAttributeManager.getAttribute(myAttributeConstants.ATTACK_DAMAGE).getValue();
    }

    
    public GameElement getTarget () {

        return null;
    }

    
    public void addTarget () {

    }

    
    public Location getAttackCenter () {
        return null;
    }

}
