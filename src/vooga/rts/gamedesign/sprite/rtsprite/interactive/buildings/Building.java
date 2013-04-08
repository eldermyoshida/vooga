package vooga.rts.gamedesign.sprite.rtsprite.interactive.buildings;

import java.awt.Dimension;

import vooga.rts.gamedesign.sprite.rtsprite.interactive.Interactive;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;


/**
 * This is an abstract class that represents a building.  It will be extended
 * by specific types of buildings such as AttackTower.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public abstract class Building extends Interactive {

	public Building(Pixmap image, Location center, Dimension size, Sound sound,
			int teamID, int health) {
		super(image, center, size, sound, teamID, health);
		// TODO Auto-generated constructor stub
	}
	
	
	
}