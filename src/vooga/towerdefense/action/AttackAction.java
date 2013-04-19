
package vooga.towerdefense.action;

import java.util.ArrayList;
import java.util.List;

import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.factories.ProjectileFactory;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.gameElements.Projectile;
import vooga.towerdefense.model.GameMap;

/**
 * Single attack action launched by a GameElement.
 * @author XuRui
 * @author Matthew Roy
 * @author Zhen Gou
 *
 */
public class AttackAction extends Action {
	private static final AttributeConstants ATTRIBUTE_CONSTANTS = new AttributeConstants();
	private GameElement myInitiator;
	private GameMap myMap;

	public AttackAction(GameMap map){
		myMap = map;
	}
	
	public AttackAction(GameMap map, GameElement initiator, ProjectileFactory projectileToCreate){
        myMap = map;
    }
	
	/*public AttackAction(InfoBridge info, Attacker source, double cooldown, boolean isOneTime) {
		super(info);
		myCoolDown=cooldown;
		isOneTimeAction=isOneTime;

	}*/

	@Override
	public void executeAction(double elapsedTime) {
		//check whether it's in cool down
		if (isEnabled()) {
			//get targets that we wanna shoot
			List<GameElement> targets = myMap
					.getTargetsWithinRadius(
							myInitiator.getCenter(),
							myInitiator.getAttributeManager().getAttribute(ATTRIBUTE_CONSTANTS.ATTACK_RADIUS).getValue(),
							(int)(myInitiator.getAttributeManager().getAttribute(ATTRIBUTE_CONSTANTS.NUM_OF_TARGETS).getValue()));
			
			//shoot a projectile towards each target
			
			for (GameElement target : targets) {
				myMap.addGameElement(myInitiator.getAttributeManager().getProjectileFactory().createProjectile(myInitiator,target));
			}
			
		}

	}

    @Override
    public void initAction () {
        
    }

	@Override
	public void update(double elapsedTime) {
		// TODO Auto-generated method stub
		
	}
}

