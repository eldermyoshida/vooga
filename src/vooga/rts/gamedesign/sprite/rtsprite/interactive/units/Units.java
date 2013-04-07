package gamedesign.sprite.rtsprite.interactive.units;

import gamedesign.Weapon;
import gamedesign.sprite.rtsprite.IMovable;
import gamedesign.sprite.rtsprite.interactive.Interactive;
import gamedesign.strategy.gatherstrategy.GatherStrategy;
import gamedesign.strategy.occupystrategy.OccupyStrategy;

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
public abstract class Units extends Interactive implements IMovable, GatherStrategy {

  public  List<Interactive> myKills;

  public GatherStrategy myGatherStrategy;

  public OccupyStrategy myOccupyStrategy;

}