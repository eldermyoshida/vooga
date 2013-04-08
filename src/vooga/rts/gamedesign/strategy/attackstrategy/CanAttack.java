package vooga.rts.gamedesign.strategy.attackstrategy;

import java.util.ArrayList;
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
	
	private List<Weapon> myWeapons;
	
	public CanAttack() {
		myWeapons = new ArrayList<Weapon>();
	}
	
	@Override
	public void attack(Building building) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(Units units) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(IAttackable a) {
		// TODO Auto-generated method stub
		
	}
	
	public void addWeapons(Weapon weapon) {
		myWeapons.add(weapon);
	}

}
