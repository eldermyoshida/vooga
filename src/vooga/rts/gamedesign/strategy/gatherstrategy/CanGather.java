package vooga.rts.gamedesign.strategy.gatherstrategy;

import java.util.ArrayList;
import java.util.List;

import vooga.rts.gamedesign.sprite.rtsprite.IGatherable;
import vooga.rts.gamedesign.sprite.rtsprite.Resource;

/**
 * This class implements GatherStrategy and is used as an instance in 
 * interactives for objects that are able to gather. This class holds the list
 * of resources the interactive gathers. And the gather method
 * will specify how the interactive will gather.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class CanGather implements GatherStrategy{
	private List<IGatherable> myResources = new ArrayList<IGatherable>();
	
	@Override
	public void gather(IGatherable g) {
		myResources.add(g);
		//TODO: check for if meeting certain goals probably??
	}
	
	/**
	 * Checks if the current resources makes the CanGather object legible for
	 * certain updates.
	 */
	public void goalCheck(){
		
	}

}
