package vooga.rts.gamedesign.sprite.rtsprite.interactive.buildings;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.IOccupiable;

import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;

import java.awt.Dimension;

/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class Garrison extends Building implements IOccupiable {

  public Garrison(Pixmap image, Location center, Dimension size, Sound sound,
			int teamID, int health) {
		super(image, center, size, sound, teamID, health);
		// TODO Auto-generated constructor stub
	}


}