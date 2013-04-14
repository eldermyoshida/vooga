package vooga.rts.gamedesign.strategy.attackstrategy;

import java.util.ArrayList;
import java.util.List;

import vooga.rts.gamedesign.Weapon;
import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;


/**
 * This class implements AttackStrategy and is used as an instance in
 * interactives for objects that are able to attack. The attack method in this
 * class will specify how the interactive will attack.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 * 
 */
public class CanAttack implements AttackStrategy {
    private List<Weapon> myWeapons;
    private int myWeaponIndex;
    private boolean myCanAttack = true;

	public CanAttack() {
		 myWeapons = new ArrayList<Weapon>();
		 myWeaponIndex = 0;
	}

	@Override
	public void attack(IAttackable a, double distance) {
		if(inWeaponRange((InteractiveEntity) a, distance)) {
            myWeapons.get(myWeaponIndex).fire((InteractiveEntity) a);
        }    
	}
	
    public boolean inWeaponRange(InteractiveEntity enemy, double distance) {
        //ellipse thing doesnt seem to be working very well. 
        if(!myWeapons.isEmpty() && distance < myWeapons.get(myWeaponIndex).getRange()){
            return true;
        }
        //buggy :( myWeapons.get(myWeaponIndex).inRange(enemy)
        return false;
    }
    
    public List<Weapon> getWeapons() {
        return myWeapons;
    }
    public int getWeaponIndex() {
        return myWeaponIndex;
    }
    
    public void setWeaponIndex(int weaponIndex) {
        myWeaponIndex = weaponIndex;
    }

    public boolean hasWeapon(){
        return !myWeapons.isEmpty();
    }
    
    public void addWeapons(Weapon weapon) {
        myWeapons.add(weapon);
    }

	@Override
	public boolean getCanAttack() {
		return myCanAttack;
	}
}
