package vooga.rts.gamedesign;

import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;
import vooga.rts.gamedesign.sprite.rtsprite.Projectile;
import vooga.rts.gamedesign.sprite.rtsprite.RTSprite;
import vooga.rts.gamedesign.upgrades.Upgrade;
import vooga.rts.gamedesign.upgrades.UpgradeTree;
import vooga.rts.util.Location;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;


/**
 * This class represents a weapon. The CanAttack class the implements
 * AttackStrategy contains a list of weapons so that every interactive that can attack
 * will have an instance of a weapon. A weapon can do damage and also contains
 * a projectile that does damage. A weapon is used to attack by using the fire
 * method. When an upgrade of a pojectile is selected, the weapon will just
 * change the type of projectile that it contains to the specified projectile.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 * 
 */
public class Weapon {

    private int myDamage;
    private Projectile myProjectile;
    private UpgradeTree myUpgradeTree;
    private int myRange;
    private List<Projectile> myProjectiles;
    private int maxCooldown;
    private int cooldown;
    private Ellipse2D myRangeCircle;

    /**
     * Creates a new weapon with default damage and projectile.
     * 
     * @param damage
     * @param projectile
     */
    public Weapon (int damage, Projectile projectile, int range, Location center, int cooldownTime) {
        myDamage = damage;
        myProjectile = projectile;
        myRange = range;
        maxCooldown = cooldownTime;
        myRangeCircle = new Ellipse2D.Double(center.getX(), center.getY(), range, range);
        myProjectiles = new ArrayList<Projectile>();
    }

    /**
     * This method is used by the weapon to attack an RTSprite.
     * 
     * @throws CloneNotSupportedException
     */
    public void fire (InteractiveEntity toBeShot) throws CloneNotSupportedException {

        System.out.println("Health of enemy " + toBeShot.getHealth());
        System.out.println("cooldown " + cooldown);
        if (cooldown == 0) {
            // should set the velocity of the projectile to the location of the toBeshot
            myProjectile.attack(toBeShot);
            // myProjectile.move(toBeShot.getCenter()); is NOT working :( dumb angles
            // myProjectile.setTarget(toBeShot);
            myProjectiles.add(myProjectile);
            System.out.println("Weapon has fired");
            setCooldown(maxCooldown);
        }
        System.out.println("Health of enemy " + toBeShot.getHealth() +
                           "number of projectiles fired " + myProjectiles.size());
    }

    /**
     * This method is used to upgrade a weapon either
     * 
     * @param upgrade
     */
    public void upgrade (Upgrade upgrade) {
    }

    public List<Projectile> getProjectiles () {
        return myProjectiles;
    }

    /**
     * This method is used to change the projectile for the weapon
     * 
     * @param projectile is the projectile that will be used by the weapon
     */
    public void setProjectile (Projectile projectile) {
        myProjectile = projectile;
    }

    /**
     * Checks to see if the interactive passed in is in the range of the
     * weapon.
     * 
     * @param interactive is checked to see if it is in the range of the weapon
     * @return true if the interactive is in the range of the weapon and false
     *         if the interactive is out of the range of the weapon
     */
    public boolean inRange (InteractiveEntity interactive, Location center) {
        // add z axis
        myRangeCircle = new Ellipse2D.Double(center.getX(), center.getY(), myRange, myRange);
        return myRangeCircle.contains(interactive.getCenter());
    }

    /**
     * subtracts 1 from the cooldown counter
     */
    public void decrementCooldown () {
        cooldown--;
    }

    /**
     * Returns the cooldown time on the weapon
     * 
     * @return the cooldown time on the weapon
     */
    public int getCooldown () {
        return cooldown;
    }

    /**
     * After the weapon fires, the cooldown is set to the max cooldown for the
     * weapon.
     * 
     * @param time is the time that the cooldown is set to
     */
    private void setCooldown (int time) {
        cooldown = time;
    }

    public void update (double elapsedTime) {
        for (Projectile p : myProjectiles) {
            p.update(elapsedTime);
            if (p.isDead()) {
                myProjectiles.remove(p);
            }
        }
        decrementCooldown();
    }
}
