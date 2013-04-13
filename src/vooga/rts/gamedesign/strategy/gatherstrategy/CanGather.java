package vooga.rts.gamedesign.strategy.gatherstrategy;

import vooga.rts.gamedesign.sprite.rtsprite.interactive.IGatherable;

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
	
	private int myDamage;
	
	public CanGather(int damage) {
		myDamage = damage;
	}
	
	public void gatherResource (IGatherable g) {
		g.getGathered(this, myDamage);
	}
	
	/**
	 * Checks if the current resources makes the CanGather object legible for
	 * certain updates.
	 */
	public void goalCheck(){
		
	}

}
