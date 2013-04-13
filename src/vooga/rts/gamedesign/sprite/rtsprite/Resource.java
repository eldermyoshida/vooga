package vooga.rts.gamedesign.sprite.rtsprite;

import java.awt.Dimension;

import vooga.rts.gamedesign.sprite.GameEntity;
import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.IGatherable;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;

/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class Resource extends GameEntity implements IGatherable {
	
	public Resource(Pixmap image, Location center, Dimension size, int teamID, int health) {
		super(image, center, size, teamID, health);

	}

	@Override
	public void getGathered(int damage) {
		changeHealth(damage);
		if (isDead()) {
			setVisible(false);
			//TODO: completely remove it.
		}
	}
}