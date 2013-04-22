package vooga.towerdefense.event;


public interface evented {
	
	public boolean eventTriggered(Event event);
	
	public void update(double elapsedTime, Event event);
	

}
