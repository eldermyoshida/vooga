package vooga.rts.gamedesign.strategy.gatherstrategy;

import vooga.rts.gamedesign.sprite.rtsprite.RTSprite;
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
	public void gather(Resource r) {
		//do nothing
	}

}
