package vooga.rts.gamedesign.strategy.attackstrategy;

import java.util.List;

import vooga.rts.gamedesign.Weapon;
import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.buildings.Building;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Units;

/**
 * This class implements AttackStrategy and is used as an instance in 
 * interactives for objects that are able to attack.  The attack method in this
 * class will specify how the interactive will attack.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class CanAttack implements AttackStrategy{
	
	private Weapon myWeapon;

	
	public CanAttack(Weapon weapon){
		myWeapon = weapon;
	}

	public void attack(IAttackable a){
		if(a instanceof Units){
			attack((Units ) a);
		}
	}
	
	private void attack(Units u){
		myWeapon.fire(u);
	}

}
