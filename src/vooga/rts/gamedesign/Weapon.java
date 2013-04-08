package vooga.rts.gamedesign;

import vooga.rts.gamedesign.sprite.rtsprite.Projectile;
import vooga.rts.gamedesign.upgrades.Upgrade;
import vooga.rts.gamedesign.upgrades.UpgradeTree;

/**
 * This class represents a weapon.  The CanAttack class the implements
 * AttackStrategy contains a list of weapons so that every interactive that can attack
 * will have an instance of a weapon.  A weapon can do damage and also contains
 * a projectile that does damage.  A weapon is used to attack by using the fire
 * method. When an upgrade of a pojectile is selected, the weapon will just
 * change the type of projectile that it contains to the specified projectile.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public abstract class Weapon {
	private int myDamage;

	private Projectile myProjectile;

	private UpgradeTree myUpgradeTree;

	private int myRange;

	/**
	 * Creates a new weapon with default damage and projectile.
	 * @param damage
	 * @param projectile
	 */
	public Weapon(int damage, Projectile projectile, int range) {
		myDamage = damage;
		myProjectile = projectile;
		myRange = range;
	}

	/**
	 * This method is used by the weapon to attack an RTSprite.
	 */
	public void fire() {
	}

	/**
	 * This method is used to upgrade a weapon either 
	 * @param upgrade
	 */
	public void upgrade(Upgrade upgrade) {
	}

	/**
	 * This method is used to change the projectile for the weapon
	 * @param projectile is the projectile that will be used by the weapon
	 */
	public void setProjectile(Projectile projectile) {
		myProjectile = projectile;
	}

	public void setRange(int range) {
		myRange = range;
	}
}