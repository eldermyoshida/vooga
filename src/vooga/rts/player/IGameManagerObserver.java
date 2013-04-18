package vooga.rts.player;

import java.util.HashMap;

public interface IGameManagerObserver {
	public void updateResource(HashMap<String, Integer> updatedResources);
}
