package vooga.rts.gamedesign.sprite.rtsprite;

import java.awt.Dimension;

import vooga.rts.gamedesign.sprite.map.Terrain;
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
public abstract class Resource extends RTSprite {
	
	private Terrain myTerrain;

  public Resource(Pixmap image, Location center, Dimension size, Sound sound,
			int teamID, int health) {
		super(image, center, size, sound, teamID, health);
		// TODO Auto-generated constructor stub
	}



}