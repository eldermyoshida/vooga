package vooga.towerdefense.attributes;

import java.util.List;

public interface TargetTracker {
	public Targetable getTarget();
	
	public List<Targetable> getTargets();
	
	public void aimAtTarget();
	
	public void actOnTarget();
	
	public void addTarget();
}
