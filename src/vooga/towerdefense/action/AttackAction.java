package vooga.towerdefense.action;

import vooga.towerdefense.attributes.Attacker;
import vooga.towerdefense.attributes.Targetable;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.gameElements.Projectile;

/**
 * Single attack action launched by at Targetble object.
 * @author XuRui
 *
 */
public class AttackAction extends AbstractAction {
	Attacker myInitiator;
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
	public void execute(double elapsedTime) {
		//check whether it's in cool down
		if (isEnabled()) {
			//get targets that we wanna shoot
			Targetable[] targets = getInfoBridge()
					.getTargetsWithinRadiusOfGivenLocation(
							myInitiator.getAttackCenter(),
							myInitiator.getAttackRadius(),
							myInitiator.getNumberOfTargets());
			
			//shoot a projectile towards each target
			for (Targetable target : targets) {
				getInfoBridge().addGameElement(
						new Projectile(myInitiator, target));
			}
		}
		
		//set cooldown
		/*else{
			setCoolDown(myCoolDown,isOneTimeAction);
		}*/

	}
}
