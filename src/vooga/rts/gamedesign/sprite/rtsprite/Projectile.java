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
	
	private boolean myIsSelected;
	
	
	public Projectile(Pixmap pixmap, Location loc, Dimension size, Sound sound, int damage, int health){
		super(pixmap, loc, size, sound, damage, health);
		myDamage = damage;
	}

}