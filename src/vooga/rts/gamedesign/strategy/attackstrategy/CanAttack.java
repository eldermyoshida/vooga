package gamedesign.strategy.attackstrategy;

import java.util.List;

import gamedesign.Weapon;
import gamedesign.sprite.rtsprite.interactive.buildings.Building;
import gamedesign.sprite.rtsprite.interactive.units.Units;

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
	
	@Override
	public void attack(Building building) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(Units units) {
		// TODO Auto-generated method stub
		
	}

}
