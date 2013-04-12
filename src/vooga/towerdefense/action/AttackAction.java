package vooga.towerdefense.action;

import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.gameElements.Projectile;

public class AttackAction extends AbstractAction {
	Attacker myInitiator;
	double myCoolDown;
	boolean isOneTimeAction;

	public AttackAction(InfoBridge info, Attacker source, double cooldown, boolean isOneTime) {
		super(info);
		myCoolDown=cooldown;
		isOneTimeAction=isOneTime;

	}

	@Override
	public void execute(GameElement initiator, double elapsedTime) {
		//check whether it's in cool down
		if (isReady()) {
			//get targets that we wanna shoot
			Targetable[] targets = getInfoBridge()
					.getTargetsWithinRadiusOfGivenLocation(
							initiator.getCenter(),
							myInitiator.getAttackRadius(),
							myInitiator.getNumberOfTargets());
			
			//shoot a projectile towards each target
			for (Targetable target : targets) {
				getInfoBridge().addGameElement(
						new Projectile(initiator, target));
			}
		}
		
		//set cooldown
		else{
			setCoolDown(myCoolDown,isOneTimeAction);
		}

	}
}
