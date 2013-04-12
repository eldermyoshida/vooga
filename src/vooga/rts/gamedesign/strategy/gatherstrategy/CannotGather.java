package vooga.rts.gamedesign.strategy.gatherstrategy;

import vooga.rts.gamedesign.sprite.rtsprite.interactive.IGatherable;
import vooga.rts.gamedesign.sprite.rtsprite.Resource;

/**
 * 
 * This class implements GatherStrategy and is used as an instance in 
 * interactives for objects that are not able to gather resources.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */

public class CannotGather implements GatherStrategy {
	

	@Override
	public boolean canGather(IGatherable g) {
		return false;
	}

}
