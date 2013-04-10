package vooga.rts.gamedesign.sprite.rtsprite;

import java.awt.Dimension;


import vooga.rts.gamedesign.sprite.GameEntity;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import vooga.rts.util.ThreeDimension;


/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class Projectile extends GameEntity implements Cloneable{

	
	private Integer myDamage;
	private boolean isSelected;
	
	
	public Projectile(Pixmap pixmap, Location loc, ThreeDimension size, int teamID){
		super(pixmap, loc, size, teamID);
	}
	
	public Projectile clone() {
		return this.clone();
	}
	

}