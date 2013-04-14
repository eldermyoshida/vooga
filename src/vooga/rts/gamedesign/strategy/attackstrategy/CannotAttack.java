package vooga.rts.gamedesign.strategy.attackstrategy;

import java.util.ArrayList;
import java.util.List;

import vooga.rts.gamedesign.Weapon;
import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;


/**
 * 
 * This class implements AttackStrategy and is used as an instance in
 * interactives for objects that are not able to attack.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 * 
 */

public class CannotAttack implements AttackStrategy {
	private List<Weapon> myWeapons;
	private int myWeaponIndex;
	private boolean myCanAttack = false;

	public CannotAttack() {
		 myWeapons = new ArrayList<Weapon>();
		 myWeaponIndex = 0;
	}

	@Override
	public void attack(IAttackable a, double distance) {
		return;
	}

	@Override
	public List<Weapon> getWeapons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWeaponIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addWeapons(Weapon weapon) {
		myWeapons.add(weapon);

	}

	@Override
	public boolean getCanAttack() {
		return myCanAttack;
	}
}
