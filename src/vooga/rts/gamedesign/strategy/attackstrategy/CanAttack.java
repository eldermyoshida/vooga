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

        System.out.println("Soldier a health " + ((RTSprite) a).getHealth());
        myWeapons.get(myWeaponIndex).fire((RTSprite) a);

        ((RTSprite)a).die();
        System.out.println("a died");
    }
    public boolean hasWeapon(){
        return !myWeapons.isEmpty();

    }
    public Weapon getWeapon(){
        return myWeapons.get(0);
    }
    public void addWeapons(Weapon weapon) {
        myWeapons.add(weapon);
    }

    public void update() {
        for(int i = 0; i < myWeapons.size(); i++) {
            Weapon weapon = myWeapons.get(i);
            if(weapon.getCooldown() > 0) {
                weapon.decrementCooldown();
            }
        }
    }
}
