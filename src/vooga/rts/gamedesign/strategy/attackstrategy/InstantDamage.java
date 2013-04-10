package vooga.rts.gamedesign.strategy.attackstrategy;

import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Units;

/**
 * This class represents the attack strategy for things that apply instant
 * damage when they collide with something.  An example of something that
 * would have an InstantDamage attack strategy is a projectile.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class InstantDamage implements AttackStrategy {

	int myDamage;
	
	@Override
	public void attack(IAttackable a) {
		if(a instanceof Units){
			attack((Units) a);
		}

	}
	
	private void attack(Units toDamage){
		toDamage.changeHealth(myDamage);
	}
	
	public void setDamage(int damage) {
		myDamage = damage;
	}

}
