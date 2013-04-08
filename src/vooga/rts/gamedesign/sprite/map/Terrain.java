package vooga.rts.gamedesign.sprite.map;

import java.awt.Dimension;

import vooga.rts.gamedesign.sprite.Sprite;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;

/**
 * An object that appears on the map such as a tree or rock.  This would also
 * account for raised or lowered ground (for example a mountain or lake).
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public abstract class Terrain extends Sprite {

 public int traverseID;

  public Integer level;
  
  public Terrain(Pixmap image, Location center, Dimension size) {
		super(image, center, size);
		// TODO Auto-generated constructor stub
	}

}