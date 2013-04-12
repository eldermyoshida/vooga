package vooga.towerdefense.action;

import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.gameElements.Projectile;

public class AttackAction extends AbstractAction{
	Attacker myInitiator;
	
	public AttackAction(InfoBridge info, Attacker source){
		super(info);
		
	}
	
	@Override
	public void execute(GameElement initiator, double elapsedTime){
		Targetable[] targets=getInfoBridge().getTargetsWithinRadiusOfGivenLocation(initiator.getCenter(), myInitiator.getAttackRadius(),myInitiator.getNumberOfTargets());
		for (Targetable target: targets){
			getInfoBridge().addGameElement(new Projectile(initiator,target));
		}
		
	}
}
