package vooga.rts.manager;

import java.util.HashMap;

import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Unit;
import vooga.rts.player.IGameManagerObserver;
import vooga.rts.player.IProductionObserver;

public interface IManagerObservable {
	public void register(IGameManagerObserver o);
	public void unregister(IGameManagerObserver o);
	public void notifyGameManagerObserver(int playerID, HashMap<String, Integer> updatedResources);
}
