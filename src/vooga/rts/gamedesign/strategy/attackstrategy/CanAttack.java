package vooga.rts.gamedesign.strategy.attackstrategy;

import java.util.ArrayList;
import java.util.List;

import vooga.rts.gamedesign.Weapon;
import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;
import vooga.rts.gamedesign.sprite.rtsprite.RTSprite;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.buildings.Building;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Soldier;
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

	private List<Weapon> myWeapons;
	private int myWeaponIndex;
	
	public CanAttack(){
		myWeapons = new ArrayList<Weapon>();
		myWeaponIndex = 0;

	}


	public void attack(IAttackable a) throws CloneNotSupportedException{
		myWeapons.get(myWeaponIndex).fire((RTSprite) a);

	}
	public boolean hasWeapon(){
		return !myWeapons.isEmpty();

	}
	public void addWeapons(Weapon weapon) {
		myWeapons.add(weapon);
	}

	public void update() {
		Weapon weapon = myWeapons.get(myWeaponIndex);
		if(weapon.getCooldown() > 0) {
			weapon.decrementCooldown();

		}
	}

}
