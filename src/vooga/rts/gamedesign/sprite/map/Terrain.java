package gamedesign.sprite.map;

import gamedesign.sprite.Sprite;

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

}