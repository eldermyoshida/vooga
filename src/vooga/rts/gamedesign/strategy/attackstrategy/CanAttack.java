package vooga.rts.gamedesign.strategy.attackstrategy;

import java.util.ArrayList;
import java.util.List;
import vooga.rts.gamedesign.sprite.gamesprites.IAttackable;
import vooga.rts.gamedesign.sprite.gamesprites.Projectile;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.gamedesign.strategy.Strategy;
import vooga.rts.gamedesign.weapon.Weapon;
import vooga.rts.util.Location3D;


/**
 * This class implements AttackStrategy and is used as an instance in
 * InteractiveEntity for objects that are able to attack. The attack method in
 * this class will specify how the interactive will attack.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 * 
 */
public class CanAttack implements AttackStrategy {

    private static final Location3D DEFAULTLOCATION = new Location3D(0, 0, 0);
    private static final int DEFAULTTEAM = 0;
    private List<Weapon> myWeapons;
    private int myWeaponIndex;

    /**
     * Creates a new attack strategy that represents an entity that can attack.
     * This strategy is created with a weapon so that the entity will be able
     * to attack.
     * 
     * @param worldLocation is the location of the entity that has this
     *        strategy (it is needed for the position of the weapon)
     * @param PlayerID is the team that the entity with this strategy is on
     */
    public CanAttack (Location3D worldLocation, int PlayerID) {
        myWeapons = new ArrayList<Weapon>();
        myWeaponIndex = 0;
    }

    public CanAttack () {
        this(DEFAULTLOCATION, DEFAULTTEAM);
    }

    /**
     * Attacks the given IAttackable object by first judging whether the Weapon
     * is in range for the attack action.
     * 
     * @param enemy the IAttackable object being attacked.
     * @param distance the distance between the CanAttack object and the enemy.
     */
    public void attack (IAttackable enemy, double distance) {        
        if (inWeaponRange((InteractiveEntity) enemy, distance)) {
            myWeapons.get(myWeaponIndex).fire((InteractiveEntity) enemy);
        }
    }

    public void setWeaponLocation (Location3D newLocation) {
        for (Weapon weapon : myWeapons) {
            weapon.setCenter(newLocation);
        }
    }

    /**
     * Determines if the IAttackable object is in the range of the currently
     * activated Weapon.
     * 
     * @param enemy the IAttackable object being attacked.
     * @param distance the distance between the CanAttack object and the enemy.
     * @return whether the IAttackable object is in the range of the currently
     *         activated Weapon.
     */
    private boolean inWeaponRange (InteractiveEntity enemy, double distance) {
        return (!myWeapons.isEmpty() && myWeapons.get(myWeaponIndex).inRange(enemy, distance));
    }

    /**
     * Returns the list of Weapon stored in this CanAttack object.
     * 
     * @return the list of Weapon stored
     */
    public List<Weapon> getWeapons () {
        return myWeapons;
    }

    /**
     * Sets myWeapons to the new list of weapons.
     */
    public void setWeapons (List<Weapon> newWeapons) {
        myWeapons = newWeapons;
    }

    /**
     * Returns the index of the Weapon that's currently been activated in the
     * list of Weapons belonged to this CanAttack object.
     * 
     * @return the index of the Weapon that's currently been activated
     */
    public int getWeaponIndex () {
        return myWeaponIndex;
    }

    /**
     * Changes the currently activated Weapon by setting its index as
     * WeaponIndex.
     * 
     * @param weaponIndex
     */
    public void setWeaponIndex (int weaponIndex) {
        myWeaponIndex = weaponIndex;
    }

    /**
     * Adds a Weapon to the list of Weapons belonged to this AttackStrategy.
     * 
     * @param weapon the new Weapon to be added into the list.
     */
    public void addWeapon (Weapon weapon) {
        myWeapons.add(weapon);
    }

    public Weapon getCurrentWeapon () {
        return myWeapons.get(myWeaponIndex);
    }

    public boolean hasWeapon () {
        return true;
    }

    public void copyStrategy (InteractiveEntity other) {
        CanAttack toAdd = new CanAttack();
        toAdd.setWeaponIndex(0);
        toAdd.setWeapons(this.getWeaponCopies());
        other.setAttackStrategy(toAdd);
    }

    private List<Weapon> getWeaponCopies () {
        ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
        for (Weapon w : myWeapons) {
            weaponList.add(w.copy());
        }
        return weaponList;
    }

    @Override
    public void setPlayerID (int playerID) {
        for (Weapon weapon : myWeapons) {
            weapon.getProjectile().setPlayerID(playerID);
        }

    }

}
