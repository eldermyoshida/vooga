package vooga.rts.gamedesign.strategy.occupystrategy;

import vooga.rts.gamedesign.sprite.gamesprites.GameEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.buildings.Building;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Unit;


/**
 * 
 * This class implements OccupyStrategy and is used as an instance in 
 * interactives for objects that are not able to occupy IOccupiables.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class CannotBeOccupied implements OccupyStrategy{

	
	public void getOccupied(GameEntity entity, Unit u) {
		return;
	}

	public void addValidClassType(Unit u) {
		return;
	}


}
