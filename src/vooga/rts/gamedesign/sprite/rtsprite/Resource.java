package vooga.rts.gamedesign.sprite.rtsprite;

import java.awt.Dimension;

import vooga.rts.gamedesign.sprite.GameEntity;
import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.gamedesign.sprite.map.Terrain;
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
public abstract class Resource extends GameEntity {


  public Resource(Pixmap image, Location center, Dimension size, int teamID, int health) {
		super(image, center, size, teamID, health);
		
	}
  
  public abstract void getGathered(InteractiveEntity e);



}