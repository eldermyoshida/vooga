package vooga.rts.gamedesign.strategy;


/**
 * This interface acts as the common interface for all strategies.
 * Acts as a tag so that all strategies can be placed in the same collection.
 * @author Francesco Agosti
 *
 */
public interface Strategy {
	
	
	/**
	 * This will always return a new version of the strategy. This will be useful
	 * 
	 * @return a copy of the strategy
	 */
	public Strategy copy();

}
