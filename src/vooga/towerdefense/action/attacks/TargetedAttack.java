package vooga.towerdefense.action.attacks;

import java.util.ArrayList;
import java.util.List;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.TargetedAction;
import vooga.towerdefense.attributes.Attacker;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.attributes.Targetable;
import vooga.towerdefense.event.Event;
import vooga.towerdefense.gameElements.AttackingTower;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.gameElements.Projectile;

/**
 * Single attack action launched by a GameElement at Targetable object.
 * @author XuRui
 * @author Matthew Roy
 *
 */
public class TargetedAttack extends TargetedAction {
	private static final AttributeConstants myAttributeConstants = new AttributeConstants();
	AttackingTower myInitiator;


	public TargetedAttack(GameElement initiator){
		super(initiator);
		
	}

	@Override
	public void executeAction() {
		//check whether it's in cool down
		if (isEnabled()) {
			//get targets that we wanna shoot
			List<Targetable> targets = myInitiator.getTargetsInRange();
			
			//shoot a projectile towards each target
			for (Targetable target : targets) {
				getInfoBridge().addGameElement(
						new Projectile(myInitiator, target,new ArrayList<AbstractAction>()));
			}
			
			//setCoolDown(myCoolDown,isOneTimeAction);
		}

	}
	
	@Override
	public void update(double elapsedTime){
		
	}


}
