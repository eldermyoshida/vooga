package vooga.rts.gamedesign.sprite.rtsprite.interactive;

import vooga.rts.gamedesign.strategy.gatherstrategy.GatherStrategy;

public interface IGatherable {
	
	public void getGathered(GatherStrategy gatherStrategy, int damage);

}
