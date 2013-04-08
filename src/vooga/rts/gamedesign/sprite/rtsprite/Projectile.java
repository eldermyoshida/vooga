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
	
	private boolean isSelected;
	
	
	public Projectile(Pixmap pixmap, Location loc, Dimension size, Sound sound, int damage, int health){
		super(pixmap, loc, size, sound, damage, health);
		myDamage = damage;
	}
	
	
	public void attack(RTSprite other){
		System.out.println("projectile is on target");
		other.accept(this);
		move(other.getCenter());
	}
	
	public Projectile clone(Projectile toClone){
		try {
			return (Projectile) toClone.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("this was a dumb idea");
		}
		return null;
	}
	

}