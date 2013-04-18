package vooga.towerdefense.event;


public interface evented {
	
	public boolean eventTriggered();
	
	public void update(double elapsedTime);
	

}
