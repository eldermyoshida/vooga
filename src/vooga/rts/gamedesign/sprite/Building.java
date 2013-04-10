package vooga.rts.gamedesign.sprite;

import java.awt.Dimension;

import vooga.rts.gamedesign.sprite.rtsprite.RTSprite;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import vooga.rts.util.ThreeDimension;


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
public abstract class Building extends InteractiveEntity {
	public static final int MAXHEALTH = 100;
	
	public Building(Pixmap image, Location center, ThreeDimension size, Sound sound,
			int teamID, int health) {
		super(image, center, size, sound, teamID, MAXHEALTH);

	}

	public void visit(RTSprite rtSprite) {
		//TODO
	}
}