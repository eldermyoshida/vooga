package vooga.rts.gamedesign.sprite.rtsprite;

import java.awt.Dimension;


import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;



/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public abstract class Projectile extends RTSprite implements IMovable {

	
	private Integer myDamage;
	
	
	public Projectile(Pixmap pixmap, Location loc, Dimension size, Sound sound, int damage, int health){
		super(pixmap, loc, size, sound, damage, health);
		myDamage = damage;
	}

	/**
	 * Moves the Unit only. Updates first the angle the Unit is facing,
	 * and then its location.
	 */
	//TODO: duplicated code!!!!!!!! with Units
	public void move (Location loc){
		double angle = getCenter().difference(loc).getDirection();
		double magnitude = getCenter().difference(loc).getMagnitude();
		turn(angle);
		setVelocity(angle, magnitude);
	}
	
	/**
	 * Rotates the Unit by the given angle. 
	 * @param angle
	 */
	public void turn(double angle){
		getVelocity().turn(angle);
	}
}