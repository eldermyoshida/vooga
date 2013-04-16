package vooga.towerdefense.action;

import java.util.ArrayList;
import java.util.List;

import vooga.towerdefense.attributes.Attacker;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.attributes.Targetable;
import vooga.towerdefense.event.Event;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.gameElements.Projectile;

/**
 * Single attack action launched by a GameElement at Targetable object.
 * @author XuRui
 * @author Matthew Roy
 *
 */
public class AttackAction extends Action {
	private static final AttributeConstants myAttributeConstants = new AttributeConstants();
	GameElement myInitiator;
	double myCoolDown;
	boolean isOneTimeAction;

	public AttackAction(GameElement initiator){
		super(initiator);
		
	}
	
	/*public AttackAction(InfoBridge info, Attacker source, double cooldown, boolean isOneTime) {
		super(info);
		myCoolDown=cooldown;
		isOneTimeAction=isOneTime;

	}*/

	@Override
	public void executeAction() {
		//check whether it's in cool down
		if (isEnabled()) {
			//get targets that we wanna shoot
			Targetable[] targets = getInfoBridge()
					.getTargetsWithinRadiusOfGivenLocation(
							myInitiator.getCenter(),
							myInitiator.getAttributeManager().getAttribute(myAttributeConstants.ATTACK_RADIUS).getValue(),
							(int)(myInitiator.getAttributeManager().getAttribute(myAttributeConstants.NUM_OF_TARGETS).getValue()));
			
			//shoot a projectile towards each target
			for (Targetable target : targets) {
				getInfoBridge().addGameElement(
						new Projectile(myInitiator, target,new ArrayList<AbstractAction>()));
			}
			
			//setCoolDown(myCoolDown,isOneTimeAction);
		}

	}

    @Override
    public void initAction () {
        
    }
}
