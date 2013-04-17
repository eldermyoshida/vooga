package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.util.List;
import vooga.towerdefense.action.Action;
import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.attributes.TargetTracker;
import vooga.towerdefense.attributes.Targetable;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;


/**
 * Basic tower that is capable of shooting a unit.
 * 
 * @author XuRui
 * 
 */
public class AttackingTower extends GameElement implements TargetTracker{

    List<Action> myActions;
    AttributeManager myAttributes;

    public AttackingTower (Pixmap image, Location center, Dimension size,
                       AttributeManager attributes, List<Action> actions) {
        super(image, center, size, attributes, actions);
        // TODO Auto-generated constructor stub
    }

    
    //needs to figure out a way to get targets within range
	@Override
	public List<Targetable> getTargetsInRange() {
		//Attribute attackRadius = this.myAttributeManager.getAttribute(attackRadius);
		return null;
	}

	@Override
	public Location locateTarget(Targetable target) {
		return target.getLocation();
	}

	@Override
	public void actOnTarget(Targetable target) {
		// TODO Auto-generated method stub
		
	}



}
