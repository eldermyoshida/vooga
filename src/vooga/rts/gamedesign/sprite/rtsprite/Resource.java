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
public abstract class Resource extends GameEntity implements IGatherable {


  public Resource(Pixmap image, Location center, Dimension size, int teamID, int health) {
		super(image, center, size, teamID, health);
		
	}
  
  public abstract void getGathered(InteractiveEntity e);



}