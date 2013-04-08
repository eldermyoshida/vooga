package vooga.rts.gamedesign.strategy.attackstrategy;

import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Units;

public class InstantDamage implements AttackStrategy {

	@Override
	public void attack(IAttackable a) {
		if(a instanceof Units){
			attack((Units) a);
		}

	}
	
	private void attack(Units toDamage){
		toDamage.changeHealth(10);
	}

}
