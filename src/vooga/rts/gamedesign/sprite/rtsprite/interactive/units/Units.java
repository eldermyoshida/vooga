package vooga.rts.gamedesign.sprite.rtsprite.interactive.units;

import vooga.rts.gamedesign.Weapon;
import vooga.rts.gamedesign.sprite.rtsprite.IMovable;
import vooga.rts.gamedesign.sprite.rtsprite.RTSprite;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.Interactive;
import vooga.rts.gamedesign.strategy.gatherstrategy.GatherStrategy;
import vooga.rts.gamedesign.strategy.occupystrategy.OccupyStrategy;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;

import java.awt.Dimension;
import java.util.List;

/**
 * This is an abstract class that represents a unit.  It will be extended
 * by specific types of units such as soldiers.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public abstract class Units extends Interactive implements IMovable {

	private  List<Interactive> myKills;
	
	private boolean myIsLeftSelected; //TODO: also need the same thing for Projectiles
	private boolean myIsRightSelected; //TODO: should be observing the mouse action instead!!

	public Units(Pixmap image, Location center, Dimension size, Sound sound, int teamID, int health) {
		super(image, center, size, sound, teamID, health);

	}



	/**
	 * Moves the Unit only when it is selected. Updates first the angle
	 * the Unit is facing, and then its location.
	 */
	public void move(Location loc){
		if (myIsLeftSelected){
			double angle = getCenter().difference(loc).getDirection();
			double magnitude = getCenter().difference(loc).getMagnitude();
			turn(angle);
			setVelocity(angle, magnitude);
		}
	}

	/**
	 * Rotates the Unit by the given angle. 
	 * @param angle
	 */
	public void turn(double angle){
		getVelocity().turn(angle);
	}

}