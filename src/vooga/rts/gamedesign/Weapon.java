package vooga.rts.gamedesign;

import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;
import vooga.rts.gamedesign.sprite.rtsprite.Projectile;
import vooga.rts.gamedesign.upgrades.*;
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
    private Interval interval;
    private Ellipse2D myRangeCircle;
    private Location myCenter;

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
        interval = new Interval(cooldownTime);
        myCenter = center;
        myProjectiles = new ArrayList<Projectile>();
    }

    /**
     * This method is used by the weapon to attack an RTSprite.
     * 
     * 
     */
    public void fire (InteractiveEntity toBeShot) {
        if(interval.allowAction() && !toBeShot.isDead()){
            Projectile fire = new Projectile(myProjectile, myCenter);
            fire.setEnemy(toBeShot);
            fire.move(toBeShot.getCenter());
            myProjectiles.add(fire);
            interval.resetCooldown();
        }
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
    public boolean inRange (InteractiveEntity enemy) {
        // add z axis
        //see if enemy is in adjacent node, better way. 
        myRangeCircle = new Ellipse2D.Double(myCenter.getX(), myCenter.getY(), myRange, myRange);
        return myRangeCircle.contains(enemy.getCenter());
    }
    public int getRange(){
        return myRange;
    }

    public void update (double elapsedTime) {
        if(!interval.allowAction()){
            interval.decrementCooldown();
        }
        for(Projectile p : myProjectiles){
            p.update(elapsedTime);
        }
    }
}
