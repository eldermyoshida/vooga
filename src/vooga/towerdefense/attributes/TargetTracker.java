package vooga.towerdefense.attributes;

import java.util.List;

import vooga.towerdefense.util.Location;

/**
 * Interface implemented by actions that act on Targetable objects.
 * 
 * @author XuRui
 *
 */

public interface TargetTracker {
	
	public List<Targetable> getTargetsInRange();
	
	public Location locateTarget(Targetable target);
	
	public void actOnTarget(Targetable target);

}
