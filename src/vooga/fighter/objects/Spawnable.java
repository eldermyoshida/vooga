package vooga.fighter.objects;

import vooga.fighter.util.Location;

public interface Spawnable {
	public void spawn(Location l);
	public void respawn();
}
