package vooga.rts.gamedesign.sprite.rtsprite;

import java.awt.Dimension;


import vooga.rts.gamedesign.sprite.GameEntity;
import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import vooga.rts.util.ThreeDimension;


/**
 * This class is the generic abstract class for all types of projectiles that
 * can be fired from a weapon by an InteractiveEntity. The Projectile’s health
 * is the time the projectile can exist on the map before it vanishes. It also
 * vanishes after it collides with a GameEntity. 
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class Projectile extends GameEntity implements Cloneable{

	private int myDamage;
	private InteractiveEntity myTarget;
	
	public Projectile(Pixmap pixmap, Location loc, Dimension size, int teamID, int damage, int health){
		super(pixmap, loc, size, teamID, health);
		myDamage = damage;
	}
	
	public Projectile clone() {
		return this.clone();
	}
	
	public void setTarget(InteractiveEntity target){
	    myTarget = target;
	}
	
	/**
	 * Applies the damage to the target it collides with by updating the
	 * target’s health value.
	 * 
	 * @param target
	 */
	public void attack(InteractiveEntity target){
	    target.changeHealth(target.calculateDamage(myDamage));
	}
	
	@Override
	public void update(double elapsedTime){
	    super.update(elapsedTime);
	    if(this.interactsWith(myTarget)){
	        System.out.println("projectile has hit");
	        myTarget.accept(this);
	        this.setHealth(0);
	    }
	}
}