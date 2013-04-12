package vooga.rts.gamedesign.sprite.rtsprite;

import java.awt.Dimension;


import vooga.rts.gamedesign.sprite.GameEntity;
import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import vooga.rts.util.ThreeDimension;
import vooga.rts.util.Vector;


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

	
	private static final int SPEED = 4;
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
		Vector between = getCenter().difference(target.getCenter());
		double angle = between.getAngle();
		setVelocity(angle, SPEED);
	}
	
	
	@Override
	public void update(double elapsedTime){
	    super.update(elapsedTime);
	    System.out.println(this.getCenter());
	}

	public void attack(InteractiveEntity interactiveEntity) {
		interactiveEntity.changeHealth(myDamage);
		
	}
}